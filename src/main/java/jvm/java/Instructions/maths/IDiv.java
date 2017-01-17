package jvm.java.Instructions.maths;

import jvm.java.Instructions.Instruction;
import jvm.java.runtime.CodeReader;
import jvm.java.runtime.StackFrame;

/**
 * Created by admin on 2017/1/17.
 */
public class IDiv extends Instruction {
    public IDiv() {
        this.name = "idiv";
        this.bc = 0x6C ;
    }

    @Override
    public void fetchOperands(CodeReader codeReader) {
        //
    }

    @Override
    public void execute(StackFrame stackFrame) {
        int v2 = stackFrame.getOperandStack().popInt();
        int v1 = stackFrame.getOperandStack().popInt();
        int ret = v1 / v2;
        stackFrame.getOperandStack().pushInt(ret);
    }
}
