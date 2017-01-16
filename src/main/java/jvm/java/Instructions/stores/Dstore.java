package jvm.java.Instructions.stores;

import jvm.java.Instructions.Instruction;
import jvm.java.runtime.CodeReader;
import jvm.java.runtime.StackFrame;

/**
 * Created by admin on 2017/1/16.
 */
public class Dstore  extends Instruction {
    int index;
    public Dstore() {
        this.name = "dstore";
        this.bc = 57;
    }

    @Override
    public void fetchOperands(CodeReader codeReader) {
        this.index = codeReader.readUnsignedByte();
    }

    @Override
    public void execute(StackFrame stackFrame) {
        double d = stackFrame.getOperandStack().popDouble();
        stackFrame.getLocalVarsTable().setDouble(index, d);
    }
}
