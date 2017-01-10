package jvm.java.Instructions.opstack;

import jvm.java.Instructions.Instruction;
import jvm.java.runtime.CodeReader;
import jvm.java.runtime.StackFrame;

/**
 * Created by admin on 2017/1/10.
 */
public class Dup extends Instruction {

    public Dup() {
        this.name = "dup";
        this.bc = 89;
    }

    public void fetchOperands(CodeReader codeReader) {
        //
    }

    public void execute(StackFrame stackFrame) {
        int  i = stackFrame.getOperandStack().popInt();
        stackFrame.getOperandStack().pushInt(i);
        stackFrame.getOperandStack().pushInt(i);
    }
}
