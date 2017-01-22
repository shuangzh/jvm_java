package jvm.java.Instructions.cast;

import jvm.java.Instructions.Instruction;
import jvm.java.runtime.CodeReader;
import jvm.java.runtime.StackFrame;

/**
 * Created by admin on 2017/1/22.
 */
public class D2f extends Instruction {
    public D2f() {
        this.name = "d2f";
        this.bc = 144;
    }

    @Override
    public void fetchOperands(CodeReader codeReader) {
            //
    }

    @Override
    public void execute(StackFrame stackFrame) {
        double value = stackFrame.getOperandStack().popDouble();
        float ret = (float) value;
        stackFrame.getOperandStack().pushFloat(ret);
    }
}
