package jvm.java.classfile.constantpool;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Created by admin on 2016/12/26.
 */
public class ConstantLongInfo extends  ConstantInfo {
    long longValue;

    public ConstantLongInfo(DataInputStream dataInputStream) throws IOException {
        this.setTag(TAG_ConstantLongInfo);
        this.longValue = dataInputStream.readLong();
    }
}
