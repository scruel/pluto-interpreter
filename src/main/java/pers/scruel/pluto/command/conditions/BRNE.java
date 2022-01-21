package pers.scruel.pluto.command.conditions;

import pers.scruel.pluto.constant.PlutoConstant;

/**
 * BRNE <label>
 * Branch Not Equal: Jump to the label if the status register is equal to 1.
 *
 * @author Scruel Tao <scruelt@hotmail.com>
 * @date 2022/1/19
 */
public class BRNE extends AbstractCondition {
  private static final String NAME = "BRNE";

  @Override
  public String getName() {
    return NAME;
  }

  @Override
  protected int getSupportedStatus() {
    return PlutoConstant.STATUS_ONE;
  }

}
