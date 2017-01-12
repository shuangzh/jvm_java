package jvm.java.Instructions.newinst;

import com.sun.org.apache.bcel.internal.classfile.ConstantFieldref;
import jvm.java.Instructions.Instruction;
import jvm.java.base.Const;
import jvm.java.base.JObject;
import jvm.java.classfile.constantpool.ConstantFieldrefInfo;
import jvm.java.loader.JClass;
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
        ConstantFieldrefInfo constantFieldrefInfo = (ConstantFieldrefInfo) stackFrame.getJclass().getConstantpool()[index];
        String name = constantFieldrefInfo.getName();
        String descriptor = constantFieldrefInfo.getDescriptor();
        String classname = constantFieldrefInfo.getClassName();
        JClass jClass = null;
        try {
            jClass = stackFrame.getJclass().getLoader().FindClass(classname);
        } catch (IOException e) {
            e.printStackTrace();
        }

        JField jField = jClass.FindField(name, descriptor);

        int objRef = stackFrame.getOperandStack().popRef();
        JObject jObject = ObjectHeap.fetchObject(objRef);
        String t = descriptor.substring(0, 1);
        if (t.equals(Const.TYP_J )|| t.equals(Const.TYP_D)) {
            int v1 = jObject.getSlotArray().getInt(jField.getSlotId());
            int v2 = jObject.getSlotArray().getInt(jField.getSlotId() + 1);
            stackFrame.getOperandStack().pushInt(v1);
            stackFrame.getOperandStack().pushInt(v2);
        } else {
            int v1 = jObject.getSlotArray().getInt(jField.getSlotId());
            stackFrame.getOperandStack().pushInt(v1);
        }
    }
}