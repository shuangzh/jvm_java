package jvm.java.Instructions.cast;

import jvm.java.Instructions.Instruction;
import jvm.java.runtime.CodeReader;
import jvm.java.runtime.StackFrame;

/**
 * Created by admin on 2017/1/17.
 */
public class I2b extends Instruction {
    public I2b() {
        this.name = "i2b";
        this.bc = 0x91 ;
    }

    @Override
    public void fetchOperands(CodeReader codeReader) {
        //
    }

    @Override
    public void execute(StackFrame stackFrame) {
        int i = stackFrame.getOperandStack().popInt();
        byte b = (byte)i;
        stackFrame.getOperandStack().pushInt(b);
    }
}
