package jvm.java.Instructions.maths;

import jvm.java.Instructions.Instruction;
import jvm.java.Instructions.InstructionHolder;
import jvm.java.runtime.CodeReader;
import jvm.java.runtime.StackFrame;

/**
 * Created by admin on 2017/1/22.
 */
public class Ldiv extends Instruction {
    public Ldiv() {
        this.name = "ldiv";
        this.bc = 109;
    }

    @Override
    public void fetchOperands(CodeReader codeReader) {
        //
    }

    @Override
    public void execute(StackFrame stackFrame) {
        long v2 = stackFrame.getOperandStack().popLong();
        long v1 = stackFrame.getOperandStack().popLong();
        long ret = v1 / v2;
        stackFrame.getOperandStack().pushLong(ret);
    }
}
