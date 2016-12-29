package jvm.java.Instructions.stores;

import jvm.java.Instructions.Instruction;
import jvm.java.runtime.CodeReader;
import jvm.java.runtime.StackFrame;

/**
 * Created by admin on 2016/12/29.
 */
public class Istore extends Instruction {
    public Istore() {
        this.name ="istore";
        this.bc = 54 ; // 0x36
    }

    protected  int index = 0;

    @Override
    public void fetchOperands(CodeReader codeReader) {
        this.index = codeReader.readUnsignedByte();
    }

    @Override
    public void execute(StackFrame stackFrame) {
        stackFrame.getLocalVarsTable().setInt(index, stackFrame.getOperandStack().popInt() );
    }
}
