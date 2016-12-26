package jvm.java.classfile.attribute;

import jvm.java.classfile.ClassFile;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Created by admin on 2016/12/25.
 */
public class AttributeInfo {
    public final static  String ATTRI_CODE= "CODE";

    int attribute_name_index;
    int attribute_length;
    byte[] info;

    ClassFile classFile;

    public AttributeInfo(DataInputStream dataInputStream, ClassFile classFile) throws IOException {
        this.attribute_name_index = dataInputStream.readUnsignedShort();
        this.attribute_length = dataInputStream.readInt();
        this.classFile = classFile;
        if (this.attribute_length > 0) {
            this.info = new byte[this.attribute_length];
            dataInputStream.read(this.info);
        }
    }

    public AttributeInfo()
    {

    }

    protected  void duplicate(AttributeInfo attributeInfo) {
        this.attribute_name_index = attributeInfo.attribute_name_index;
        this.attribute_length = attributeInfo.attribute_length;
        this.classFile = attributeInfo.classFile;
        this.info = attributeInfo.info;
    }
}
