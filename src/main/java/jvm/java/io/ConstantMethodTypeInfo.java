package jvm.java.io;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Created by admin on 2016/12/26.
 */
public class ConstantMethodTypeInfo  extends  ConstantInfo{
    int descriptorIndex;

    public ConstantMethodTypeInfo(DataInputStream dataInputStream) throws IOException {
        this.setTag(TAG_ConstantMethodTypeInfo);
        this.descriptorIndex = dataInputStream.readUnsignedShort();
    }
}
