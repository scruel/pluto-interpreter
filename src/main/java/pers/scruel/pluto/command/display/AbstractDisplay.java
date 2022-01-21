package pers.scruel.pluto.command.display;

import pers.scruel.pluto.command.AbstractCommand;
import pers.scruel.pluto.content.RuntimeContent;

/**
 *
 * @author Scruel Tao <scruelt@hotmail.com>
 * @date 2022/1/19
 */
public abstract class AbstractDisplay extends AbstractCommand {
  private String regName;

  @Override
  public Integer getArgsLength() {
    return 1;
  }

  @Override
  public void parseArgs(String[] args) {
    regName = args[0];
  }

  protected String getRegName() {
    return regName;
  }

  @Override
  public void doExecute(RuntimeContent runtimeContent) {
    int i = runtimeContent.readRegister(getRegName());
    System.out.print(getValueForDisplay(i));
  }

  protected abstract Object getValueForDisplay(int i);
}
