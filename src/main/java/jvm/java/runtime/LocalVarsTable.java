package jvm.java.runtime;

/**
 * Created by admin on 2016/12/28.
 */
public class LocalVarsTable {

    ByteArrayStack byteArrayStack = null;

    public LocalVarsTable(int maxLocals) {
        byteArrayStack = new ByteArrayStack(maxLocals * 4);
    }

    public int getInt(int index) {
        byteArrayStack.setPos(index + 4);
        return byteArrayStack.popInt();
    }

    public void setInt(int index, int value) {
        byteArrayStack.setPos(index);
        byteArrayStack.pushInt(value);
    }

    public long getLong(int index)
    {
        byteArrayStack.setPos(index + 8);
        return byteArrayStack.popLong();
    }

    public void setLong(int index, long l)
    {
        byteArrayStack.setPos(index);
        byteArrayStack.pushLong(l);
    }

    public float getFloat(int index) {
        byteArrayStack.setPos(index + 4);
        return  byteArrayStack.popFloat();
    }

    public void setFloat(int index, float f) {
        byteArrayStack.setPos(index);
        byteArrayStack.pushFloat(f);
    }

    public double getDouble(int index){
        byteArrayStack.setPos(index + 8);
        return byteArrayStack.popDouble();
    }

    public void setDouble(int index, double d) {
        byteArrayStack.setPos(index);
        byteArrayStack.pushDouble(d);
    }



}
