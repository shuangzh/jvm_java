package jvm.java.io;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Created by admin on 2016/12/26.
 */
public class ConstantDoubleInfo extends ConstantInfo {
    double doubleValue;

    public ConstantDoubleInfo(DataInputStream dataInputStream) throws IOException {
        this.setTag(TAG_ConstantDoubleInfo);
        this.doubleValue = dataInputStream.readDouble();
    }
}
