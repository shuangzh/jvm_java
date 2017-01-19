package jvm.java.Instructions.maths;

import jvm.java.Instructions.Instruction;
import jvm.java.runtime.CodeReader;
import jvm.java.runtime.StackFrame;

/**
 * Created by admin on 2017/1/19.
 */
public class Ddiv extends Instruction {
    public Ddiv() {
        this.name = "ddiv";
        this.bc = 111;
    }

    @Override
    public void fetchOperands(CodeReader codeReader) {
        //
    }

    @Override
    public void execute(StackFrame stackFrame) {
        double v2 = stackFrame.getOperandStack().popDouble();
        double v1 = stackFrame.getOperandStack().popDouble();
        double ret = v1 / v2 ;
        stackFrame.getOperandStack().pushDouble(ret);
    }
}
