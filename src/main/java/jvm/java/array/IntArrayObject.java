package jvm.java.array;

import jvm.java.base.ByteArray;
import jvm.java.loader.Klass;

/**
 * Created by admin on 2017/1/13.
 */
public class IntArrayObject extends ArrayObject {
    ByteArray intArray;
    public IntArrayObject(int i, Klass klass, int len) {
        super(i, klass, len);
        this.intArray = new ByteArray(len, 4);
    }
    public int getInt(int index) {
        return this.intArray.getInt(index);
    }
    public void setInt(int index, int value) {
        this.intArray.setInt(index, value);
    }
}
