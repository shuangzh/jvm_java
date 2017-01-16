package jvm.java.Instructions.constants;

import jvm.java.Instructions.Instruction;
import jvm.java.runtime.CodeReader;
import jvm.java.runtime.StackFrame;

/**
 * Created by admin on 2017/1/16.
 */
public class Iconst_0 extends Instruction{

    int iconst;
    public Iconst_0() {
        this.name = "iconst_0";
        this.bc = 3;
        this.iconst = 0;
    }

    @Override
    public void fetchOperands(CodeReader codeReader) {
        //
    }

    @Override
    public void execute(StackFrame stackFrame) {
        stackFrame.getOperandStack().pushInt(iconst);
    }
}
