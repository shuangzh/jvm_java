package jvm.java.Instructions.cast;

import jvm.java.Instructions.Instruction;
import jvm.java.runtime.CodeReader;
import jvm.java.runtime.StackFrame;

/**
 * Created by admin on 2017/1/17.
 */
public class I2s extends Instruction {

    public I2s() {
        this.name = "i2s";
        this.bc = 0x93 ;
    }

    @Override
    public void fetchOperands(CodeReader codeReader) {
        //
    }

    @Override
    public void execute(StackFrame stackFrame) {
        int i = stackFrame.getOperandStack().popInt();
        short s = (short) i;
        stackFrame.getOperandStack().pushInt(s);
    }
}
