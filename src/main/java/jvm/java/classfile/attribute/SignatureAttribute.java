package jvm.java.classfile.attribute;

import javax.activation.DataSource;
import java.io.DataInputStream;
import java.io.IOException;

/**
 * Created by admin on 2016/12/27.
 */
public class SignatureAttribute extends  AttributeInfo {
    int signature_index;    // u2

    public SignatureAttribute(AttributeInfo attributeInfo) throws IOException {
        super(attributeInfo);
        DataInputStream dataInputStream = createDataInputStream();
        this.signature_index = dataInputStream.readUnsignedShort();
    }
}
