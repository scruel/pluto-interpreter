package pers.scruel.pluto.util;

import pers.scruel.pluto.exception.ValueOutOfRangeException;

/**
 * @author Scruel Tao <scruelt@hotmail.com>
 * @date 2022/1/20
 */
public class ValueUtils {
  private ValueUtils() {
  }

  public static void validIntValue(Integer integer) {
    if (integer == null || integer < 0 || integer > 255) {
      throw new ValueOutOfRangeException();
    }
  }

  public static int intAnd(int v1, int v2) {
    int res = v1 + v2;
    if (res > 255) {
      return 0;
    }
    if (res < 0) {
      return 255;
    }
    return res;
  }

  public static void doExit(int code) {
    System.err.printf("%nProgram exit with %s%n", code);
    System.exit(code);
  }
}
