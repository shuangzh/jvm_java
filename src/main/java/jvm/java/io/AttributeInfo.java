package jvm.java.io;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Created by admin on 2016/12/25.
 */
public class AttributeInfo {

    int attribute_name_index;
    int attribute_length;
    byte[] info;
    
    public AttributeInfo(DataInputStream dataInputStream) throws IOException {
        this.attribute_name_index = dataInputStream.readUnsignedShort();
        this.attribute_length = dataInputStream.readInt();
        if (this.attribute_length > 0);
        this.info = new byte[this.attribute_length];
        dataInputStream.read(this.info);
    }
}
