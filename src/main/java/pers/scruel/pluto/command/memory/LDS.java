package pers.scruel.pluto.command.memory;

import pers.scruel.pluto.command.AbstractCommand;
import pers.scruel.pluto.content.RuntimeContent;

/**
 * LDS <reg1>, <reg2>
 * Load SRAM: Load the value of the address `reg2` in the SRAM to the register `reg1` in the SRAM.
 *
 * @author Scruel Tao <scruelt@hotmail.com>
 * @date 2022/1/19
 */
public class LDS extends AbstractCommand {
  private static final String NAME = "LDS";
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
    int address = runtimeContent.readRegister(this.reg2);
    int v = runtimeContent.loadSRAM(address);
    runtimeContent.setRegister(this.reg1, v);
  }
}
