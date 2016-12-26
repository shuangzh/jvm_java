package jvm.java.classfile.attribute;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Created by admin on 2016/12/27.
 */
public class LineNumberTableAttribute  extends  AttributeInfo {
    int line_number_table_length;
    LineNumberInfo[] line_number_table;

    public LineNumberTableAttribute(AttributeInfo attributeInfo) throws IOException {
        super(attributeInfo);
        DataInputStream dataInputStream = createDataInputStream();
        this.line_number_table_length = dataInputStream.readUnsignedShort();
        if(line_number_table_length > 0) {
            line_number_table = new LineNumberInfo[line_number_table_length];
            for(int i=0; i< line_number_table_length ; i++) {
                line_number_table[i]= new LineNumberInfo(dataInputStream);
            }
        }
    }

    class LineNumberInfo {
        int start_pc;
        int line_number;
        LineNumberInfo(DataInputStream dataInputStream) throws IOException {
            this.start_pc = dataInputStream.readUnsignedShort();
            this.line_number = dataInputStream.readUnsignedShort();
        }
    }
}
