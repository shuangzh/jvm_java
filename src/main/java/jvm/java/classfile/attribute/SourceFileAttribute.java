package jvm.java.classfile.attribute;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Created by admin on 2016/12/27.
 */
public class SourceFileAttribute extends AttributeInfo {

    int sourcefile_index;

    public SourceFileAttribute(AttributeInfo attributeInfo) throws IOException {
        super(attributeInfo);
        DataInputStream dataInputStream = this.createDataInputStream();
        this.sourcefile_index= dataInputStream.readUnsignedShort();
    }
}
