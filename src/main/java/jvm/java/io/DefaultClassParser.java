package jvm.java.io;

import jvm.java.utils.ByteUtil;

/**
 * Created by admin on 2016/12/23.
 */
public class DefaultClassParser implements ClassParser {
    int pos = 0;
    protected  short readU2(ClassFile classFile){
        short s = ByteUtil.byteArrayToShort(classFile.bytes, pos);
        pos+=2;
        return  s;
    }

    protected int readU4(ClassFile classFile){
        int i= ByteUtil.byteArrayToInt(classFile.bytes, pos);
        pos +=4;
        return i;
    }

    protected  byte[] readBytes(ClassFile classFile, int len) {
        byte[] bytes=new byte[len];
        System.arraycopy(classFile.bytes, pos,bytes,0,len);
        pos+=len;
        return bytes;
    }

    protected void readAndCheckMagic(ClassFile classFile){
        int magic = this.readU4(classFile);
        assert(magic == 0xCAFEBABE);
        classFile.magic = magic;
    }

    protected void readAndCheckVersion(ClassFile classFile){
        short minor_version = this.readU2(classFile);
        short major_version = this.readU2(classFile);
        classFile.minor_version= minor_version;
        classFile.major_version= major_version;
    }



    public void parse(ClassFile classFile) {
        pos = 0;
        readAndCheckMagic(classFile);
        readAndCheckVersion(classFile);
    }
}
