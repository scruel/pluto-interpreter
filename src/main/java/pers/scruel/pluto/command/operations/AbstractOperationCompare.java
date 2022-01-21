package pers.scruel.pluto.command.operations;

import pers.scruel.pluto.command.AbstractCommand;
import pers.scruel.pluto.content.RuntimeContent;

/**
 * @author Scruel Tao <scruelt@hotmail.com>
 * @date 2022/1/19
 */
public abstract class AbstractOperationCompare extends AbstractCommand {
  private String reg1;
  private String reg2;

  @Override
  public Integer getArgsLength() {
    return 2;
  }

  @Override
  public void parseArgs(String[] args) {
    this.reg1 = args[0];
    this.reg2 = args[1];
  }

  @Override
  public void doExecute(RuntimeContent runtimeContent) {
    int v1 = runtimeContent.readRegister(this.reg1);
    int v2 = runtimeContent.readRegister(this.reg2);
    runtimeContent.writeSREG(getSREGValue(v1, v2));
  }

  protected abstract int getSREGValue(int v1, int v2);
}
