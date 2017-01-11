package jvm.java.base;

/**
 * Created by admin on 2017/1/3.
 */
public class SlotArray {
    ByteArray byteArray = null;
    int len =0;

    public  SlotArray(int maxSize) {
        this.len=0;
        byteArray=new ByteArray(maxSize * 4);
    }

    public int getLength() {
        return len;
    }

    public int getInt(int index) {
        return byteArray.getInt(index * 4);
    }

    public void setInt(int index, int value) {
        byteArray.setInt(index*4, value);
    }

    public long getLong(int index) {
        return byteArray.getLong(index*4);
    }

    public void setLong(int index, long value) {
        byteArray.setLong(index*4, value);
    }

    public float getFloat(int index) {
        return  byteArray.getFloat(index * 4);
    }

    public void setFloat(int index, float value) {
        byteArray.setFloat(index * 4, value);
    }

    public double getDouble(int index){
        return  byteArray.getDouble(index*4);
    }

    public void  setDouble(int index, double value) {
        byteArray.setDouble(index*4, value);
    }

    public int getRef(int index)
    {
        return this.getInt(index);
    }

    public void  setRef(int index, int ref) {
        this.setInt(index, ref);
    }
}
