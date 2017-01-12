package jvm.java.base;

/**
 * Created by admin on 2017/1/3.
 */
public class SlotArray {
    ByteArray byteArray = null;
    int len = 0;
    int unit = 4;            // default slot size is 4 byte

    public SlotArray(int maxSize) {
        this.len = maxSize;
        byteArray = new ByteArray(maxSize * unit);
    }

    public int getLength() {
        return len;
    }

    public int getInt(int index) {
        return byteArray.getInt(index * unit);
    }

    public void setInt(int index, int value) {
        byteArray.setInt(index * unit, value);
    }

    public long getLong(int index) {
        return byteArray.getLong(index * unit);
    }

    public void setLong(int index, long value) {
        byteArray.setLong(index * unit, value);
    }

    public float getFloat(int index) {
        return byteArray.getFloat(index * unit);
    }

    public void setFloat(int index, float value) {
        byteArray.setFloat(index * unit, value);
    }

    public double getDouble(int index) {
        return byteArray.getDouble(index * unit);
    }

    public void setDouble(int index, double value) {
        byteArray.setDouble(index * unit, value);
    }

    public int getRef(int index) {
        return this.getInt(index);
    }

    public void setRef(int index, int ref) {
        this.setInt(index, ref);
    }
}
