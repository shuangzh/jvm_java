package jvm.java.array;

import jvm.java.base.ByteArray;
import jvm.java.loader.Klass;

/**
 * Created by admin on 2017/1/13.
 */
public class DoubleArrayObject extends ArrayObject {
    ByteArray doubleArray;

    public DoubleArrayObject(int id, Klass klass, int length) {
        super(id, klass, length);
        this.doubleArray = new ByteArray(length, 8);
    }

    public double getDouble(int index) {
        return  doubleArray.getDouble(index);
    }

    public void setDouble(int index, double value){
        doubleArray.setDouble(index, value);
    }


}
