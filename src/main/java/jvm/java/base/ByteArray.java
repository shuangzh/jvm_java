package jvm.java.base;

/**
 * Created by admin on 2016/12/28.
 */
public class ByteArray {
    int size;
    byte[] buf;
    int unit = 1;
    int length ;

    public ByteArray(byte[] buf) {
        this.buf = buf;
        this.size = buf.length;
        this.length  = size;
    }

    public ByteArray(int size) {
        this.size = size;
        this.buf = new byte[size];
        this.length =size;
    }

    public ByteArray(int len, int unit) {
        this.size = len * unit;
        this.length = len;
        this.buf = new byte[size];
        this.unit = unit;
    }

    public int getInt(int index) {
        index = index * unit;
        int ch1 = buf[index + 0] & 0xFF;
        int ch2 = buf[index + 1] & 0xFF;
        int ch3 = buf[index + 2] & 0xFF;
        int ch4 = buf[index + 3] & 0xFF;
        return ((ch1 << 24) + (ch2 << 16) + (ch3 << 8) + (ch4 << 0));
    }

    public void setInt(int index, int i) {
        index = index * unit;
        buf[index + 0] = (byte) ((i >>> 24) & 0xFF);
        buf[index + 1] = (byte) ((i >>> 16) & 0xFF);
        buf[index + 2] = (byte) ((i >>> 8) & 0xFF);
        buf[index + 3] = (byte) ((i >>> 0) & 0xFF);
    }

    public long getLong(int index) {
        index = index * unit;
        long l = (((long) buf[index + 0] << 56) +
                ((long) (buf[index + 1] & 255) << 48) +
                ((long) (buf[index + 2] & 255) << 40) +
                ((long) (buf[index + 3] & 255) << 32) +
                ((long) (buf[index + 4] & 255) << 24) +
                ((buf[index + 5] & 255) << 16) +
                ((buf[index + 6] & 255) << 8) +
                ((buf[index + 7] & 255) << 0));
        return l;
    }

    public void setLong(int index, long v) {
        index = index * unit;
        buf[index + 0] = (byte) (v >>> 56);
        buf[index + 1] = (byte) (v >>> 48);
        buf[index + 2] = (byte) (v >>> 40);
        buf[index + 3] = (byte) (v >>> 32);
        buf[index + 4] = (byte) (v >>> 24);
        buf[index + 5] = (byte) (v >>> 16);
        buf[index + 6] = (byte) (v >>> 8);
        buf[index + 7] = (byte) (v >>> 0);
    }

    public float getFloat(int index) {
        index = index * unit;
        return Float.intBitsToFloat(this.getInt(index));
    }

    public void setFloat(int index, float f) {
        index = index * unit;
        this.setInt(index, Float.floatToIntBits(f));
    }

    public Double getDouble(int index) {
        index = index * unit;
        return Double.longBitsToDouble(this.getLong(index));
    }

    public void setDouble(int index, double d) {
        index = index * unit;
        this.setLong(index, Double.doubleToLongBits(d));
    }

    public byte getByte(int index) {
        index = index * unit;
        return buf[index];
    }

    public int getUnsignedByte(int index) {
        index = index * unit;
        return buf[index] & 0xFF;
    }

    public void setByte(int index, int i) {
        index = index * unit;
        this.buf[index] = (byte) i;
    }

    public short getShort(int index) {
        index = index * unit;
        int b1= buf[index] & 0xFF;
        int b2= buf[index +1] & 0xFF;
        return (short) ( (b1 << 8) | b2 );
    }

    public int getUnsignedShort(int index) {
        index = index * unit;
        int b1 = buf[index] & 0xFF;
        int b2 = buf[index + 1] & 0xFF;
        return  ( b1<< 8 ) | b2;
    }

    public void setShort(int index, int s) {
        index = index * unit;
        buf[index] = (byte) ((s >>> 8) & 0xFF);
        buf[index + 1] = (byte) (s & 0xFF);
    }

    public int size() {
        return  this.size;
    }

    public int length() {
        return  this.length;
    }

//    public void reset(byte[] bytes) {
//        this.buf = bytes;
//        this.size =buf.length;
//    }

}
