package jvm.java.classfile.attribute;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Created by admin on 2016/12/27.
 */
public class BootstrapMethodsAttribute extends AttributeInfo {

    int num_bootstrap_methods;          // u2;
    BootstrapMethod[] bootstrap_methods;

    public BootstrapMethodsAttribute(AttributeInfo attributeInfo) throws IOException {
        super(attributeInfo);
        DataInputStream dataInputStream = createDataInputStream();
        this.num_bootstrap_methods = dataInputStream.readUnsignedShort();
        if(num_bootstrap_methods > 0) {
            bootstrap_methods = new BootstrapMethod[num_bootstrap_methods];
            for(int i=0; i<num_bootstrap_methods; i++) {
                bootstrap_methods[i] = new BootstrapMethod(dataInputStream);
            }
        }
    }

    class BootstrapMethod {
        int bootstrap_method_ref;           // u2
        int num_bootstrap_arguments;        // u2
        int[] bootstrap_arguments;         // u2

        BootstrapMethod(DataInputStream dataInputStream) throws IOException {
            this.bootstrap_method_ref = dataInputStream.readUnsignedShort();
            this.num_bootstrap_arguments = dataInputStream.readUnsignedShort();
            if (num_bootstrap_arguments > 0 ) {
                bootstrap_arguments = new int[num_bootstrap_arguments];
                for (int i = 0; i < num_bootstrap_arguments; i++) {
                    bootstrap_arguments[i] = dataInputStream.readUnsignedShort();
                }
            }
        }
    }
}
