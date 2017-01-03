package jvm.java.loader;

import jvm.java.base.RefObject;
import jvm.java.classfile.constantpool.ConstantMethodrefInfo;

/**
 * Created by admin on 2017/1/4.
 */
public class MethodRef extends RefObject {
    String classname;
    String name;
    String descriptor;

    Method method;

    public MethodRef(ConstantMethodrefInfo constantMethodrefInfo) {
        this.classname = constantMethodrefInfo.getClassName();
        this.name = constantMethodrefInfo.getName();
        this.descriptor = constantMethodrefInfo.getDescriptor();
    }
}
