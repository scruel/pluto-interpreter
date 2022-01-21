package pers.scruel.pluto.exception;

/**
 * @author Scruel Tao <scruelt@hotmail.com>
 * @date 2022/1/19
 */
public abstract class PlutoException extends RuntimeException {
  public PlutoException() {
    super();
  }

  public PlutoException(String s) {
    super(s);
  }
}
