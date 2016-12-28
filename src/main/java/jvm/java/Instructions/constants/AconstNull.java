package jvm.java.Instructions.constants;

import jvm.java.Instructions.NoOperandsInst;
import jvm.java.base.Const;
import jvm.java.runtime.StackFrame;

/**
 * Created by admin on 2016/12/29.
 */
public class AconstNull extends NoOperandsInst {

    public AconstNull() {
        this.name = "aconst_null";
    }

    public void execute(StackFrame stackFrame) {
        stackFrame.getOperandStack().pushRef(Const.NULL);
    }
}
