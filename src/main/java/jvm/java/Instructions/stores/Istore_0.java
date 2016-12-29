package jvm.java.Instructions.stores;

import jvm.java.runtime.CodeReader;

/**
 * Created by admin on 2016/12/29.
 */
public class Istore_0 extends Istore {
    public Istore_0() {
        this.name = "istore_0";
        this.bc = 59;  // 59;
        this.index = 0;
    }

    @Override
    public void fetchOperands(CodeReader codeReader) {
        //
    }
}
