package jvm.java.array;

import jvm.java.base.ByteArray;
import jvm.java.loader.Klass;

/**
 * Created by admin on 2017/1/13.
 */
public class ReferenceArrayObject extends  ArrayObject {

    ByteArray referenceArray;
    public ReferenceArrayObject(int id, Klass klass, int length) {
        super(id, klass, length);
        this.referenceArray = new ByteArray(length, 4);
    }

    public int getReference(int index) {
        return this.referenceArray.getInt(index);
    }

    public void setReference(int index, int value) {
        this.referenceArray.setInt(index, value);
    }
}
