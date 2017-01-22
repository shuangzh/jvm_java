package jvm.java.Instructions.loads;

import jvm.java.runtime.CodeReader;

/**
 * Created by admin on 2017/1/22.
 */
public class Lload_0 extends Lload {
    public Lload_0() {
        this.name = "lload_0";
        this.bc = 30;
        this.index = 0;
    }

    @Override
    public void fetchOperands(CodeReader codeReader) {
        //
    }
}
