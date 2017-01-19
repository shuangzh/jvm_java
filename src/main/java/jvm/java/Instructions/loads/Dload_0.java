package jvm.java.Instructions.loads;

import jvm.java.runtime.CodeReader;

/**
 * Created by admin on 2017/1/19.
 */
public class Dload_0 extends Dload {
    public Dload_0() {
        this.name = "dload_0";
        this.bc = 38;
        this.index = 0;
    }

    @Override
    public void fetchOperands(CodeReader codeReader) {
        //
    }
}
