package jvm.java.Instructions.cast;

import jvm.java.Instructions.Instruction;
import jvm.java.runtime.CodeReader;
import jvm.java.runtime.StackFrame;

/**
 * Created by admin on 2017/1/22.
 */
public class F2i extends Instruction {

    public F2i() {
        this.name = "F2i";
        this.bc = 139;
    }

    @Override
    public void fetchOperands(CodeReader codeReader) {
        //
    }

    @Override
    public void execute(StackFrame stackFrame) {
        float value = stackFrame.getOperandStack().popFloat();
        int ret = (int) value;
        stackFrame.getOperandStack().pushInt(ret);
    }
}
