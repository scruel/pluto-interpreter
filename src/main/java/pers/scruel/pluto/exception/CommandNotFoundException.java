package pers.scruel.pluto.exception;

/**
 * @author Scruel Tao <scruelt@hotmail.com>
 * @date 2022/1/19
 */
public class CommandNotFoundException extends PlutoException {
  public CommandNotFoundException(String s) {
    super(s);
  }
}
