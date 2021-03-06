package jvm.java.classfile.constantpool;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Created by admin on 2016/12/26.
 */
public class ConstantMethodHandleInfo extends  ConstantInfo {
    int referenceKind;      // u1
    int referenceIndex;     // u2

    public ConstantMethodHandleInfo(DataInputStream dataInputStream) throws IOException {
        this.setTag(TAG_ConstantMethodHandleInfo);
        this.referenceKind = dataInputStream.readUnsignedByte();
        this.referenceIndex = dataInputStream.readUnsignedShort();
    }
}
