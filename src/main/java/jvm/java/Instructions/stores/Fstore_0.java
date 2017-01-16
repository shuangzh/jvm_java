package jvm.java.Instructions.stores;

import jvm.java.runtime.CodeReader;

/**
 * Created by admin on 2017/1/16.
 */
public class Fstore_0 extends Fstore {
    public Fstore_0() {
        this.name = "fstore_0";
        this.bc = 67;
        this.index = 0;
    }

    @Override
    public void fetchOperands(CodeReader codeReader) {
        //
    }
}
