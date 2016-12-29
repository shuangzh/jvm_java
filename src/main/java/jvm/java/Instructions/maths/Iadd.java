package jvm.java.Instructions.maths;

import jvm.java.Instructions.NoOperandsInst;
import jvm.java.runtime.StackFrame;

/**
 * Created by admin on 2016/12/29.
 */
public class Iadd extends NoOperandsInst {

    int v1, v2, r;

    public Iadd() {
        this.name = "iadd";
        this.bc = 96 ; // 0x60;
    }

    @Override
    public void execute(StackFrame stackFrame) {
        v1 = stackFrame.getOperandStack().popInt();
        v2= stackFrame.getOperandStack().popInt();
        r = v1 + v2;
        stackFrame.getOperandStack().pushInt(r);
    }
}
