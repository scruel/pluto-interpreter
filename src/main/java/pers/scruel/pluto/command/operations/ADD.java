package pers.scruel.pluto.command.operations;

/**
 * ADD <reg>, <int>
 * Add: Add `int` value to the value of `reg`. If over 255, set 0 and set
 *      the value of the status register to 1, otherwise 0.
 *
 * @author Scruel Tao <scruelt@hotmail.com>
 * @date 2022/1/19
 */
public class ADD extends AbstractOperationAdd {
  private static final String NAME = "ADD";

  @Override
  public String getName() {
    return NAME;
  }

  @Override
  public Integer getArgsLength() {
    return 2;
  }

}
