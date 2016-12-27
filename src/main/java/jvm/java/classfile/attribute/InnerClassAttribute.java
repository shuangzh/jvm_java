package jvm.java.classfile.attribute;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Created by admin on 2016/12/27.
 */
public class InnerClassAttribute extends AttributeInfo {

    int number_of_classes;      // u2
    InnerClassesInfo[] inner_classes;

    public InnerClassAttribute(AttributeInfo attributeInfo) throws IOException {
        super(attributeInfo);

        DataInputStream dataInputStream = createDataInputStream();
        this.number_of_classes =  dataInputStream.readUnsignedShort();
        if (number_of_classes > 0) {
            inner_classes = new InnerClassesInfo[number_of_classes];
            for(int i=0; i<number_of_classes; i++) {
                inner_classes[i]= new InnerClassesInfo(dataInputStream);
            }
        }
    }

    class InnerClassesInfo{
        int inner_class_info_index;         // u2
        int outer_class_info_index;         // u2
        int inner_name_index;               // u2
        int inner_class_access_flags;       // u2

        InnerClassesInfo(DataInputStream dataInputStream) throws IOException {
            this.inner_class_info_index = dataInputStream.readUnsignedShort();
            this.outer_class_info_index = dataInputStream.readUnsignedShort();
            this.inner_name_index = dataInputStream.readUnsignedShort();
            this.inner_class_access_flags = dataInputStream.readUnsignedShort();
        }


    }


}
