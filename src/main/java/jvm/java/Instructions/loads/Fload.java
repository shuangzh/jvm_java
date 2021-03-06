package jvm.java.Instructions.loads;

import jvm.java.Instructions.Instruction;
import jvm.java.runtime.CodeReader;
import jvm.java.runtime.StackFrame;

/**
 * Created by admin on 2017/1/19.
 */
public class Fload extends Instruction {

    int index;
    public Fload() {
        this.name ="fload";
        this.bc = 23;
    }

    @Override
    public void fetchOperands(CodeReader codeReader) {
        this.index = codeReader.readUnsignedByte();
    }

    @Override
    public void execute(StackFrame stackFrame) {
        float f = stackFrame.getLocalVarsTable().getFloat(index);
        stackFrame.getOperandStack().pushFloat(f);
    }
}
