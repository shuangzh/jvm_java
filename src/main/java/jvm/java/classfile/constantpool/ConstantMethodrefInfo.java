package jvm.java.classfile.constantpool;

import jvm.java.loader.Field;

import java.io.DataInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * Created by admin on 2016/12/26.
 */
public class ConstantMethodrefInfo extends ConstantFieldrefInfo {

    Method targetMethod;

    public ConstantMethodrefInfo(DataInputStream dataInputStream) throws IOException {
        super(dataInputStream);
        this.setTag(TAG_ConstantMethodrefInfo);
    }

    public Method getTargetMethod() {
        return targetMethod;
    }

    public void setTargetMethod(Method targetMethod) {
        this.targetMethod = targetMethod;
    }

    @Deprecated
    @Override
    public Field getTargetField() {
        throw new RuntimeException("ConstantMethodrefInfo don't have Field, can't invoke this method 'getTargetField'");
    }

    @Deprecated
    @Override
    public void setTargetField(Field targetField) {
       throw new RuntimeException("ConstantMethodrefInfo don't have Field, can't invoke this method 'setTargetField'");
    }
}
