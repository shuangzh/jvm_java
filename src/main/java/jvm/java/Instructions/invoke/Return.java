package jvm.java.Instructions.invoke;

import jvm.java.Instructions.Instruction;
import jvm.java.base.Basic;
import jvm.java.runtime.CodeReader;
import jvm.java.runtime.StackFrame;
import jvm.java.runtime.ThreadStack;

/**
 * Created by admin on 2017/1/6.
 */
public class Return extends  Instruction{

    public Return() {
        this.name="return";
        this.bc = 177;
    }

    @Override
    public void fetchOperands(CodeReader codeReader) {
        //
    }

    @Override
    public void execute(StackFrame stackFrame) {
        stackFrame.setState(StackFrame.STATE_RETURN);

        Basic retValue=new Basic();
        retValue.setVoid();
        stackFrame.setReturnValue(retValue);

        ThreadStack threadStack = stackFrame.getThreadStack();
        threadStack.popFrame();
    }
}
