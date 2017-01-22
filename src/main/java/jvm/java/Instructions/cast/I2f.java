package jvm.java.Instructions.cast;

import jvm.java.Instructions.Instruction;
import jvm.java.runtime.CodeReader;
import jvm.java.runtime.StackFrame;

/**
 * Created by admin on 2017/1/22.
 */
public class I2f extends Instruction {
    public I2f() {
        this.name = "i2f";
        this.bc = 134 ;
    }

    @Override
    public void fetchOperands(CodeReader codeReader) {
        //
    }

    @Override
    public void execute(StackFrame stackFrame) {
        int value = stackFrame.getOperandStack().popInt();
        float ret =value;
        stackFrame.getOperandStack().pushFloat(ret);
    }
}
