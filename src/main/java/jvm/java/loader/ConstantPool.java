package jvm.java.loader;

import jvm.java.base.SlotArray;
import jvm.java.runtime.LocalVarsTable;

/**
 * Created by admin on 2017/1/3.
 */
public class ConstantPool  extends SlotArray {
    public ConstantPool(int maxSize) {
        super(maxSize);
    }

}
