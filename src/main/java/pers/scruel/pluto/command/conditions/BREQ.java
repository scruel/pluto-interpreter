package pers.scruel.pluto.command.conditions;

import pers.scruel.pluto.constant.PlutoConstant;

/**
 * BREQ <label>
 * Branch Equal: Jump to the label if the status register is equal to 0.
 *
 * @author Scruel Tao <scruelt@hotmail.com>
 * @date 2022/1/19
 */
public class BREQ extends AbstractCondition {
  private static final String NAME = "BREQ";

  @Override
  public String getName() {
    return NAME;
  }

  @Override
  protected int getSupportedStatus() {
    return PlutoConstant.STATUS_ZERO;
  }

}
