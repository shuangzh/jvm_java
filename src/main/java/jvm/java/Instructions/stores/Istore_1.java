package jvm.java.Instructions.stores;

import jvm.java.runtime.CodeReader;

/**
 * Created by admin on 2016/12/29.
 */
public class Istore_1 extends  Istore {

    public Istore_1() {
        this.name = "istore_1";
        this.bc = 60  ;   //   60
        this.index = 1;
    }

    @Override
    public void fetchOperands(CodeReader codeReader) {
        //
    }
}
