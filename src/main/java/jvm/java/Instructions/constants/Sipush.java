package jvm.java.Instructions.constants;

import jvm.java.Instructions.Instruction;
import jvm.java.runtime.CodeReader;
import jvm.java.runtime.StackFrame;

/**
 * Created by admin on 2016/12/29.
 */
public class Sipush extends Instruction {

    int shortValue;
    public Sipush() {
        this.name = "sipush";
        this.bc = 0x11 ;  // 17
    }

    @Override
    public void fetchOperands(CodeReader codeReader) {
        shortValue = codeReader.readShort();
    }

    @Override
    public void execute(StackFrame stackFrame) {
        stackFrame.getOperandStack().pushInt(shortValue);
    }
}
