package jvm.java.Instructions.maths;

import jvm.java.Instructions.Instruction;
import jvm.java.runtime.CodeReader;
import jvm.java.runtime.StackFrame;

/**
 * Created by admin on 2017/1/22.
 */
public class Lmul extends Instruction {
    public Lmul() {
        this.name = "lmul";
        this.bc = 105 ;
    }

    @Override
    public void fetchOperands(CodeReader codeReader) {
       //
    }

    @Override
    public void execute(StackFrame stackFrame) {
        long v2 = stackFrame.getOperandStack().popLong();
        long v1 = stackFrame.getOperandStack().popLong();
        long ret = v1 * v2;
        System.out.println("v2 = "+ v2);
        System.out.println("v1 = "+ v1);
        System.out.println("ret = "+ ret);
        stackFrame.getOperandStack().pushLong(ret);
    }
}
