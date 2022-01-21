package pers.scruel.pluto.command.instructions;

import pers.scruel.pluto.command.AbstractCommand;
import pers.scruel.pluto.content.RuntimeContent;

/**
 * MOV <reg1>, <reg2>
 * Move: Copy the content of `reg2` to `reg1`.
 *
 * @author Scruel Tao <scruelt@hotmail.com>
 * @date 2022/1/19
 */
public class MOV extends AbstractCommand {
  private static final String NAME = "MOV";
  private String reg1;
  private String reg2;

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
    this.reg1 = args[0];
    this.reg2 = args[1];
  }

  @Override
  public void doExecute(RuntimeContent runtimeContent) {
    runtimeContent.setRegister(reg1, runtimeContent.readRegister(reg2));
  }
}
