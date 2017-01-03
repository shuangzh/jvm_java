package jvm.java.classfile;

import jvm.java.classfile.attribute.AttributeInfo;
import jvm.java.classfile.attribute.AttributeReBuilder;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Created by admin on 2016/12/25.
 */
public class FieldInfo {
    int access_flag;            // u2
    int name_index;             // u2
    int descriptor_index;        // u2
    int attributes_count;       // u2
    AttributeInfo[] attributes;
    ClassFile classFile;

    public FieldInfo(DataInputStream dataInputStream, ClassFile classFile) throws IOException {
        this.classFile = classFile;
        this.access_flag = dataInputStream. readUnsignedShort();
        this.name_index = dataInputStream.readUnsignedShort();
        this.descriptor_index =dataInputStream.readUnsignedShort();
        this.attributes_count =dataInputStream.readUnsignedShort();
        if(this.attributes_count > 0) {
            this.attributes = new AttributeInfo[this.attributes_count];;
            for (int i =0; i< this.getAttributes_count(); i++) {
                this.attributes[i] = new AttributeInfo(dataInputStream, classFile);
                attributes[i] = AttributeReBuilder.build(attributes[i]);
            }
        }
    }


    public int getAccess_flag() {
        return access_flag;
    }

    public void setAccess_flag(int access_flag) {
        this.access_flag = access_flag;
    }

    public int getName_index() {
        return name_index;
    }

    public void setName_index(int name_index) {
        this.name_index = name_index;
    }

    public int getDescriptor_index() {
        return descriptor_index;
    }

    public void setDescriptor_index(int descriptor_index) {
        this.descriptor_index = descriptor_index;
    }

    public int getAttributes_count() {
        return attributes_count;
    }

    public void setAttributes_count(int attributes_count) {
        this.attributes_count = attributes_count;
    }

    public AttributeInfo[] getAttributes() {
        return attributes;
    }

    public void setAttributes(AttributeInfo[] attributes) {
        this.attributes = attributes;
    }
}
