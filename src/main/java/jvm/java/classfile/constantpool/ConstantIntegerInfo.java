package jvm.java.classfile.constantpool;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Created by admin on 2016/12/26.
 */
public class ConstantIntegerInfo extends ConstantInfo {
    public int getIntValue() {
        return intValue;
    }

    int intValue;       // u4

    public  ConstantIntegerInfo(DataInputStream dataInputStream) throws IOException {
        this.setTag(TAG_ConstantIntegerInfo);
        this.intValue = dataInputStream.readInt();
    }


}
