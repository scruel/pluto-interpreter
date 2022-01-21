```text
;------------------------------------------------------------------------------
;                           Language interpreter challenge!
;
;                                      Pluto
;                                       the
;                              Pseudo assembly language
;------------------------------------------------------------------------------
;
; The goal of this challenge is to create an interpreter for the language
; Pluto.
;
; You can use the language of your choice and create a program that will
; open this file and execute the instructions inside it.
;
; Specificity of the language:
; ----------------------------
;
; * Labels
;   The language contains `label` ending with a ':'. These labels are used to
;   define a position in the program that the ordinal counter can 'go to', be 
;   careful, there is no 'method stack' which need to do 'go back' job, and
;   do not treat this as a 'method', check "Execution flow" part for sure.
;
; * Comments
;   Everything after the character ';' are comments and must be ignored by the
;   interpreter
;
; * Execution flow
;   The 'main' label is the entrypoint of the program, this section will be
;   executed first.
;   The program must exit with 'exit 0'
;   Spacing should be ignored also (extra tabs and spaces).
;   The execution of the program is from the top to the bottom.
;
;   Note: If you called 'go to' without have any 'go back' instructions, remain code
;   that below the 'go to' instruction which inside the label will not be executed, 
;   be aware of label is not a method!
;
; * Registers/Flags/SRAM
;   The interpreter must provide some registers available during the execution
;   of the program.
;   - R0, R1, R2, R3: 8 bits registers interim storage available in read/write
;   - SREG: 8 bits status register in readonly (output of comparisons)
;   The interpreter will include a memory space (SRAM) of 1024 bytes to store
;   data, and a stack of 16 bytes.
;
; * Instructions set
;   - RCALL <label>
;     Routine call: Jump to a section of the program designated by its label.
;   - RET
;     Return: Used at the end of a routine call to go back.
;   - LDI <reg>, <int>
;     Load immediate: set the integer value `int` to the register `reg` (8 bits).
;   - MOV <reg1>, <reg2>
;     Move: Copy the content of `reg2` to `reg1`.
;   - CLR <reg>
;     Clear: Set a register to 0.
;   - EXT <int>
;     Exit: Stop the program with the code `int`(exit as soon as possible).
;   Operations:
;   - INC <reg>
;     Increment: Increase the value of `reg` by 1. If over 255, set 0 and set
;                the value of the status register to 1, otherwise 0.
;   - ADD <reg>, <int>
;     Add: Add `int` value to the value of `reg`. If over 255, set 0 and set
;                the value of the status register to 1, otherwise 0.
;   - SUB <reg>, <int>
;     Sub: Substract `int` value to the value of `reg`. If under 0, set 255 and
;          set the value of the status register to 1, otherwise 0.
;   - AND <reg1>, <reg2>
;     And comparator between `reg1` and `reg2`. If equals set status register
;     to 1, 0 otherwise.
;   - OR <reg1>, <reg2>
;     Or comparator between `reg1` and `reg2`. If not equals set status register
;     to 1, 0 otherwise.
;   Conditions:
;   - BRNE <label>
;     Branch Not Equal: Jump to the label if the status register is equal to 1.
;   - BREQ <label>
;     Branch Equal: Jump to the label if the status register is equal to 0.
;   Memory:
;   - STS <reg1>, <reg2>
;     Store SRAM: Store the value of the register `reg2` at the address `reg1` in
;     the SRAM.
;   - LDS <reg1>, <reg2>
;     Load SRAM: Load the value of the address `reg2` in the SRAM to the register
;     `reg1` in the SRAM.
;   - PUSH <reg>
;     Push the value inside `reg` to the stack
;   - POP <reg>
;     Pop the value on top of the stack and store it into `reg`.
;   Display:
;   - PTC <reg>
;     Print char: Print the value of `reg` as character
;   - PTI <reg>
;     Print integer: Print the value of `reg` as integer.
;

```
