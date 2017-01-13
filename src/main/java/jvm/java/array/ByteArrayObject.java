package jvm.java.array;

import jvm.java.base.ByteArray;
import jvm.java.loader.Klass;

/**
 * Created by admin on 2017/1/13.
 */
public class ByteArrayObject  extends ArrayObject{
    ByteArray byteArray;

    public ByteArrayObject(int id, Klass klass, int length) {
        super(id, klass, length);
        this.byteArray = new ByteArray(length, 1);
    }

    public byte getByte(int index) {
        return  this.byteArray.getByte(index);
    }

    public int getUnsignedByte(int index) {
        return  this.byteArray.getUnsignedByte(index);
    }

    public void setByte(int index, int value) {
        this.byteArray.setByte(index, value);
    }

}
