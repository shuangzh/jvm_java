package jvm.java.Instructions.stores;

import jvm.java.runtime.CodeReader;

/**
 * Created by admin on 2017/1/16.
 */
public class Dstore_0 extends Dstore{
    public Dstore_0() {
        this.name = "dstore_0";
        this.bc = 71;
        this.index = 0;
    }

    @Override
    public void fetchOperands(CodeReader codeReader) {
        //
    }
}
