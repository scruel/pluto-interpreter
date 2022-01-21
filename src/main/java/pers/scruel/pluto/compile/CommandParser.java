package pers.scruel.pluto.compile;

import pers.scruel.pluto.command.Command;
import pers.scruel.pluto.constant.PlutoConstant;
import pers.scruel.pluto.content.CommandContent;
import pers.scruel.pluto.provider.CommandProvider;
import pers.scruel.pluto.reader.InputReader;

import java.util.Arrays;

/**
 * @author Scruel Tao <scruelt@hotmail.com>
 * @date 2022/1/20
 */
public class CommandParser {
  private final InputReader reader;

  public CommandParser(InputReader reader) {
    this.reader = reader;
  }

  public CommandContent parse() {
    CommandContent content = new CommandContent();
    String line;
    int lineAddress = 0;
    while ((line = reader.readLine()) != null) {
      line = removeComments(line).trim();
      if (line.isEmpty()) {
        continue;
      }
      if (isLabel(line)) {
        content.putLabelLineNumber(getLabelName(line), lineAddress);
      }
      else {
        Command command = parseCommand(line);
        content.addCommand(command);
        lineAddress++;
      }
    }
    return content;
  }

  private Command parseCommand(String line) {
    String[] split = line.split(PlutoConstant.COMMAND_SPILT_SYMBOL);
    Command command = CommandProvider.getNoArgsCommand(split[0]);
    String[] args = Arrays.stream(split)
        .skip(1)
        .map(a -> a.replace(PlutoConstant.COMMAND_SPILT_IGNORE_SYMBOL, "").trim())
        .toArray(String[]::new);
    command.validArgs(args);
    command.setArgs(args);
    return command;
  }

  private boolean isLabel(String line) {
    return line.endsWith(PlutoConstant.LABEL_SYMBOL);
  }

  private String getLabelName(String line) {
    String[] split = line.split(PlutoConstant.LABEL_SYMBOL);
    return split[0];
  }

  private String removeComments(String line) {
    String[] split = line.split(PlutoConstant.COMMENT_SYMBOL);
    return split[0];
  }
}
