package jvm.java.Instructions.invoke;

import jvm.java.Instructions.Instruction;
import jvm.java.classfile.constantpool.ConstantMethodrefInfo;
import jvm.java.runtime.CodeReader;
import jvm.java.runtime.StackFrame;

/**
 * Created by admin on 2017/1/11.
 */
public class Invokesepcial extends Instruction {

    int index;

    public Invokesepcial() {
        this.name = "invokespecial";
        this.bc = 183 ;
    }

    public void fetchOperands(CodeReader codeReader) {
        this.index = codeReader.readUnsignedShort();
    }

    public void execute(StackFrame stackFrame) {
        ConstantMethodrefInfo   constantMethodrefInfo= (ConstantMethodrefInfo) stackFrame.getJclass().getConstantpool()[index];

    }
}
