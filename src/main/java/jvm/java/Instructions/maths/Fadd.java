package jvm.java.Instructions.maths;

import jvm.java.Instructions.Instruction;
import jvm.java.runtime.CodeReader;
import jvm.java.runtime.StackFrame;

/**
 * Created by admin on 2017/1/19.
 */
public class Fadd extends Instruction {
    public Fadd() {
        this.name = "fadd";
        this.bc = 98;
    }

    @Override
    public void fetchOperands(CodeReader codeReader) {
        //
    }

    @Override
    public void execute(StackFrame stackFrame) {
        float v2 = stackFrame.getOperandStack().popFloat();
        float v1 = stackFrame.getOperandStack().popFloat();
        float ret = v1 + v2;
        stackFrame.getOperandStack().pushFloat(ret);
    }
}
