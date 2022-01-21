package pers.scruel.pluto.command.instructions;

import pers.scruel.pluto.command.AbstractCommand;
import pers.scruel.pluto.content.RuntimeContent;

/**
 * RET
 * Return: Used at the end of a routine call to go back.
 *
 * @author Scruel Tao <scruelt@hotmail.com>
 * @date 2022/1/19
 */
public class RET extends AbstractCommand {
  private static final String NAME = "RET";

  @Override
  public String getName() {
    return NAME;
  }

  @Override
  public Integer getArgsLength() {
    return 0;
  }

  @Override
  public void doExecute(RuntimeContent runtimeContent) {
    runtimeContent.setCurrentAddress(runtimeContent.getLastCallingAddress());
  }
}
