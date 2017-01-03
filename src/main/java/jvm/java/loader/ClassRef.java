package jvm.java.loader;

import jvm.java.base.RefObject;
import jvm.java.classfile.constantpool.ConstantClassInfo;

/**
 * Created by admin on 2017/1/3.
 */
public class ClassRef  extends RefObject {
    String classname;
    ClassObject classObject;

    public ClassRef(ConstantClassInfo constantClassInfo) {
        this.classname = constantClassInfo.getClassName();
    }

    public String getClassname() {
        return classname;
    }

    public ClassObject getClassObject() {
        return classObject;
    }

    public void setClassObject(ClassObject classObject) {
        this.classObject = classObject;
    }
}
