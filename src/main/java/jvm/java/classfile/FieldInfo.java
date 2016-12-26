package jvm.java.classfile;

import jvm.java.classfile.attribute.AttributeInfo;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Created by admin on 2016/12/25.
 */
public class FieldInfo {
    int access_flag;
    int name_index;
    int descriptor_name;
    int attributes_count;
    AttributeInfo[] attributes;
    ClassFile classFile;

    public FieldInfo(DataInputStream dataInputStream, ClassFile classFile) throws IOException {
        this.classFile = classFile;
        this.access_flag = dataInputStream. readUnsignedShort();
        this.name_index = dataInputStream.readUnsignedShort();
        this.descriptor_name=dataInputStream.readUnsignedShort();
        this.attributes_count =dataInputStream.readUnsignedShort();
        if(this.attributes_count > 0) {
            this.attributes = new AttributeInfo[this.attributes_count];;
            for (int i =0; i< this.getAttributes_count(); i++) {
                this.attributes[i] = new AttributeInfo(dataInputStream, classFile);
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

    public int getDescriptor_name() {
        return descriptor_name;
    }

    public void setDescriptor_name(int descriptor_name) {
        this.descriptor_name = descriptor_name;
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
