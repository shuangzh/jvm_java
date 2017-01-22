package jvm.java.Instructions.cast;

import jvm.java.Instructions.Instruction;
import jvm.java.runtime.CodeReader;
import jvm.java.runtime.StackFrame;

/**
 * Created by admin on 2017/1/22.
 */
public class I2l extends Instruction{

    public I2l() {
        this.name = "i2l";
        this.bc = 133;
    }

    @Override
    public void fetchOperands(CodeReader codeReader) {
        //
    }

    @Override
    public void execute(StackFrame stackFrame) {
        int value = stackFrame.getOperandStack().popInt();
        long ret = value;
        stackFrame.getOperandStack().pushLong(ret);
    }
}
