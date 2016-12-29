package jvm.java.Instructions;

import jvm.java.runtime.StackFrame;

/**
 * Created by admin on 2016/12/29.
 */
public class Nop extends NoOperandsInst {

    public Nop() {
        this.name = "nop";
        this.bc =0;
    }

    public void execute(StackFrame stackFrame) {
        //
    }
}
