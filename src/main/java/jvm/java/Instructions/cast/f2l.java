package jvm.java.Instructions.cast;

import jvm.java.Instructions.Instruction;
import jvm.java.runtime.CodeReader;
import jvm.java.runtime.StackFrame;

/**
 * Created by admin on 2017/1/22.
 */
public class F2l extends Instruction {

    public F2l() {
        this.name = "F2l";
        this.bc = 140;
    }

    @Override
    public void fetchOperands(CodeReader codeReader) {
        //
    }

    @Override
    public void execute(StackFrame stackFrame) {
        float value = stackFrame.getOperandStack().popFloat();
        long ret = (long) value;
        stackFrame.getOperandStack().pushLong(ret);
    }
}
