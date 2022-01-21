package pers.scruel.pluto.command.memory;

import pers.scruel.pluto.command.AbstractCommand;
import pers.scruel.pluto.content.RuntimeContent;

/**
 * POP <reg>
 * Pop the value on top of the stack and store it into `reg`.
 *
 * @author Scruel Tao <scruelt@hotmail.com>
 * @date 2022/1/19
 */
public class POP extends AbstractCommand {
  private static final String NAME = "POP";
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
    int v = runtimeContent.popStack();
    runtimeContent.setRegister(this.reg, v);
  }
}
