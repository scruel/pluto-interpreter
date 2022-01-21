package pers.scruel.pluto.command.instructions;

import pers.scruel.pluto.command.AbstractCommand;
import pers.scruel.pluto.content.RuntimeContent;
import pers.scruel.pluto.util.ValueUtils;

/**
 * EXT <int>
 * Exit: Stop the program with the code `int`
 *
 * @author Scruel Tao <scruelt@hotmail.com>
 * @date 2022/1/19
 */
public class EXT extends AbstractCommand {
  private static final String NAME = "EXT";
  private Integer value;

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
    this.value = Integer.valueOf(args[0]);
  }

  @Override
  public void doExecute(RuntimeContent runtimeContent) {
    ValueUtils.doExit(value);
  }
}
