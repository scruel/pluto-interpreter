package pers.scruel.pluto.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pers.scruel.pluto.constant.PlutoConstant;
import pers.scruel.pluto.content.RuntimeContent;

/**
 * @author Scruel Tao <scruelt@hotmail.com>
 * @date 2022/1/19
 */
public abstract class AbstractCommand implements Command {
  private static final Logger log = LoggerFactory.getLogger(AbstractCommand.class);

  private String[] args;

  @Override
  public void setArgs(String[] args) {
    this.args = args;
    parseArgs(args);
  }

  @Override
  public void execute(RuntimeContent runtimeContent) {
    log.debug("After {}", this);
    if (this.supports(runtimeContent)) {
      doExecute(runtimeContent);
    }

    log.debug("R0:{}, R1:{}, R2:{}, R3:{}, SREG:{}, STACK-TOP:{}",
        runtimeContent.readRegister(PlutoConstant.REGISTER_R0_NAME),
        runtimeContent.readRegister(PlutoConstant.REGISTER_R1_NAME),
        runtimeContent.readRegister(PlutoConstant.REGISTER_R2_NAME),
        runtimeContent.readRegister(PlutoConstant.REGISTER_R3_NAME),
        runtimeContent.readSREG(),
        runtimeContent.peekStack()
    );
    int address = runtimeContent.getCurrentAddress();
    if (!this.keepLineNumber(runtimeContent)) {
      runtimeContent.setCurrentAddress(++address);
    }
    // invoke next command in command list
    runtimeContent.getCommandContent().getCommandByLineNumber(address)
        .execute(runtimeContent);
  }

  /**
   * Execute the command implemented by the subclassed.
   *
   * @param runtimeContent runtime content
   */
  protected abstract void doExecute(RuntimeContent runtimeContent);

  /**
   * set arguments
   *
   * @param args command arguments
   */
  protected void parseArgs(String[] args) {
  }

  @Override
  public String toString() {
    return String.format("%s %s", getName(), String.join(", ", this.args));
  }
}
