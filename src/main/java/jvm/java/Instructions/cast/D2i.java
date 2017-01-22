package jvm.java.Instructions.cast;

import jvm.java.Instructions.Instruction;
import jvm.java.runtime.CodeReader;
import jvm.java.runtime.StackFrame;

/**
 * Created by admin on 2017/1/22.
 */
public class D2i extends Instruction {
    public D2i() {
        this.name = "d2i";
        this.bc = 142;
    }

    @Override
    public void fetchOperands(CodeReader codeReader) {
        //
    }

    @Override
    public void execute(StackFrame stackFrame) {
        double value = stackFrame.getOperandStack().popDouble();
        int ret = (int) value;
        stackFrame.getOperandStack().pushInt(ret);
    }
}
