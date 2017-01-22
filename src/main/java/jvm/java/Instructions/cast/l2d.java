package jvm.java.Instructions.cast;

import jvm.java.Instructions.Instruction;
import jvm.java.runtime.CodeReader;
import jvm.java.runtime.StackFrame;

/**
 * Created by admin on 2017/1/22.
 */
public class L2d extends Instruction {
    public L2d() {
        this.name = "L2d";
        this.bc = 138;
    }

    @Override
    public void fetchOperands(CodeReader codeReader) {
        //
    }

    @Override
    public void execute(StackFrame stackFrame) {
        long value = stackFrame.getOperandStack().popLong();
        double ret = value;
        stackFrame.getOperandStack().pushDouble(ret);
    }
}
