package jvm.java.io;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Created by admin on 2016/12/26.
 */
public class ConstantMethodrefInfo extends ConstantFieldrefInfo {

    public ConstantMethodrefInfo(DataInputStream dataInputStream) throws IOException {
        super(dataInputStream);
        this.setTag(TAG_ConstantMethodrefInfo);
    }
}
