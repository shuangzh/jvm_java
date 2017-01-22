package jvm.java.Instructions.maths;

import jvm.java.Instructions.Instruction;
import jvm.java.runtime.CodeReader;
import jvm.java.runtime.StackFrame;

/**
 * Created by admin on 2017/1/22.
 */
public class Ladd extends Instruction {
    public Ladd() {
        this.name = "ladd";
        this.bc = 97;
    }

    @Override
    public void fetchOperands(CodeReader codeReader) {
        //
    }

    @Override
    public void execute(StackFrame stackFrame) {
        long v2 = stackFrame.getOperandStack().popLong();
        long v1 = stackFrame.getOperandStack().popLong();
        long ret = v1 + v2;
        stackFrame.getOperandStack().pushLong(ret);
    }
}
