package jvm.java.Instructions;

import jvm.java.runtime.CodeReader;
import jvm.java.runtime.StackFrame;

/**
 * Created by admin on 2016/12/29.
 */

public abstract class NoOperandsInst  extends  Instruction {

    public void fetchOperands(CodeReader codeReader) {
        //
    }
    public abstract void execute(StackFrame stackFrame) ;
}
