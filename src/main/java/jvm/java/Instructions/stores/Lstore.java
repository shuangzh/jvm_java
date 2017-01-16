package jvm.java.Instructions.stores;

import jvm.java.Instructions.Instruction;
import jvm.java.runtime.CodeReader;
import jvm.java.runtime.StackFrame;

/**
 * Created by admin on 2017/1/16.
 */
public class Lstore extends Instruction{

    int index;
    public Lstore() {
        this.name = "lstore";
        this.bc = 55;
    }

    @Override
    public void fetchOperands(CodeReader codeReader) {
        this.index = codeReader.readUnsignedByte();
    }

    @Override
    public void execute(StackFrame stackFrame) {
        long l = stackFrame.getOperandStack().popLong();
        stackFrame.getLocalVarsTable().setLong(index, l);
    }
}
