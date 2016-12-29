package jvm.java.Instructions.loads;

import jvm.java.Instructions.Instruction;
import jvm.java.runtime.CodeReader;
import jvm.java.runtime.StackFrame;

/**
 * Created by admin on 2016/12/29.
 */
public class Iload  extends Instruction{

    public Iload() {
        this.name = "iload";
        this.bc = 21 ;  // 21;
    }

    protected  int index;

    @Override
    public void fetchOperands(CodeReader codeReader) {
        this.index = codeReader.readUnsignedByte();
    }

    @Override
    public void execute(StackFrame stackFrame) {
        stackFrame.getOperandStack().pushInt(stackFrame.getLocalVarsTable().getInt(index));
    }
}
