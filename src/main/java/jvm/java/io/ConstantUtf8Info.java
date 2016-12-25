package jvm.java.io;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Created by admin on 2016/12/26.
 */
public class ConstantUtf8Info extends  ConstantInfo {

    int length;
    byte[] bytes;

    public  ConstantUtf8Info(DataInputStream dataInputStream) throws IOException {
        this.setTag(ConstantInfo.TAG_ConstantUtf8Info);
        this.length = dataInputStream.readInt();
        if (length > 0) {
            bytes = new byte[length];
            dataInputStream.read(bytes);
        }
    }
}
