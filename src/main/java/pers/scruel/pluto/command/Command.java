package pers.scruel.pluto.command;

import pers.scruel.pluto.content.RuntimeContent;
import pers.scruel.pluto.exception.PlutoException;

/**
 * @author Scruel Tao <scruelt@hotmail.com>
 * @date 2022/1/19
 */
public interface Command extends Cloneable {
  /**
   * Get the command name
   *
   * @return command name
   */
  String getName();

  /**
   * Should or not should do the execution
   *
   * @param runtimeContent runtime content
   * @return is valid for executing the command
   */
  default boolean supports(RuntimeContent runtimeContent) {
    return true;
  }

  /**
   * Execute the command
   * throw {@link PlutoException} if occur any error.
   *
   * @param runtimeContent runtime content
   */
  void execute(RuntimeContent runtimeContent);

  /**
   * Go back and skip the remain commands of the current label.
   *
   * @return should or not should return
   * @param runtimeContent runtime content
   */
  default boolean keepLineNumber(RuntimeContent runtimeContent) {
    return false;
  }

  /**
   * Valid the arguments of current command,
   * throw {@link PlutoException} if occur any error.
   *
   * @param args command arguments
   */
  default void validArgs(String[] args) {
    Integer argsLength = getArgsLength();
    if (argsLength != null && args.length != argsLength) {
      throw new IllegalArgumentException();
    }
  }

  /**
   * set arguments
   *
   * @param args command arguments
   */
  default void setArgs(String[] args){
  }

  /**
   * Specify that how many arguments should parse.
   *
   * @return length of arguments list
   */
  default Integer getArgsLength() {
    return null;
  }
}
