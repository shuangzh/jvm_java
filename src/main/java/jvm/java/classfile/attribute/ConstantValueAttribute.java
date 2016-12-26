package jvm.java.classfile.attribute;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Created by admin on 2016/12/27.
 */
public class ConstantValueAttribute extends AttributeInfo {

    int constantvalue_index;

    public ConstantValueAttribute(AttributeInfo attributeInfo) throws IOException {
        super(attributeInfo);
        DataInputStream dataInputStream=createDataInputStream();
        constantvalue_index = dataInputStream.readUnsignedShort();
    }
}
