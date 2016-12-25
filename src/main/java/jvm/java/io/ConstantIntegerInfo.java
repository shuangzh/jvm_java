package jvm.java.io;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Created by admin on 2016/12/26.
 */
public class ConstantIntegerInfo extends ConstantInfo {
    int intValue;

    public  ConstantIntegerInfo(DataInputStream dataInputStream) throws IOException {
        this.setTag(ConstantInfo.TAG_ConstantIntegerInfo);
        this.intValue = dataInputStream.readInt();
    }
}
