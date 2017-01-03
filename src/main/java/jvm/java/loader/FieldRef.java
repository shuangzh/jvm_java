package jvm.java.loader;

import jvm.java.base.RefObject;
import jvm.java.classfile.constantpool.ConstantFieldrefInfo;

/**
 * Created by admin on 2017/1/3.
 */
public class FieldRef extends RefObject {
    String classname;
    String name;
    String descriptor;

    Field field;

    public  FieldRef(ConstantFieldrefInfo constantFieldrefInfo) {
        this.classname = constantFieldrefInfo.getClassName();
        this.name = constantFieldrefInfo.getName();
        this.descriptor = constantFieldrefInfo.getDescriptor();
    }

}
