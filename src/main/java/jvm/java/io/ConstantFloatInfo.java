package jvm.java.io;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Created by admin on 2016/12/26.
 */
public class ConstantFloatInfo extends ConstantInfo {
    float floatValue;
    public  ConstantFloatInfo(DataInputStream dataInputStream) throws IOException {
        this.setTag(ConstantInfo.TAG_ConstantFloatInfo);
        this.floatValue = dataInputStream.readFloat();
    }
}
