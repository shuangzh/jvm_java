package jvm.java.Instructions.loads;

import jvm.java.runtime.CodeReader;

/**
 * Created by admin on 2017/1/19.
 */
public class Fload_0  extends  Fload{
    public Fload_0() {
        this.name = "fload_0";
        this.bc = 34;
        this.index = 0;
    }

    @Override
    public void fetchOperands(CodeReader codeReader) {
        //
    }
}
