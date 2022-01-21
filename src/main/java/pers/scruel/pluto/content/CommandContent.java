package pers.scruel.pluto.content;

import pers.scruel.pluto.command.Command;
import pers.scruel.pluto.exception.LabelNotFoundException;
import pers.scruel.pluto.util.ValueUtils;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Scruel Tao <scruelt@hotmail.com>
 * @date 2022/1/20
 */
public class CommandContent {
  private final Map<String, Integer> labelLineNumberMap = new HashMap<>();
  private final List<Command> commandList = new LinkedList<>();

  public void addCommand(Command command) {
    commandList.add(command);
  }

  public Command getCommandByLineNumber(int linNumber) {
    if (linNumber >= commandList.size()) {
      ValueUtils.doExit(1);
    }
    return commandList.get(linNumber);
  }

  public void putLabelLineNumber(String name, Integer index) {
    labelLineNumberMap.put(name, index);
  }

  public Integer getLabelLineNumber(String name) {
    validCommandName(name);
    return labelLineNumberMap.get(name);
  }

  private void validCommandName(String name) {
    if (!labelLineNumberMap.containsKey(name)) {
      throw new LabelNotFoundException("Label" + name + "not found");
    }
  }
}
