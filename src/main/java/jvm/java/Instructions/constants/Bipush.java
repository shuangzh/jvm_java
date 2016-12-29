package jvm.java.Instructions.constants;

import jvm.java.Instructions.Instruction;
import jvm.java.runtime.CodeReader;
import jvm.java.runtime.StackFrame;

/**
 * Created by admin on 2016/12/29.
 */
public class Bipush  extends Instruction{

    int intValue;

    public Bipush() {
        this.name = "bipush";
        this.bc = 0x10;
    }

    @Override
    public void fetchOperands(CodeReader codeReader) {
        this.intValue = codeReader.readUnsignedByte();
    }

    @Override
    public void execute(StackFrame stackFrame) {
        stackFrame.getOperandStack().pushInt(intValue);
    }
}
