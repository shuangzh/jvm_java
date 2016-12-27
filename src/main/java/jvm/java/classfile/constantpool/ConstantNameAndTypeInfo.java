package jvm.java.classfile.constantpool;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Created by admin on 2016/12/26.
 */
public class ConstantNameAndTypeInfo extends ConstantInfo {
    int nameIndex;              // u2
    int descriptorIndex;        // u2

    public ConstantNameAndTypeInfo(DataInputStream dataInputStream) throws IOException {
        this.setTag(TAG_ConstantNameAndTypeInfo);
        this.nameIndex = dataInputStream.readUnsignedShort();
        this.descriptorIndex = dataInputStream.readUnsignedShort();
    }
}
