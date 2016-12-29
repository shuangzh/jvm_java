package jvm.java.Instructions.stores;

import jvm.java.runtime.CodeReader;

/**
 * Created by admin on 2016/12/29.
 */
public class Istore_3 extends Istore {
    public Istore_3() {
        this.name = "istore_3";
        this.bc = 62;  // 62
        this.index = 3;
    }

    @Override
    public void fetchOperands(CodeReader codeReader) {
        //
    }
}
