package jvm.java.array;

import jvm.java.base.ByteArray;
import jvm.java.loader.Klass;

/**
 * Created by admin on 2017/1/13.
 */
public class FloatArrayObject  extends ArrayObject {
    ByteArray floatArray;
    public FloatArrayObject(int id, Klass klass, int length) {
        super(id, klass, length);
        this.floatArray = new ByteArray(length, 4);
    }

    public float getFloat(int index) {
        return  this.floatArray.getFloat(index);
    }

    public void setFloat(int index, float value) {
        this.floatArray.setFloat(index, value);
    }
}
