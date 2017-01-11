package jvm.java.Instructions.loads;

import jvm.java.Instructions.Instruction;
import jvm.java.runtime.CodeReader;
import jvm.java.runtime.StackFrame;

/**
 * Created by admin on 2017/1/11.
 */
public class Aload extends Instruction {

    int index;

    public Aload() {
        this.name = "aload";
        this.bc =  25;
    }

    @Override
    public void fetchOperands(CodeReader codeReader) {
        this.index = codeReader.readUnsignedByte();
    }

    @Override
    public void execute(StackFrame stackFrame) {
        stackFrame.getOperandStack().pushRef(stackFrame.getLocalVarsTable().getInt(index));
    }

}
