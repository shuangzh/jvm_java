package jvm.java.Instructions.stores;

import jvm.java.runtime.CodeReader;

/**
 * Created by admin on 2016/12/29.
 */
public class Istore_2  extends Istore {

    public Istore_2() {
        this.name = "istore_2";
        this.bc =  61; // 61;
        this.index = 2;
    }

    @Override
    public void fetchOperands(CodeReader codeReader) {
        //
    }
}
