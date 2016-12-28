package jvm.java.runtime;

import jvm.java.base.ByteArray;

/**
 * Created by admin on 2016/12/28.
 */
public class CodeReader {
    int pc = 0;
    ByteArray byteArray = null;

    public CodeReader(byte[] code) {
        this.byteArray = new ByteArray(code);
        pc = 0;
    }

    public int readInstructionCode(int pc) {
        this.pc = pc;
        return byteArray.getUnsignedByte(this.pc++);
    }

    public int readInt() {
        int i = byteArray.getInt(pc);
        pc += 4;
        return i;
    }

    public long readLong() {
        long l = byteArray.getLong(pc);
        pc += 8;
        return l;
    }

    public short readShort() {
        short s = byteArray.getShort(pc);
        pc += 2;
        return s;
    }

    public int readUnsignedShort() {
        int s = byteArray.getUnsignedShort(pc);
        pc += 2;
        return s;
    }

    public float readFloat() {
        float f = byteArray.getFloat(pc);
        pc += 4;
        return f;
    }

    public double readDouble() {
        double d = byteArray.getDouble(pc);
        pc += 8;
        return d;
    }

    public byte readByte() {
        return byteArray.getByte(pc++);
    }

    public int readUnsignedByte() {
        return byteArray.getUnsignedByte(pc++);
    }

    public int PC() {
        return pc;
    }


}
