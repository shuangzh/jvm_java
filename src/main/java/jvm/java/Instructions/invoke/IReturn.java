package jvm.java.Instructions.invoke;

import jvm.java.Instructions.Instruction;
import jvm.java.base.Basic;
import jvm.java.runtime.CodeReader;
import jvm.java.runtime.StackFrame;
import jvm.java.runtime.ThreadStack;

/**
 * Created by admin on 2017/1/6.
 */
public class IReturn extends Instruction {

    public IReturn() {
        this.name = "ireturn";
        this.bc = 172 ; // 0xac
    }

    @Override
    public void fetchOperands(CodeReader codeReader) {
        ;
    }

    @Override
    public void execute(StackFrame stackFrame) {

        int retInt= stackFrame.getOperandStack().popInt();
        stackFrame.setState(StackFrame.STATE_RETURN);

        Basic retValue=new Basic();
        retValue.setIntValue(retInt);
        stackFrame.setReturnValue(retValue);
        ThreadStack threadStack = stackFrame.getThreadStack();
        threadStack.popFrame();
        if(!threadStack.isEmpty()) {
            StackFrame current = threadStack.currentFrame();
            current.getOperandStack().pushInt(retInt);
        }
    }
}
