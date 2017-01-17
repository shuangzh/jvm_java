package jvm.java.Instructions.maths;

import jvm.java.Instructions.Instruction;
import jvm.java.runtime.CodeReader;
import jvm.java.runtime.StackFrame;

/**
 * Created by admin on 2017/1/17.
 */
public class Imul extends Instruction {
    public Imul() {
        this.name="imul";
        this.bc = 0x68;
    }

    @Override
    public void fetchOperands(CodeReader codeReader) {
        //
    }

    @Override
    public void execute(StackFrame stackFrame) {
        int v2 = stackFrame.getOperandStack().popInt();
        int v1 = stackFrame.getOperandStack().popInt();
        int ret = v1 * v2;
        stackFrame.getOperandStack().pushInt(ret);
    }
}
