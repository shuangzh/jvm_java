package jvm.java.base;

/**
 * Created by admin on 2016/12/28.
 */
public class ByteArray {
    int size;
    byte[] buf;

    public ByteArray(byte[] buf) {
        this.buf = buf;
        this.size = buf.length;
    }

    public ByteArray(int size) {
        this.size = size;
        this.buf = new byte[size];
    }

    public int getInt(int index) {
        int ch1 = buf[index + 0];
        int ch2 = buf[index + 1];
        int ch3 = buf[index + 2];
        int ch4 = buf[index + 3];
        return ((ch1 << 24) + (ch2 << 16) + (ch3 << 8) + (ch4 << 0));
    }

    public void setInt(int index, int i) {
        buf[index + 0] = (byte) ((i >>> 24) & 0xFF);
        buf[index + 1] = (byte) ((i >>> 16) & 0xFF);
        buf[index + 2] = (byte) ((i >>> 8) & 0xFF);
        buf[index + 3] = (byte) ((i >>> 0) & 0xFF);
    }

    public long getLong(int index) {
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
        return Float.intBitsToFloat(this.getInt(index));
    }

    public void setFloat(int index, float f) {
        this.setInt(index, Float.floatToIntBits(f));
    }

    public Double getDouble(int index) {
        return Double.longBitsToDouble(this.getLong(index));
    }

    public void setDouble(int index, double d) {
        this.setLong(index, Double.doubleToLongBits(d));
    }

    public byte getByte(int index) {
        return buf[index];
    }

    public int getUnsignedByte(int index) {
        return buf[index] & 0xFF;
    }

    public void setByte(int index, int i) {
        this.buf[index] = (byte) i;
    }

    public short getShort(int index) {
        return (short) (buf[index] << 8 + buf[index + 1]);
    }

    public int getUnsignedShort(int index) {
        return buf[index] << 8 + buf[index + 1];
    }

    public void setShort(int index, short s) {
        buf[index] = (byte) ((s >>> 8) & 0xFF);
        buf[index + 1] = (byte) (s & 0xFF);
    }

    public int size() {
        return  this.size;
    }

    public void reset(byte[] bytes) {
        this.buf = bytes;
        this.size =buf.length;
    }

}
