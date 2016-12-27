package jvm.java.classfile.attribute;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Created by admin on 2016/12/27.
 */
public class LocalVariableTableAttribute extends AttributeInfo {

    int local_variable_table_length;    // u2

    LocalVariableInfo[] local_variable_table;


    public LocalVariableTableAttribute(AttributeInfo attributeInfo) throws IOException {
        super(attributeInfo);

        DataInputStream dataInputStream= createDataInputStream();
        local_variable_table_length = dataInputStream.readUnsignedShort();
        if (local_variable_table_length > 0 ) {
            this.local_variable_table = new LocalVariableInfo[local_variable_table_length];
            for(int i=0; i< local_variable_table_length ; i++) {
                    local_variable_table[i] = new LocalVariableInfo(dataInputStream);
            }
        }
    }

    class LocalVariableInfo{
        int start_pc;       // u2;
        int length;         // u2;
        int name_index;     // u2;
        int descriptor_index;       // u2;
        int index;          // u2;

        LocalVariableInfo(DataInputStream dataInputStream) throws IOException {
            this.start_pc = dataInputStream.readUnsignedShort();
            this.length = dataInputStream.readUnsignedShort();
            this.name_index = dataInputStream.readUnsignedShort();
            this.descriptor_index = dataInputStream.readUnsignedShort();
            this.index = dataInputStream. readUnsignedShort();
        }
    }



}
