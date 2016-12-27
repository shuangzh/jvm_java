package jvm.java.classfile.constantpool;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Created by admin on 2016/12/26.
 */
public class ConstantFloatInfo extends ConstantInfo {
    float floatValue;       // u4
    public  ConstantFloatInfo(DataInputStream dataInputStream) throws IOException {
        this.setTag(ConstantInfo.TAG_ConstantFloatInfo);
        this.floatValue = dataInputStream.readFloat();
    }
}
