package pers.scruel.pluto.command.operations;

import pers.scruel.pluto.command.AbstractCommand;
import pers.scruel.pluto.content.RuntimeContent;
import pers.scruel.pluto.util.ValueUtils;

/**
 *
 * @author Scruel Tao <scruelt@hotmail.com>
 * @date 2022/1/19
 */
public abstract class AbstractOperationAdd extends AbstractCommand {
  private String reg;
  private int value;

  @Override
  protected void parseArgs(String[] args) {
    this.reg = args[0];
    this.value = Integer.parseInt(args[1]);
  }

  public void setReg(String reg) {
    this.reg = reg;
  }

  public void setValue(int value) {
    this.value = value;
  }

  @Override
  public void doExecute(RuntimeContent runtimeContent) {
    int i = runtimeContent.readRegister(this.reg);
    int res = ValueUtils.intAnd(i, this.value);
    boolean b = res == i + this.value;
    runtimeContent.writeSREG(b ? 0 : 1);
    runtimeContent.setRegister(this.reg, res);
  }
}
