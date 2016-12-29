package jvm.java.runtime;

import jvm.java.base.ByteArray;
import jvm.java.base.ByteArrayStack;

/**
 * Created by admin on 2016/12/28.
 */
public class LocalVarsTable {
    ByteArray byteArray = null;
    public LocalVarsTable(int maxLocals) {
        byteArray = new ByteArray(maxLocals * 4);
    }

    public int getInt(int index) {
        index *= 4;
        return byteArray.getInt(index);
    }

    public void setInt(int index, int value) {

        index *= 4;
        byteArray.setInt(index, value);
    }

    public long getLong(int index) {
        index *= 4;
        return byteArray.getLong(index);
    }

    public void setLong(int index, long l) {
        index *= 4;
        byteArray.setLong(index, l);
    }

    public float getFloat(int index) {
        index *= 4;
        return byteArray.getFloat(index);
    }

    public void setFloat(int index, float f) {
        index *= 4;
        byteArray.setFloat(index, f);
    }

    public double getDouble(int index) {
        index *= 4;
        return byteArray.getDouble(index);
    }

    public void setDouble(int index, double d) {
        index *= 4;
        byteArray.setDouble(index, d);
    }
}
