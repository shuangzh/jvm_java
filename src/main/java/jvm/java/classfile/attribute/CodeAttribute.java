package jvm.java.classfile.attribute;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

/**
 * Created by admin on 2016/12/26.
 */
public class CodeAttribute  extends AttributeInfo {

    int max_stack;              // u2
    int max_locals;             // u2
    int code_length;            // u4
    byte[] code;

    public int getMax_stack() {
        return max_stack;
    }

    public int getMax_locals() {
        return max_locals;
    }

    public int getCode_length() {
        return code_length;
    }

    public int getException_table_length() {
        return exception_table_length;
    }

    public ExceptionTable[] getExceptionTables() {
        return exceptionTables;
    }

    public int getAttributes_count() {
        return attributes_count;
    }

    public AttributeInfo[] getAttributes() {
        return attributes;
    }

    int exception_table_length;     // u2
    ExceptionTable[] exceptionTables;
    int attributes_count;           // u2
    AttributeInfo[] attributes;

    public CodeAttribute(AttributeInfo attributeInfo) throws IOException {
        super(attributeInfo);
        this.rebuild(this.createDataInputStream());
    }

    protected void rebuild(DataInputStream dataInputStream) throws IOException {
        this.max_stack = dataInputStream.readUnsignedShort();
        this.max_locals = dataInputStream.readUnsignedShort();
        this.code_length = dataInputStream.readInt();
        if(code_length > 0) {
            this.code = new  byte[code_length];
            dataInputStream.read(this.code);
        }
        this.exception_table_length = dataInputStream.readUnsignedShort();
        if (this.exception_table_length > 0)
        {
            this.exceptionTables = new ExceptionTable[exception_table_length];
            for(int i=0;i<exception_table_length; i++) {
                this.exceptionTables[i] = new ExceptionTable(dataInputStream);
            }
        }
        this.attributes_count = dataInputStream.readUnsignedShort();
        if(attributes_count > 0) {
            this.attributes = new AttributeInfo[attributes_count];
            for(int i =0 ; i<attributes_count; i++){
                this.attributes[i]= new AttributeInfo(dataInputStream, this.classFile);
                attributes[i] = AttributeReBuilder.build(attributes[i]);
            }
        }
    }

    public byte[] getCode() {
        return code;
    }
}
