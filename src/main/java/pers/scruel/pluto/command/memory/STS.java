package pers.scruel.pluto.command.memory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pers.scruel.pluto.command.AbstractCommand;
import pers.scruel.pluto.content.RuntimeContent;

/**
 * {@code STS <reg1>, <reg2>}
 * Store SRAM: Store the value of the register `reg2` at the address `reg1` in
 * the SRAM.
 *
 * @author Scruel Tao <scruelt@hotmail.com>
 * @date 2022/1/19
 */
public class STS extends AbstractCommand {
  private static final Logger log = LoggerFactory.getLogger(STS.class);

  private static final String NAME = "STS";
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
    int v = runtimeContent.readRegister(this.reg2);
    int address = runtimeContent.readRegister(this.reg1);
    runtimeContent.storeSRAM(address, v);
    log.debug("SRAM[{}]={}", address, runtimeContent.loadSRAM(address));
  }
}
