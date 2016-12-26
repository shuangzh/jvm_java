package jvm.java.io;

import java.io.DataInputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by admin on 2016/12/26.
 */
public class ConstantUtf8Info extends  ConstantInfo {

    int length;
    byte[] bytes;
    String value;

    public  ConstantUtf8Info(DataInputStream dataInputStream) throws IOException {
        this.setTag(ConstantInfo.TAG_ConstantUtf8Info);
        this.length = dataInputStream.readUnsignedShort();
        if (length > 0) {
            bytes = new byte[length];
            dataInputStream.read(bytes);
            value = new String(bytes);
        }
    }
}
