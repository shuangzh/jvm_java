package jvm.java.Instructions.invoke;

import jvm.java.Instructions.Instruction;
import jvm.java.runtime.CodeReader;
import jvm.java.runtime.StackFrame;

/**
 * Created by admin on 2017/1/6.
 */
public class AbstractInvoke extends Instruction {

    int index;  // 指向常量池中的索引


    @Override
    public void fetchOperands(CodeReader codeReader) {

    }

    @Override
    public void execute(StackFrame stackFrame) {

    }



}
