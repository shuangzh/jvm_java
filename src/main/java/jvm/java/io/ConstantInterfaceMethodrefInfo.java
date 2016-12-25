package jvm.java.io;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Created by admin on 2016/12/26.
 */

public class ConstantInterfaceMethodrefInfo extends ConstantFieldrefInfo {
    public ConstantInterfaceMethodrefInfo(DataInputStream dataInputStream) throws IOException {
        super(dataInputStream);
        this.setTag(TAG_ConstantInterfaceMethodrefInfo);
    }
}
