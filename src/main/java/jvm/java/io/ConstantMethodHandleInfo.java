package jvm.java.io;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Created by admin on 2016/12/26.
 */
public class ConstantMethodHandleInfo extends  ConstantInfo {
    int referenceKind;
    int referenceIndex;

    public ConstantMethodHandleInfo(DataInputStream dataInputStream) throws IOException {
        this.setTag(TAG_ConstantMethodHandleInfo);
        this.referenceKind = dataInputStream.readUnsignedByte();
        this.referenceIndex = dataInputStream.readUnsignedShort();
    }
}
