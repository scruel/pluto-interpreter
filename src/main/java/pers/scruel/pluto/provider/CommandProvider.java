package pers.scruel.pluto.provider;

import org.reflections.Reflections;
import pers.scruel.pluto.command.Command;
import pers.scruel.pluto.exception.CommandNotFoundException;

import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Scruel Tao <scruelt@hotmail.com>
 * @date 2022/1/19
 */
public class CommandProvider {
  private static final Reflections REFLECTIONS = new Reflections("pers.scruel.pluto.command");
  private static final Map<String, Class<? extends Command>> COMMAND_MAP = new HashMap<>();

  static {
    Set<Class<? extends Command>> classes = REFLECTIONS.getSubTypesOf(Command.class);
    for (Class<? extends Command> clazz : classes) {
      if ((Modifier.isAbstract(clazz.getModifiers()))) {
        continue;
      }
      Command command = getInstance(clazz);
      // should bypass the composite class
      if (command != null && command.getName() != null) {
        COMMAND_MAP.put(command.getName(), clazz);
      }
    }
  }

  public static Command getNoArgsCommand(String name) {
    if (!COMMAND_MAP.containsKey(name)) {
      throw new CommandNotFoundException(name + "command not found.");
    }
    return getInstance(COMMAND_MAP.get(name));
  }

  private static Command getInstance(Class<? extends Command> clazz) {
    try {
      return clazz.newInstance();
    } catch (InstantiationException | IllegalAccessException e) {
      System.err.println("Error loading " + clazz.getName() + " command.");
      return null;
    }
  }
}
