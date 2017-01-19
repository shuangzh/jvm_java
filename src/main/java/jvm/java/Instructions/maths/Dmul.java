package jvm.java.Instructions.maths;

import jvm.java.Instructions.Instruction;
import jvm.java.runtime.CodeReader;
import jvm.java.runtime.StackFrame;

/**
 * Created by admin on 2017/1/19.
 */
public class Dmul extends Instruction {
    public Dmul() {
        this.name = "dmul";
        this.bc = 107;
    }

    @Override
    public void fetchOperands(CodeReader codeReader) {
        //
    }

    @Override
    public void execute(StackFrame stackFrame) {
        double v2 = stackFrame.getOperandStack().popDouble();
        System.out.println("v2 = "+ v2);
        double v1 = stackFrame.getOperandStack().popDouble();
        System.out.println("v1 = "+ v1);
        double ret = v1 * v2;
        stackFrame.getOperandStack().pushDouble(ret);
    }
}
