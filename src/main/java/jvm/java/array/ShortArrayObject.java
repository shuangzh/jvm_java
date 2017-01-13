package jvm.java.array;

import jvm.java.base.ByteArray;
import jvm.java.loader.Klass;

/**
 * Created by admin on 2017/1/13.
 */
public class ShortArrayObject extends ArrayObject {

    ByteArray shortArray;
    public ShortArrayObject(int id, Klass klass, int length) {
        super(id, klass, length);
        this.shortArray = new ByteArray(length, 2);
    }

    public int getUnsignedShort(int index){
        return this.shortArray.getUnsignedShort(index);
    }

    public short getShort(int index){
        return  this.shortArray.getShort(index);
    }

    public void setShort(int index, int value) {
        this.shortArray.setShort(index, value);
    }
}
