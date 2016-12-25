package jvm.java.io;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Created by admin on 2016/12/26.
 */
public class ConstantFieldrefInfo extends ConstantInfo {
    int classInfoIndex;
    int nameAndTypeIndex;

    ClassFile classFile;

    public ConstantFieldrefInfo(DataInputStream dataInputStream) throws IOException {
        this.setTag(ConstantInfo.TAG_ConstantFieldrefInfo);
        this.classInfoIndex = dataInputStream.readUnsignedShort();
        this.nameAndTypeIndex = dataInputStream.readUnsignedShort();
    }
}
