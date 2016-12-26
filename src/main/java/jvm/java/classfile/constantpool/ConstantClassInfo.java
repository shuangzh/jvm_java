package jvm.java.classfile.constantpool;

import jvm.java.classfile.ClassFile;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Created by admin on 2016/12/26.
 */
public class ConstantClassInfo extends ConstantInfo {
    final int index;

    ClassFile classFile;

    public ConstantClassInfo(DataInputStream dataInputStream) throws IOException {
        this.setTag(ConstantInfo.TAG_ConstantClassInfo);
        this.index = dataInputStream.readUnsignedShort();
    }
}
