package jvm.java.classfile.attribute;

import java.io.ByteArrayInputStream;

/**
 * Created by admin on 2016/12/26.
 */
public class CodeAttribute  extends AttributeInfo {

    int max_stack;
    int max_locals;
    int code_length;
    byte[] code;
    int exception_table_length;


    public CodeAttribute(AttributeInfo attributeInfo){
        this.duplicate(attributeInfo);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.info);


    }

}
