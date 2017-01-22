package jvm.java.Instructions.loads;

import jvm.java.Instructions.Instruction;
import jvm.java.runtime.CodeReader;
import jvm.java.runtime.StackFrame;

/**
 * Created by admin on 2017/1/22.
 */
public class Lload extends Instruction {
    int index;
    public Lload() {
        this.name = "lload";
        this.bc = 22;
    }

    @Override
    public void fetchOperands(CodeReader codeReader) {
        this.index = codeReader.readUnsignedByte();
    }

    @Override
    public void execute(StackFrame stackFrame) {
        long  value = stackFrame.getLocalVarsTable().getLong(index);
        stackFrame.getOperandStack().pushLong(value);
    }
}
