package jvm.java.Instructions.newinst;

import jvm.java.Instructions.Instruction;
import jvm.java.base.Const;
import jvm.java.base.Basic;
import jvm.java.base.KlassObject;
import jvm.java.classfile.constantpool.ConstantFieldrefInfo;
import jvm.java.loader.Klass;
import jvm.java.loader.JField;
import jvm.java.runtime.CodeReader;
import jvm.java.runtime.ObjectHeap;
import jvm.java.runtime.StackFrame;

import java.io.IOException;

/**
 * Created by admin on 2017/1/11.
 */
public class GetField extends Instruction {

    int index;

    public GetField() {
        this.name = "getfield";
        this.bc = 180;
    }

    @Override
    public void fetchOperands(CodeReader codeReader) {
        index = codeReader.readUnsignedShort();
    }

    @Override
    public void execute(StackFrame stackFrame) {
        JField field = stackFrame.getJclass().castConstantFieldRefInfo(index);
        int id = stackFrame.getOperandStack().popRef();
        KlassObject klassObject=ObjectHeap.fetchKlassObject(id);
        if(field.getSlotSize() == 2) {
            int v1 = klassObject.getFieldSlots().getInt(field.getSlotId());
            int v2 = klassObject.getFieldSlots().getInt(field.getSlotId()+1);
            stackFrame.getOperandStack().pushInt(v1);
            stackFrame.getOperandStack().pushInt(v2);
        }else {
            int v1 = klassObject.getFieldSlots().getInt(field.getSlotId());
            stackFrame.getOperandStack().pushInt(v1);
        }

//        ConstantFieldrefInfo constantFieldrefInfo = (ConstantFieldrefInfo) stackFrame.getJclass().getConstantpool()[index];
//        String name = constantFieldrefInfo.getName();
//        String descriptor = constantFieldrefInfo.getDescriptor();
//        String classname = constantFieldrefInfo.getClassName();
//        Klass jClass = null;
//        jClass = stackFrame.getJclass().getLoader().FindClass(classname);
//        JField jField = jClass.FindField(name, descriptor);
//
//        int objRef = stackFrame.getOperandStack().popRef();
//        Basic jObject = ObjectHeap.fetchObject(objRef);
//        String t = descriptor.substring(0, 1);
//        if (t.equals(Const.TYP_J )|| t.equals(Const.TYP_D)) {
//            int v1 = jObject.getSlotArray().getInt(jField.getSlotId());
//            int v2 = jObject.getSlotArray().getInt(jField.getSlotId() + 1);
//            stackFrame.getOperandStack().pushInt(v1);
//            stackFrame.getOperandStack().pushInt(v2);
//        } else {
//            int v1 = jObject.getSlotArray().getInt(jField.getSlotId());
//            stackFrame.getOperandStack().pushInt(v1);
//        }
    }
}
