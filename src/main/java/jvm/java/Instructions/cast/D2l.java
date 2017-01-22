package jvm.java.Instructions.cast;

import jvm.java.Instructions.Instruction;
import jvm.java.runtime.CodeReader;
import jvm.java.runtime.StackFrame;

/**
 * Created by admin on 2017/1/22.
 */
public class D2l extends Instruction {
    public D2l() {
        this.name = "d2l";
        this.bc = 143;
    }

    @Override
    public void fetchOperands(CodeReader codeReader) {
       //
    }

    @Override
    public void execute(StackFrame stackFrame) {
        double value =stackFrame.getOperandStack().popDouble();
        long ret = (long) value;
        stackFrame.getOperandStack().pushLong(ret);
    }
}
