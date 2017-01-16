package jvm.java.Instructions;

import jvm.java.classfile.constantpool.ConstantDoubleInfo;
import jvm.java.classfile.constantpool.ConstantInfo;
import jvm.java.classfile.constantpool.ConstantLongInfo;
import jvm.java.runtime.CodeReader;
import jvm.java.runtime.StackFrame;

/**
 * Created by admin on 2017/1/16.
 */
public class Ldc2_w extends Instruction {

    int index;
    public Ldc2_w() {
        this.name = "ldc2_w";
        this.bc = 20;
    }

    @Override
    public void fetchOperands(CodeReader codeReader) {
        this.index = codeReader.readUnsignedShort();
    }

    @Override
    public void execute(StackFrame stackFrame) {
        ConstantInfo constantInfo = stackFrame.getJclass().getConstantpool()[index];
        int tag = constantInfo.getTag();
        if(tag == ConstantInfo.TAG_ConstantLongInfo) {
            ConstantLongInfo constantLongInfo = (ConstantLongInfo) constantInfo;
            stackFrame.getOperandStack().pushLong(constantLongInfo.getLongValue());
            return;
        }else if(tag == ConstantInfo.TAG_ConstantDoubleInfo) {
            ConstantDoubleInfo constantDoubleInfo= (ConstantDoubleInfo) constantInfo;
            stackFrame.getOperandStack().pushDouble(constantDoubleInfo.getDoubleValue());
        }
    }
}
