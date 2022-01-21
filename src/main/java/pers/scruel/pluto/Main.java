package pers.scruel.pluto;

import pers.scruel.pluto.compile.CommandParser;
import pers.scruel.pluto.content.CommandContent;
import pers.scruel.pluto.content.RuntimeContent;
import pers.scruel.pluto.executor.PlutoExecutor;
import pers.scruel.pluto.executor.impl.PlutoExecutorImpl;
import pers.scruel.pluto.reader.InputReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author Scruel Tao <scruelt@hotmail.com>
 * @date 2022/1/19
 */
public class Main {
  private static final String FILE_COMMAND = "-f";
  private static final String HELP_COMMAND = "-h";
  private static final String DEBUG_COMMAND = "-v";

  static {
    System.setProperty("org.slf4j.simpleLogger.log.org.reflections", "off");
  }

  public static void main(String[] args) throws Exception {
    if (args.length == 0) {
      printUsage();
    }
    String filePath = null;
    for (int i = 0; i < args.length; i++) {
      String command = args[i];
      if (HELP_COMMAND.equals(command)) {
        printUsage();
      }
      if (DEBUG_COMMAND.equals(command)) {
        System.setProperty("org.slf4j.simpleLogger.log.pers.scruel", "debug");
      }
      else if (FILE_COMMAND.equals(command)) {
        filePath = args[++i];
      }
    }
    if (null == filePath) {
      printUsage();
    }
    executePluto(filePath);
  }

  private static void executePluto(String filePath) throws FileNotFoundException {
    // reader the pluto file
    FileInputStream fileInputStream = new FileInputStream(filePath);
    InputReader reader = new InputReader(fileInputStream);
    // compile to command
    CommandParser parser = new CommandParser(reader);
    CommandContent commandContent = parser.parse();
    // executor all methods(labels)
    RuntimeContent runtimeContent = new RuntimeContent(commandContent);
    PlutoExecutor executor = new PlutoExecutorImpl(runtimeContent);
    executor.execute();
  }

  private static void printUsage() {
    System.err.println("Usage: pluto interpreter command");
    System.err.println("interpreter.jar [-f <path>] [-h] [-v]");
    System.err.println("  -f\t execution the interpreter with file.");
    System.err.println("  -h\t this message.");
    System.err.println("  -v\t debug mode.");
    System.exit(0);
  }
}
