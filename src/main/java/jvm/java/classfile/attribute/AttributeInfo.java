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
    public final static String ATTR_Code = "Code";
    public final static String ATTR_ConstantValue = "ConstantValue";
    public final static String ATTR_Deprecated = "Deprecated";
    public final static String ATTR_Exceptions = "Exceptions";
    public final static String ATTR_InnerClasses = "InnerClasses";
    public final static String ATTR_LineNumberTable = "LineNumberTable";
    public final static String ATTR_Signature = "Signature";
    public final static String ATTR_SourceFile = "SourceFile";
    public final static String ATTR_Synthetic = "Synthetic";
    public final static String ATTR_LocalVariableTable = "LocalVariableTable";


    int attribute_name_index;           // u2
    int attribute_length;               // u4
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

    public AttributeInfo(AttributeInfo attributeInfo) {
        this.duplicate(attributeInfo);
    }

    public String attribute_name() {
        ConstantInfo info = this.classFile.getConstantInfoPool()[this.attribute_name_index];
        if (info instanceof ConstantUtf8Info)
            return ((ConstantUtf8Info) info).getValue();
        else
            throw new RuntimeException("attribute_name_index is not a constantUtf8Info");
    }

    protected void duplicate(AttributeInfo attributeInfo) {
        this.attribute_name_index = attributeInfo.attribute_name_index;
        this.attribute_length = attributeInfo.attribute_length;
        this.classFile = attributeInfo.classFile;
        this.info = attributeInfo.info;
    }

    protected DataInputStream createDataInputStream() {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.info);
        DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
        return dataInputStream;
    }
}
