package pers.scruel.pluto.command.instructions;

import pers.scruel.pluto.command.AbstractCommand;
import pers.scruel.pluto.content.RuntimeContent;

/**
 * CLR <reg>
 * Clear: Set a register to 0.
 *
 * @author Scruel Tao <scruelt@hotmail.com>
 * @date 2022/1/19
 */
public class CLR extends AbstractCommand {
  private static final String NAME = "CLR";
  private String reg;

  @Override
  public String getName() {
    return NAME;
  }

  @Override
  public Integer getArgsLength() {
    return 1;
  }

  @Override
  public void parseArgs(String[] args) {
    this.reg = args[0];
  }

  @Override
  public void doExecute(RuntimeContent runtimeContent) {
    runtimeContent.setRegister(this.reg, 0);
  }
}
