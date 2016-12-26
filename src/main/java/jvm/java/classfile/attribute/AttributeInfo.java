package jvm.java.classfile.attribute;

import jvm.java.classfile.ClassFile;
import jvm.java.classfile.constantpool.ConstantInfo;
import jvm.java.classfile.constantpool.ConstantUtf8Info;

import java.io.ByteArrayInputStream;
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

    public String attribute_name() {
        ConstantInfo info = this.classFile.getConstantInfoPool()[this.attribute_name_index];
        if ( info instanceof  ConstantUtf8Info)
            return  ((ConstantUtf8Info)info).getValue();
        else
            throw new RuntimeException("attribute_name_index is not a constantUtf8Info");
    }

    public AttributeInfo(AttributeInfo attributeInfo) {
        this.duplicate(attributeInfo);
    }

    protected  void duplicate(AttributeInfo attributeInfo) {
        this.attribute_name_index = attributeInfo.attribute_name_index;
        this.attribute_length = attributeInfo.attribute_length;
        this.classFile = attributeInfo.classFile;
        this.info = attributeInfo.info;
    }

    protected DataInputStream createDataInputStream(){
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.info);
        DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
        return  dataInputStream;
    }
}
