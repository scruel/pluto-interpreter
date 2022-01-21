package pers.scruel.pluto.command.instructions;

import pers.scruel.pluto.command.AbstractCommand;
import pers.scruel.pluto.content.RuntimeContent;
import pers.scruel.pluto.util.ValueUtils;

/**
 * LDI <reg>, <int>
 * Load immediate: set the integer value `int` to the register `reg` (8 bits).
 *
 * @author Scruel Tao <scruelt@hotmail.com>
 * @date 2022/1/19
 */
public class LDI extends AbstractCommand {
  private static final String NAME = "LDI";
  private String regName;
  private int value;

  @Override
  public String getName() {
    return NAME;
  }

  @Override
  public Integer getArgsLength() {
    return 2;
  }

  @Override
  public void validArgs(String[] args) {
    super.validArgs(args);
    Integer integer = Integer.parseInt(args[1]);
    ValueUtils.validIntValue(integer);
  }

  @Override
  public void parseArgs(String[] args) {
    this.regName = args[0];
    this.value = Integer.parseInt(args[1]);
  }

  @Override
  public void doExecute(RuntimeContent runtimeContent) {
    runtimeContent.setRegister(this.regName, this.value);
  }
}
