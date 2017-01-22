package jvm.java.Instructions.cast;

import jvm.java.Instructions.Instruction;
import jvm.java.runtime.CodeReader;
import jvm.java.runtime.StackFrame;

/**
 * Created by admin on 2017/1/22.
 */
public class L2i extends Instruction {

    public L2i() {
        this.name = "L2i";
        this.bc = 136;
    }

    @Override
    public void fetchOperands(CodeReader codeReader) {
        //
    }

    @Override
    public void execute(StackFrame stackFrame) {
        long value = stackFrame.getOperandStack().popLong();
        int ret = (int) value;
        stackFrame.getOperandStack().pushInt(ret);
    }
}
