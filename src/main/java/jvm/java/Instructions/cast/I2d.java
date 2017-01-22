package jvm.java.Instructions.cast;

import jvm.java.Instructions.Instruction;
import jvm.java.runtime.CodeReader;
import jvm.java.runtime.StackFrame;

/**
 * Created by admin on 2017/1/22.
 */
public class I2d extends Instruction {

    public I2d() {
        this.name = "i2d";
        this.bc = 135;
    }

    @Override
    public void fetchOperands(CodeReader codeReader) {
        //
    }

    @Override
    public void execute(StackFrame stackFrame) {
        int value = stackFrame.getOperandStack().popInt();
        double ret = value;
        stackFrame.getOperandStack().pushDouble(ret);
    }
}
