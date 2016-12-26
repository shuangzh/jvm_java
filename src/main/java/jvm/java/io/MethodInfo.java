package jvm.java.io;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Created by admin on 2016/12/25.
 */
public class MethodInfo {

    int access_flags;
    int name_index;
    int descriptor_index;
    int attributes_count;
    AttributeInfo[] attributes;


    public int getAccess_flags() {
        return access_flags;
    }

    public void setAccess_flags(int access_flags) {
        this.access_flags = access_flags;
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

    public MethodInfo(DataInputStream dataInputStream) throws IOException {
        this.access_flags = dataInputStream.readUnsignedShort();
        this.name_index = dataInputStream.readUnsignedShort();
        this.descriptor_index = dataInputStream.readUnsignedShort();
        this.attributes_count = dataInputStream.readUnsignedShort();
        if(this.attributes_count > 0 ) {
            this.attributes = new AttributeInfo[this.attributes_count];
            for(int i=0; i< this.attributes_count ; i++) {
                this.attributes[i] = new AttributeInfo(dataInputStream);
            }
        }
    }
}
