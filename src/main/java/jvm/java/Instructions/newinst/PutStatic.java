package jvm.java.Instructions.newinst;

import jvm.java.Instructions.Instruction;
import jvm.java.base.Const;
import jvm.java.classfile.constantpool.ConstantFieldrefInfo;
import jvm.java.loader.Klass;
import jvm.java.loader.JField;
import jvm.java.runtime.CodeReader;
import jvm.java.runtime.StackFrame;

import java.io.IOException;

/**
 * Created by admin on 2017/1/11.
 */
public class PutStatic extends Instruction {

    int index;

    public PutStatic() {
        this.name = "putstatic";
        this.bc = 179;
    }

    @Override
    public void fetchOperands(CodeReader codeReader) {
        this.index = codeReader.readUnsignedShort();
    }

    @Override
    public void execute(StackFrame stackFrame) {
        JField field=stackFrame.getJclass().castConstantFieldRefInfo(index);
        if(field.getSlotSize() == 2) {
            int v2 = stackFrame.getOperandStack().popInt();
            int v1 = stackFrame.getOperandStack().popInt();
            field.getJClass().getStaticSlots().setInt(field.getSlotId(), v1);
            field.getJClass().getStaticSlots().setInt(field.getSlotId()+1, v2);
        }else {
            int v1 = stackFrame.getOperandStack().popInt();
            field.getJClass().getStaticSlots().setInt(field.getSlotId(), v1);
        }

//        ConstantFieldrefInfo constantFieldrefInfo = (ConstantFieldrefInfo) stackFrame.getJclass().getConstantpool()[index];
//        String name = constantFieldrefInfo.getName();
//        String descriptor = constantFieldrefInfo.getDescriptor();
//        String classname = constantFieldrefInfo.getClassName();
//        Klass jClass = null;
//        try {
//            jClass = stackFrame.getJclass().getLoader().FindClass(classname);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        JField jField = jClass.FindField(name, descriptor);
//        String  t = descriptor.substring(0, 1);
//        if (t.equals(Const.TYP_J )|| t.equals(Const.TYP_D)) {
//            int v2 = stackFrame.getOperandStack().popInt();
//            int v1 = stackFrame.getOperandStack().popInt();
//            jClass.getStaticSlots().setInt(jField.getSlotId(), v1);
//            jClass.getStaticSlots().setInt(jField.getSlotId()+1, v2);
//        }else {
//            int v1 = stackFrame.getOperandStack().popInt();
//            jClass.getStaticSlots().setInt(jField.getSlotId(), v1);
//        }
    }
}
