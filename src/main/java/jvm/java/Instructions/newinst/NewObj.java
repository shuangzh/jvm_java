package jvm.java.Instructions.newinst;

import jvm.java.Instructions.Instruction;
import jvm.java.base.JObject;
import jvm.java.classfile.constantpool.ConstantClassInfo;
import jvm.java.loader.JClass;
import jvm.java.runtime.CodeReader;
import jvm.java.runtime.ObjectHeap;
import jvm.java.runtime.StackFrame;

import java.io.IOException;

/**
 * Created by admin on 2017/1/11.
 */
public class NewObj extends Instruction {
    int index;

    public NewObj() {
        this.name="new";
        this.bc = 187 ;
    }

    public void fetchOperands(CodeReader codeReader) {
        index  = codeReader.readUnsignedShort();
    }

    public void execute(StackFrame stackFrame) {
        JClass jClass = stackFrame.getJclass();
        ConstantClassInfo constantClassInfo = (ConstantClassInfo) jClass.getConstantpool()[index];
        String classname = constantClassInfo.getClassName();
        JClass njclass=null;
        try {
            njclass = jClass.getLoader().FindClass(classname);

        } catch (IOException e) {
            e.printStackTrace();
        }

        JObject newobj = ObjectHeap.newObject(njclass);
        stackFrame.getOperandStack().pushRef(newobj.getRefValue());
    }
}
