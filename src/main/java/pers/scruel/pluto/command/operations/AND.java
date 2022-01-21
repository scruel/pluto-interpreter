package pers.scruel.pluto.command.operations;

/**
 * AND <reg1>, <reg2>
 * And comparator between `reg1` and `reg2`.
 * If equals set status register to 1, 0 otherwise.
 *
 * @author Scruel Tao <scruelt@hotmail.com>
 * @date 2022/1/19
 */
public class AND extends AbstractOperationCompare {
  private static final String NAME = "AND";

  @Override
  public String getName() {
    return NAME;
  }

  @Override
  protected int getSREGValue(int v1, int v2) {
    return v1 == v2 ? 1 : 0;
  }
}
