package jvm.java.classfile.constantpool;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Created by admin on 2016/12/26.
 */
public class ConstantMethodTypeInfo  extends  ConstantInfo{
    int descriptorIndex;            // u2

    public ConstantMethodTypeInfo(DataInputStream dataInputStream) throws IOException {
        this.setTag(TAG_ConstantMethodTypeInfo);
        this.descriptorIndex = dataInputStream.readUnsignedShort();
    }
}
