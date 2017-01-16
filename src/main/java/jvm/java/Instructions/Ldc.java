package jvm.java.Instructions;

import jvm.java.classfile.constantpool.ConstantFloatInfo;
import jvm.java.classfile.constantpool.ConstantInfo;
import jvm.java.classfile.constantpool.ConstantIntegerInfo;
import jvm.java.runtime.CodeReader;
import jvm.java.runtime.StackFrame;

/**
 * Created by admin on 2017/1/16.
 */
public class Ldc extends Instruction {

    int index;

    public Ldc() {
        this.name = "ldc";
        this.bc = 18;
    }

    @Override
    public void fetchOperands(CodeReader codeReader) {
        this.index = codeReader.readUnsignedByte();
    }

    @Override
    public void execute(StackFrame stackFrame) {
        ConstantInfo constantInfo = stackFrame.getJclass().getConstantpool()[index];
        int tag= constantInfo.getTag();
        if(tag == ConstantInfo.TAG_ConstantIntegerInfo)
        {
            ConstantIntegerInfo constantIntegerInfo = (ConstantIntegerInfo)constantInfo;
            stackFrame.getOperandStack().pushInt(constantIntegerInfo.getIntValue());
            return;
        }else if(tag == ConstantInfo.TAG_ConstantFloatInfo)
        {
            ConstantFloatInfo constantFloatInfo = (ConstantFloatInfo)constantInfo;
            stackFrame.getOperandStack().pushFloat(constantFloatInfo.getFloatValue());
            return;
        }else {
            throw new RuntimeException("ldc constantinfo tag " + tag + " cant handle");
        }

    }
}
