package pers.scruel.pluto.constant;

/**
 * @author Scruel Tao <scruelt@hotmail.com>
 * @date 2022/1/20
 */
public interface PlutoConstant {
  // =============== symbols ===============

  String LABEL_SYMBOL = ":";
  String COMMENT_SYMBOL = ";";
  String COMMAND_SPILT_SYMBOL = " ";
  String COMMAND_SPILT_IGNORE_SYMBOL = ",";

  // =============== names ===============

  String ENTRYPOINT_LABEL_NAME = "main";
  String REGISTER_R0_NAME = "R0";
  String REGISTER_R1_NAME = "R1";
  String REGISTER_R2_NAME = "R2";
  String REGISTER_R3_NAME = "R3";

  // =============== values ===============

  int MAX_SRAM_LENGTH = 1024 / 8;
  int MAX_STACK_LENGTH = 16;
  int STATUS_ZERO = 0;
  int STATUS_ONE = 1;

}
