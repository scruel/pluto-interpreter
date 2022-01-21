package pers.scruel.pluto.command.operations;

/**
 * OR <reg1>, <reg2>
 * Or comparator between `reg1` and `reg2`.
 * If not equals set status register to 1, 0 otherwise.
 *
 * @author Scruel Tao <scruelt@hotmail.com>
 * @date 2022/1/19
 */
public class OR extends AbstractOperationCompare {
  private static final String NAME = "OR";

  @Override
  public String getName() {
    return NAME;
  }

  @Override
  protected int getSREGValue(int v1, int v2) {
    return v1 != v2 ? 1 : 0;
  }
}
