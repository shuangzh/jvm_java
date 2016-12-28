package jvm.java.runtime;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.util.DoubleSummaryStatistics;

/**
 * Created by admin on 2016/12/28.
 */
public class ByteArrayStack {
    int pos;
    int size;
    byte[] buf;

    public ByteArrayStack(byte[] buf) {
        this.buf = buf;
        this.size = buf.length;
        this.pos = 0;
    }

    public ByteArrayStack(int size) {
        this.buf = new byte[size];
        this.size = size;
        this.pos = 0;
    }

    public static void main(String[] args) {
        ByteArrayStack byteArrayStack = new ByteArrayStack(100);
        byteArrayStack.pushInt(100);
        byteArrayStack.pushInt(-2448);
        int i = byteArrayStack.popInt();
        assert i == -2448;
        i = byteArrayStack.popInt();
        assert i == 100;

        byteArrayStack.pushInt(1000);
        byteArrayStack.pushFloat(101.1f);
        byteArrayStack.pushDouble(200.11d);
        int pos = byteArrayStack.getPos();
        byteArrayStack.pushFloat(0.59f);
        float f = byteArrayStack.popFloat();
        assert f == 0.59f;
        double d = byteArrayStack.popDouble();
        assert d == 200.11d;
        byteArrayStack.pushInt(1000);
        byteArrayStack.pushInt(2);
        byteArrayStack.pushInt(3);

        byteArrayStack.popInt();
        byteArrayStack.popInt();
        byteArrayStack.popInt();

        f = byteArrayStack.popFloat();
        assert f == 101.1f;
        i = byteArrayStack.popInt();
        assert i == 1000;

        assert 0 == byteArrayStack.getPos();

        byteArrayStack.setPos(pos);
        d = byteArrayStack.popDouble();
        assert d == 200.11d;

    }

    public int popByte() {
        int i = buf[pos--] & 0xFF;
        return i;
    }

    public void pushByte(int i) {
        buf[pos++] = (byte) i;
    }

    public void pushByte(byte b) {
        buf[pos++] = b;
    }

    public int popInt() {
        int ch1 = buf[pos - 4];
        int ch2 = buf[pos - 3];
        int ch3 = buf[pos - 2];
        int ch4 = buf[pos - 1];
        pos -= 4;
        return ((ch1 << 24) + (ch2 << 16) + (ch3 << 8) + (ch4 << 0));
    }

    public void pushInt(int i) {
        buf[pos + 0] = (byte) ((i >>> 24) & 0xFF);
        buf[pos + 1] = (byte) ((i >>> 16) & 0xFF);
        buf[pos + 2] = (byte) ((i >>> 8) & 0xFF);
        buf[pos + 3] = (byte) ((i >>> 0) & 0xFF);
        pos += 4;
    }

    public long popLong() {
        long l = (((long) buf[pos - 8] << 56) +
                ((long) (buf[pos - 7] & 255) << 48) +
                ((long) (buf[pos - 6] & 255) << 40) +
                ((long) (buf[pos - 5] & 255) << 32) +
                ((long) (buf[pos - 4] & 255) << 24) +
                ((buf[pos - 3] & 255) << 16) +
                ((buf[pos - 2] & 255) << 8) +
                ((buf[pos - 1] & 255) << 0));
        pos -= 8;
        return l;
    }

    public void pushLong(long v) {
        buf[pos + 0] = (byte) (v >>> 56);
        buf[pos + 1] = (byte) (v >>> 48);
        buf[pos + 2] = (byte) (v >>> 40);
        buf[pos + 3] = (byte) (v >>> 32);
        buf[pos + 4] = (byte) (v >>> 24);
        buf[pos + 5] = (byte) (v >>> 16);
        buf[pos + 6] = (byte) (v >>> 8);
        buf[pos + 7] = (byte) (v >>> 0);
        pos += 8;
    }

    public float popFloat() {
        return Float.intBitsToFloat(this.popInt());
    }

    public void pushFloat(float f) {
        this.pushInt(Float.floatToIntBits(f));
    }

    public double popDouble() {
        return Double.longBitsToDouble(this.popLong());
    }

    public void pushDouble(double d) {
        this.pushLong(Double.doubleToLongBits(d));
    }

    public void reset() {
        pos = 0;
    }

    public int capacity() {
        return size;
    }

    public int available() {
        return (size - pos);
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

}
