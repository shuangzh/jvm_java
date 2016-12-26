package jvm.java.classfile.constantpool;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Created by admin on 2016/12/26.
 */
public class ConstantUtf8Info extends  ConstantInfo {

    int length;
    byte[] bytes;

    public String getValue() {
        return value;
    }

    String value;

    public  ConstantUtf8Info(DataInputStream dataInputStream) throws IOException {
        this.setTag(TAG_ConstantUtf8Info);
        this.length = dataInputStream.readUnsignedShort();
        if (length > 0) {
            bytes = new byte[length];
            dataInputStream.read(bytes);
            value = new String(bytes);
        }
    }
}
