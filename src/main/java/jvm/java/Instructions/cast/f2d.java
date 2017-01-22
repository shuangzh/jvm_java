package jvm.java.Instructions.cast;

import jvm.java.Instructions.Instruction;
import jvm.java.runtime.CodeReader;
import jvm.java.runtime.StackFrame;

/**
 * Created by admin on 2017/1/22.
 */
public class F2d extends Instruction {
    public F2d() {
        this.name = "F2d";
        this.bc = 141;
    }

    @Override
    public void fetchOperands(CodeReader codeReader) {
        //
    }

    @Override
    public void execute(StackFrame stackFrame) {
        float value = stackFrame.getOperandStack().popFloat();
        double ret = value;
        stackFrame.getOperandStack().pushDouble(ret);
    }
}
