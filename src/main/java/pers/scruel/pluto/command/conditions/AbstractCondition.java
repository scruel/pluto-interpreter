package pers.scruel.pluto.command.conditions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pers.scruel.pluto.command.AbstractCommand;
import pers.scruel.pluto.content.RuntimeContent;

/**
 * @author Scruel Tao <scruelt@hotmail.com>
 * @date 2022/1/19
 */
public abstract class AbstractCondition extends AbstractCommand {
  private static final Logger log = LoggerFactory.getLogger(AbstractCondition.class);

  private String labelName;

  /**
   * Specify when should execute
   *
   * @return supported status
   */
  protected abstract int getSupportedStatus();

  @Override
  public Integer getArgsLength() {
    return 1;
  }

  @Override
  public void parseArgs(String[] args) {
    labelName = args[0];
  }

  @Override
  public boolean supports(RuntimeContent runtimeContent) {
    int i = runtimeContent.readSREG();
    return i == getSupportedStatus();
  }

  @Override
  public boolean keepLineNumber(RuntimeContent runtimeContent) {
    return this.supports(runtimeContent);
  }

  @Override
  public void doExecute(RuntimeContent runtimeContent) {
    log.debug("Calling {} to {}", getName(), labelName);
    Integer lineNumber = runtimeContent.getCommandContent().getLabelLineNumber(labelName);
    runtimeContent.setCurrentAddress(lineNumber);
  }
}
