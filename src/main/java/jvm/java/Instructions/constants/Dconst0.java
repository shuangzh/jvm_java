package jvm.java.Instructions.constants;

import jvm.java.Instructions.NoOperandsInst;
import jvm.java.runtime.StackFrame;

/**
 * Created by admin on 2016/12/29.
 */
public class Dconst0 extends NoOperandsInst {
    public Dconst0() {
        this.name = "dconst_0";
    }

    public void execute(StackFrame stackFrame) {
        stackFrame.getOperandStack().pushDouble(0.0d);
    }
}
