package jvm.java.Instructions.stores;

import jvm.java.Instructions.Instruction;
import jvm.java.runtime.CodeReader;
import jvm.java.runtime.StackFrame;

/**
 * Created by admin on 2017/1/11.
 */
public class Astore extends Instruction {

    int index;

    public Astore() {
        this.name = "astore";
        this.bc = 58;
    }

    @Override
    public void fetchOperands(CodeReader codeReader) {
        this.index = codeReader.readUnsignedByte();
    }

    @Override
    public void execute(StackFrame stackFrame) {
        stackFrame.getLocalVarsTable().setInt(index, stackFrame.getOperandStack().popRef());
    }

}
