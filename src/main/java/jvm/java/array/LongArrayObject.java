package jvm.java.array;

import jvm.java.base.ByteArray;
import jvm.java.loader.Klass;

/**
 * Created by admin on 2017/1/13.
 */
public class LongArrayObject  extends ArrayObject{

    ByteArray longArray;
    public LongArrayObject(int id, Klass klass, int length) {
        super(id, klass, length);
        longArray = new ByteArray(length, 8);
    }

    public long getLong(int index){
        return  this.longArray.getLong(index);
    }

    public void setLong(int index, long value) {
        this.longArray.setLong(index, value);
    }

}
