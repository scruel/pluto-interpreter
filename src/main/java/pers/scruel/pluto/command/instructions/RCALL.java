package pers.scruel.pluto.command.instructions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pers.scruel.pluto.command.AbstractCommand;
import pers.scruel.pluto.content.RuntimeContent;

/**
 * RCALL <label>
 * Routine call: Jump to a section of the program designated by its label.
 *
 * @author Scruel Tao <scruelt@hotmail.com>
 * @date 2022/1/19
 */
public class RCALL extends AbstractCommand {
  private static final Logger log = LoggerFactory.getLogger(RCALL.class);

  private static final String NAME = "RCALL";
  private String labelName;

  @Override
  public void parseArgs(String[] args) {
    labelName = args[0];
  }

  @Override
  public String getName() {
    return NAME;
  }

  @Override
  public Integer getArgsLength() {
    return 1;
  }

  @Override
  public boolean keepLineNumber(RuntimeContent runtimeContent) {
    return true;
  }

  @Override
  public void doExecute(RuntimeContent runtimeContent) {
    log.debug("Calling {}", labelName);
    Integer lineNumber = runtimeContent.getCommandContent().getLabelLineNumber(labelName);
    // store the current invoke
    runtimeContent.setLastCallingAddress(runtimeContent.getCurrentAddress());
    // goto the label
    runtimeContent.setCurrentAddress(lineNumber);
  }
}
