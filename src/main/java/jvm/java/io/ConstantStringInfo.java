package jvm.java.io;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Created by admin on 2016/12/26.
 */
public class ConstantStringInfo extends  ConstantInfo {
    int index;

    public ConstantStringInfo(DataInputStream dataInputStream) throws IOException {
        this.setTag(ConstantInfo.TAG_ConstantStringInfo);
        this.index = dataInputStream.readUnsignedShort();
    }
}
