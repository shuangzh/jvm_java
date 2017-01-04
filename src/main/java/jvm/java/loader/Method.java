package jvm.java.loader;

import jvm.java.classfile.ClassFile;
import jvm.java.classfile.MethodInfo;

/**
 * Created by admin on 2017/1/3.
 */
public class Method{

    int access_flag;
    String name;
    String descriptor;
    ClassObject classObject;
    MethodInfo methodInfo;
    byte[] code;
    int maxStack;
    int maxLocals;

    public Method(ClassObject classObject, ClassFile classFile, MethodInfo methodInfo) {
        this.access_flag= methodInfo.getAccess_flags();
        this.name = classFile.getConstantUtf8InfoValue(methodInfo.getName_index());
        this.descriptor = classFile.getConstantUtf8InfoValue(methodInfo.getDescriptor_index());
        this.classObject = classObject;
        this.code = methodInfo.getCodeAttribute().getCode();
        this.maxLocals = methodInfo.getCodeAttribute().getMax_locals();
        this.maxStack = methodInfo.getCodeAttribute().getMax_stack();
        this.methodInfo = methodInfo;
    }

    public int getAccess_flag() {
        return access_flag;
    }

    public String getName() {
        return name;
    }

    public String getDescriptor() {
        return descriptor;
    }

    public ClassObject getClassObject() {
        return classObject;
    }

    public byte[] getCode() {
        return code;
    }

    public int getMaxStack() {
        return maxStack;
    }

    public int getMaxLocals() {
        return maxLocals;
    }
}
