package pers.scruel.pluto.command.memory;

import pers.scruel.pluto.command.AbstractCommand;
import pers.scruel.pluto.content.RuntimeContent;

/**
 * PUSH <reg>
 * Push the value inside `reg` to the stack
 *
 * @author Scruel Tao <scruelt@hotmail.com>
 * @date 2022/1/19
 */
public class PUSH extends AbstractCommand {
  private static final String NAME = "PUSH";
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
    int v = runtimeContent.readRegister(this.reg);
    runtimeContent.pushStack(v);
  }
}
