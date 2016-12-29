package jvm.java.Instructions.loads;

import jvm.java.runtime.CodeReader;

/**
 * Created by admin on 2016/12/29.
 */
public class Iload_0 extends  Iload {
    public Iload_0() {
        this.name = "iload_0";
        this.bc = 26; // 26
        this.index = 0;
    }

    @Override
    public void fetchOperands(CodeReader codeReader) {
        //
    }
}
