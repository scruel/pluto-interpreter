package pers.scruel.pluto.executor.impl;

import pers.scruel.pluto.constant.PlutoConstant;
import pers.scruel.pluto.content.CommandContent;
import pers.scruel.pluto.content.RuntimeContent;
import pers.scruel.pluto.executor.PlutoExecutor;

/**
 * @author Scruel Tao <scruelt@hotmail.com>
 * @date 2022/1/20
 */
public class PlutoExecutorImpl implements PlutoExecutor {
  private final RuntimeContent runtimeContent;

  public PlutoExecutorImpl(RuntimeContent runtimeContent) {
    this.runtimeContent = runtimeContent;
  }

  @Override
  public void execute() {
    CommandContent commandContent = runtimeContent.getCommandContent();
    Integer mainLineNumber = commandContent.getLabelLineNumber(PlutoConstant.ENTRYPOINT_LABEL_NAME);
    runtimeContent.setCurrentAddress(mainLineNumber);
    commandContent.getCommandByLineNumber(mainLineNumber)
        .execute(runtimeContent);
  }
}
