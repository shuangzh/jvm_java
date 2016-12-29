package jvm.java.Instructions;

import jvm.java.runtime.CodeReader;
import jvm.java.runtime.StackFrame;

/**
 * Created by admin on 2016/12/28.
 */
public abstract class Instruction {


    public Instruction(String name) {
        this.name = name;
    }

    public Instruction()
    {

    }

    public String getName() {
        return name;
    }

    protected String name;

    public int BC() {
        return bc;
    }

    protected int bc;

    public abstract void fetchOperands(CodeReader codeReader);

    public abstract void execute(StackFrame stackFrame);

}
