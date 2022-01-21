package pers.scruel.pluto.content;

import pers.scruel.pluto.constant.PlutoConstant;
import pers.scruel.pluto.exception.MemoryOverflowException;
import pers.scruel.pluto.exception.RegisterNotFoundException;
import pers.scruel.pluto.exception.StackOverflowException;
import pers.scruel.pluto.exception.UndefinedAccessException;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author Scruel Tao <scruelt@hotmail.com>
 * @date 2022/1/19
 */
public class RuntimeContent {
  private final CommandContent commandContent;
  /**
   * some registers available during the execution of the program.
   */
  private final Map<String, Integer> REGISTERS = new HashMap<>();
  /**
   * a memory space (SRAM) of 1024 bytes to store data
   */
  private final Integer[] SRAM = new Integer[PlutoConstant.MAX_SRAM_LENGTH];
  /**
   * a stack of 16 bytes
   */
  private final Stack<Integer> STACK = new Stack<>();
  /**
   * 8 bits status register in readonly (output of comparisons)
   */
  private Integer SREG = 0;
  private int currentAddress = 0;
  private int lastCallingAddress = 0;

  public int getLastCallingAddress() {
    return lastCallingAddress;
  }

  public void setLastCallingAddress(int lastCallingAddress) {
    this.lastCallingAddress = lastCallingAddress;
  }

  public int getCurrentAddress() {
    return currentAddress;
  }

  public void setCurrentAddress(int currentAddress) {
    this.currentAddress = currentAddress;
  }

  public RuntimeContent(CommandContent commandContent) {
    this.commandContent = commandContent;
    // should we set default values?
    this.REGISTERS.put(PlutoConstant.REGISTER_R0_NAME, 0);
    this.REGISTERS.put(PlutoConstant.REGISTER_R1_NAME, 0);
    this.REGISTERS.put(PlutoConstant.REGISTER_R2_NAME, 0);
    this.REGISTERS.put(PlutoConstant.REGISTER_R3_NAME, 0);
  }

  public int readSREG() {
    return SREG;
  }

  public void writeSREG(int SREG) {
    this.SREG = SREG;
  }

  public CommandContent getCommandContent() {
    return this.commandContent;
  }

  public int readRegister(String name) {
    if (!this.REGISTERS.containsKey(name)) {
      throw new RegisterNotFoundException(name + "register not found");
    }
    Integer res = this.REGISTERS.get(name);
    if (null == res) {
      throw new UndefinedAccessException(name + "register undefined");
    }
    return res;
  }

  public void setRegister(String name, int val) {
    if (!this.REGISTERS.containsKey(name)) {
      throw new RegisterNotFoundException(name + "register not found");
    }
    this.REGISTERS.put(name, val);
  }

  public void pushStack(int value) {
    if (this.STACK.size() >= PlutoConstant.MAX_STACK_LENGTH) {
      throw new StackOverflowException();
    }
    this.STACK.push(value);
  }

  public int popStack() {
    return this.STACK.pop();
  }

  public Integer peekStack() {
    if (this.STACK.isEmpty()) {
      return null;
    }
    return this.STACK.peek();
  }

  public void storeSRAM(int index, int value) {
    if (index >= PlutoConstant.MAX_SRAM_LENGTH) {
      throw new MemoryOverflowException();
    }
    this.SRAM[index] = value;
  }

  public int loadSRAM(int index) {
    if (index >= PlutoConstant.MAX_SRAM_LENGTH) {
      throw new MemoryOverflowException();
    }
    Integer res = this.SRAM[index];
    if (null == res) {
      throw new UndefinedAccessException(String.format("SRAM %s undefined", index));
    }
    return res;
  }
}
