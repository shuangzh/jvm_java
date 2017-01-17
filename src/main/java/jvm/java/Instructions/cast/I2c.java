package jvm.java.Instructions.cast;

import jvm.java.Instructions.Instruction;
import jvm.java.runtime.CodeReader;
import jvm.java.runtime.StackFrame;

/**
 * Created by admin on 2017/1/17.
 */
public class I2c extends Instruction {
    public I2c() {
        this.name = "i2c";
        this.bc = 0x92;
    }

    @Override
    public void fetchOperands(CodeReader codeReader) {
        //
    }

    @Override
    public void execute(StackFrame stackFrame) {
        int i = stackFrame.getOperandStack().popInt();
        char c = (char) i;
        stackFrame.getOperandStack().pushInt(c);
    }
}
