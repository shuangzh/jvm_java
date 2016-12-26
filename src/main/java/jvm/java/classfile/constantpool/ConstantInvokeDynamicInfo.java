package jvm.java.classfile.constantpool;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Created by admin on 2016/12/26.
 */
public class ConstantInvokeDynamicInfo  extends  ConstantInfo {
    int bootstrapMethodAttrIndex;
    int nameAndTypeIndex;

    public ConstantInvokeDynamicInfo(DataInputStream dataInputStream) throws IOException {
        this.setTag(TAG_ConstantInvokeDynamicInfo);
        this.bootstrapMethodAttrIndex = dataInputStream.readUnsignedShort();
        this.nameAndTypeIndex = dataInputStream.readUnsignedShort();
    }
}
