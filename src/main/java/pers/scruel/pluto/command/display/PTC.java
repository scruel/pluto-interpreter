package pers.scruel.pluto.command.display;

/**
 * PTC <reg>
 * Print char: Print the value of `reg` as character
 *
 * @author Scruel Tao <scruelt@hotmail.com>
 * @date 2022/1/19
 */
public class PTC extends AbstractDisplay {
  private static final String NAME = "PTC";

  @Override
  public String getName() {
    return NAME;
  }

  @Override
  protected Object getValueForDisplay(int i) {
    return (char) i;
  }
}
