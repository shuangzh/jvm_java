package jvm.java.base;

/**
 * Created by admin on 2016/12/28.
 */
public class ByteArrayStack  extends ByteArray{
    int pos;

    public ByteArrayStack(byte[] buf) {
        super(buf);
        this.pos = 0;
    }

    public ByteArrayStack(int size) {
        super(size);
        this.pos = 0;
    }

    public int popByte() {
      return  this.getUnsignedByte(--pos);
    }

    public void pushByte(int i) {
        this.setByte(pos++, i);
    }

    public int popShort(){
        pos -=2;
        return this.getUnsignedShort(pos);
    }

    public void pushShort(int s){
        this.setShort(pos, s);
        pos +=2;
    }

    public int popInt() {
        pos -= 4;
        return this.getInt(pos);
    }

    public void pushInt(int i) {
        this.setInt(pos, i);
        pos += 4;
    }

    public long popLong() {
        pos -= 8;
        return this.getLong(pos);
    }

    public void pushLong(long v) {
        this.setLong(pos, v);
        pos += 8;
    }

    public float popFloat() {
        pos -= 4;
        return  this.getFloat(pos);
    }

    public void pushFloat(float f) {
        this.setFloat(pos, f);
        pos += 4;
    }

    public double popDouble() {
        pos -=8;
        return this.getDouble(pos);
    }

    public void pushDouble(double d) {
        this.setDouble(pos, d);
        pos +=8;
    }

//    public void reset() {
//        pos = 0;
//    }

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

    public int peekByte() {
        return  this.getUnsignedByte(pos - 1);
    }

    public int peekShort(){
        return  this.getUnsignedShort(pos-2);
    }

    public float peekFloat() {
        return  this.getFloat(pos - 4);
    }

    public int peekInt() {
            return this.getInt(pos - 4);
        }

    public long peekLong() {
        return  this.getLong(pos - 8);
    }

    public double peekDouble() {
        return this.getDouble(pos - 8);
    }

    public void empty() {
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

}
