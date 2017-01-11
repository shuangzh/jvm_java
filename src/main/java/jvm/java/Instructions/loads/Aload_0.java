package jvm.java.Instructions.loads;

import jvm.java.runtime.CodeReader;

/**
 * Created by admin on 2017/1/11.
 */
public class Aload_0 extends Aload {

    public Aload_0() {
        this.name = "aload_0";
        this.bc = 42;
        this.index = 0;
    }

    @Override
    public void fetchOperands(CodeReader codeReader) {
        //
    }

}
