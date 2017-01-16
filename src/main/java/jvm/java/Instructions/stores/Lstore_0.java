package jvm.java.Instructions.stores;

import jvm.java.runtime.CodeReader;

/**
 * Created by admin on 2017/1/16.
 */
public class Lstore_0 extends Lstore {
    public Lstore_0() {
        this.name = "lstore_0";
        this.bc = 63;
        this.index = 0;
    }

    @Override
    public void fetchOperands(CodeReader codeReader) {
        //
    }
}
