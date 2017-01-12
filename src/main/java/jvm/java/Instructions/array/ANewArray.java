package jvm.java.Instructions.array;

import jvm.java.Instructions.Instruction;
import jvm.java.base.JArrayObject;
import jvm.java.classfile.constantpool.ConstantClassInfo;
import jvm.java.loader.JClass;
import jvm.java.runtime.CodeReader;
import jvm.java.runtime.ObjectHeap;
import jvm.java.runtime.StackFrame;

import java.io.IOException;

/**
 * Created by admin on 2017/1/12.
 */
public class ANewArray extends Instruction {

    int index;
    public ANewArray() {
        this.name = "anewarray";
        this.bc = 189;
    }

    @Override
    public void fetchOperands(CodeReader codeReader) {
        this.index = codeReader.readUnsignedShort();
    }

    @Override
    public void execute(StackFrame stackFrame) {
        ConstantClassInfo constantClassInfo = (ConstantClassInfo) stackFrame.getJclass().getConstantpool()[index];
        String classname = constantClassInfo.getClassName();
        try {
            JClass tclass= stackFrame.getJclass().getLoader().FindClass(classname);
            String arrayClassname=tclass.getName();
            if(classname.startsWith("["))
                arrayClassname="["+arrayClassname;
            else
                arrayClassname="[L"+arrayClassname+";";

            JClass arrClass = stackFrame.getJclass().getLoader().FindClass(arrayClassname);
            int count =stackFrame.getOperandStack().popInt();
            JArrayObject jArrayObject= ObjectHeap.newBaseArray(arrClass, count);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
