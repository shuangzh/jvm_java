package jvm.java.Instructions.stores;

import jvm.java.runtime.CodeReader;

/**
 * Created by admin on 2017/1/11.
 */
public class Astore_0  extends  Astore{
    public Astore_0() {
        this.name = "astore_0";
        this.bc = 75 ;
        this.index = 0;
    }

    @Override
    public void fetchOperands(CodeReader codeReader) {
        //
    }
}
