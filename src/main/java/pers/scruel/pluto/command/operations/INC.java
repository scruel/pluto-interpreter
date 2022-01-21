package pers.scruel.pluto.command.operations;

/**
 * INC <reg>
 * Increment: Increase the value of `reg` by 1. If over 255, set 0 and set
 * the value of the status register to 1, otherwise 0.
 *
 * @author Scruel Tao <scruelt@hotmail.com>
 * @date 2022/1/19
 */
public class INC extends AbstractOperationAdd {
  private static final String NAME = "INC";

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
    super.setReg(args[0]);
    super.setValue(1);
  }
}
