package pers.scruel.pluto.command.operations;

import pers.scruel.pluto.content.RuntimeContent;

/**
 * SUB <reg>, <int>
 * Sub: Substract `int` value to the value of `reg`. If under 0, set 255 and
 *      set the value of the status register to 1, otherwise 0.
 *
 * @author Scruel Tao <scruelt@hotmail.com>
 * @date 2022/1/19
 */
public class SUB extends AbstractOperationAdd {
  private static final String NAME = "SUB";

  @Override
  public String getName() {
    return NAME;
  }

  @Override
  public Integer getArgsLength() {
    return 2;
  }

  @Override
  public void parseArgs(String[] args) {
    super.setReg(args[0]);
    super.setValue(-Integer.parseInt(args[1]));
  }

  @Override
  public void doExecute(RuntimeContent runtimeContent) {
  }
}
