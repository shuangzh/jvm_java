package jvm.java.classfile.attribute;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Created by admin on 2016/12/27.
 */
public class ExceptionsAttribute extends AttributeInfo {

    int number_of_exceptions;           // u2
    int[] exception_index_table;        // u2

    public ExceptionsAttribute(AttributeInfo attributeInfo) throws IOException {
        super(attributeInfo);
        DataInputStream dataInputStream = createDataInputStream();
        this.number_of_exceptions = dataInputStream.readUnsignedShort();
        if(number_of_exceptions > 0) {
            this.exception_index_table = new int[number_of_exceptions];
            for(int i=0; i< number_of_exceptions; i++) {
                exception_index_table[i]=dataInputStream.readUnsignedShort();
            }
        }
    }
}
