package pers.scruel.pluto.reader;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Scruel Tao
 * @version 1.0
 */
public class InputReader {
  private static final String CHARSET_NAME = "UTF-8";
  private final BufferedReader reader;
  private StringTokenizer tokenizer;

  public InputReader(InputStream stream) {
    tokenizer = null;
    try {
      reader = new BufferedReader(new InputStreamReader(stream, CHARSET_NAME), 32768);
    } catch (UnsupportedEncodingException e) {
      throw new RuntimeException(e);
    }
  }

  public String readLine() {
    if (tokenizer != null && tokenizer.hasMoreTokens()) {
      throw new RuntimeException("Could not read new line during line operations.");
    }
    try {
      return reader.readLine();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
