package jvm.java.Instructions.array;

import jvm.java.Instructions.Instruction;
import jvm.java.array.ArrayObject;
import jvm.java.base.JArrayObject;
import jvm.java.classfile.constantpool.ConstantClassInfo;
import jvm.java.loader.Klass;
import jvm.java.runtime.CodeReader;
import jvm.java.runtime.ObjectHeap;
import jvm.java.runtime.StackFrame;

import java.io.IOException;

/**
 * Created by admin on 2017/1/12.
 */
public class MultiANewArray extends Instruction {

    int index;
    int dimensions;

    public MultiANewArray() {
        this.name = "multianewarray";
        this.bc = 197;
    }

    @Override
    public void fetchOperands(CodeReader codeReader) {
        this.index = codeReader.readUnsignedShort();
        this.dimensions= codeReader.readUnsignedByte();

    }

    @Override
    public void execute(StackFrame stackFrame) {
        Klass arrayKlass = stackFrame.getJclass().castConstantClassInfo(index);
        int[] dims=new int[dimensions];
        for(int i=dims.length-1; i>=0; i--) {
            dims[i]=stackFrame.getOperandStack().popInt();
        }
        ArrayObject arrayObject= ObjectHeap.multiArrayObject(arrayKlass, dims);
        stackFrame.getOperandStack().pushRef(arrayObject.getId());

//        ConstantClassInfo constantClassInfo= (ConstantClassInfo) stackFrame.getJclass().getConstantpool()[index];
//        String classname =constantClassInfo.getClassName();
//        try {
//            Klass arrClass = stackFrame.getJclass().getLoader().FindClass(classname);
//            int[] dims=new int[dimensions];
//            for(int i=dims.length-1; i>=0; i--) {
//                dims[i]=stackFrame.getOperandStack().popInt();
//            }
//            JArrayObject jArrayObject = ObjectHeap.newMutiArray(arrClass,dims);
//            stackFrame.getOperandStack().pushRef(jArrayObject.getArrayRefValue());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
