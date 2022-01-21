package pers.scruel.pluto.command.display;

/**
 * PTI <reg>
 * Print integer: Print the value of `reg` as integer.
 *
 * @author Scruel Tao <scruelt@hotmail.com>
 * @date 2022/1/19
 */
public class PTI extends AbstractDisplay {
  private static final String NAME = "PTI";

  @Override
  public String getName() {
    return NAME;
  }

  @Override
  protected Object getValueForDisplay(int i) {
    return i;
  }
}
