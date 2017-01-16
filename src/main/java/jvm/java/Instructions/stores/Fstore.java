package jvm.java.Instructions.stores;

import jvm.java.Instructions.Instruction;
import jvm.java.runtime.CodeReader;
import jvm.java.runtime.StackFrame;

/**
 * Created by admin on 2017/1/16.
 */
public class Fstore extends Instruction {

    int index;
    public Fstore() {
        this.name = "fstore";
        this.bc = 56;
    }

    @Override
    public void fetchOperands(CodeReader codeReader) {
        this.index = codeReader.readUnsignedByte();
    }

    @Override
    public void execute(StackFrame stackFrame) {
        float f = stackFrame.getOperandStack().popFloat();
        stackFrame.getLocalVarsTable().setFloat(index, f);
    }
}
