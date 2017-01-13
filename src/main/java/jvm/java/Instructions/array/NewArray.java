package jvm.java.Instructions.array;

import jvm.java.Instructions.Instruction;
import jvm.java.base.Const;
import jvm.java.base.JArrayObject;
import jvm.java.loader.Klass;
import jvm.java.runtime.CodeReader;
import jvm.java.runtime.ObjectHeap;
import jvm.java.runtime.StackFrame;

import java.io.IOException;

/**
 * Created by admin on 2017/1/12.
 */
public class NewArray extends Instruction {

    int atype;

    public NewArray() {
        this.name = "newarray";
        this.bc = 188;
    }

    @Override
    public void fetchOperands(CodeReader codeReader) {
        atype = codeReader.readUnsignedByte();
    }

    @Override
    public void execute(StackFrame stackFrame) {
        String satype = null;
        switch (atype) {
            case 4:
                satype = Const.TYP_B;
                break;
            case 5:
                satype = Const.TYP_C;
                break;
            case 6:
                satype = Const.TYP_F;
                break;
            case 7:
                satype = Const.TYP_D;
                break;
            case 8:
                satype = Const.TYP_B;
                break;
            case 9:
                satype = Const.TYP_S;
                break;
            case 10:
                satype = Const.TYP_I;
                break;
            case 11:
                satype = Const.TYP_J;
                break;
        }
        String classname= "["+satype;
        try {
            Klass arrClass = stackFrame.getJclass().getLoader().FindClass(classname);
            int len = stackFrame.getOperandStack().popInt();
            JArrayObject jArrayObject= ObjectHeap.newBaseArray(arrClass, len);
            stackFrame.getOperandStack().pushRef(jArrayObject.getArrayRefValue());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
