package jvm.java.Instructions.cast;

import jvm.java.Instructions.Instruction;
import jvm.java.runtime.CodeReader;
import jvm.java.runtime.StackFrame;

/**
 * Created by admin on 2017/1/22.
 */
public class L2f extends Instruction {
    public L2f() {
        this.name = "L2f";
        this.bc = 137;
    }

    @Override
    public void fetchOperands(CodeReader codeReader) {
        //
    }

    @Override
    public void execute(StackFrame stackFrame) {
        long value = stackFrame.getOperandStack().popLong();
        float ret = value;
        stackFrame.getOperandStack().pushFloat(ret);
    }
}
