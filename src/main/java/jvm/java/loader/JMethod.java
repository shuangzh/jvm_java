package jvm.java.loader;

import jvm.java.base.Const;
import jvm.java.classfile.ClassFile;
import jvm.java.classfile.MethodInfo;
import jvm.java.utils.DescriptorUtil;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.StringReader;
import java.nio.CharBuffer;

/**
 * Created by admin on 2017/1/3.
 */
public class JMethod {

    int access_flag;
    String name;
    String descriptor;
    JClass classObject;
    MethodInfo methodInfo;
    byte[] code;
    int maxStack;
    int maxLocals;

    public JMethod(JClass classObject, ClassFile classFile, MethodInfo methodInfo) {
        this.access_flag = methodInfo.getAccess_flags();
        this.name = classFile.getConstantUtf8InfoValue(methodInfo.getName_index());
        this.descriptor = classFile.getConstantUtf8InfoValue(methodInfo.getDescriptor_index());
        this.classObject = classObject;
        if((this.access_flag & Const.ACC_NATIVE) == 0) {      // 非native方法，设置code属性
        this.code = methodInfo.getCodeAttribute().getCode();
        this.maxLocals = methodInfo.getCodeAttribute().getMax_locals();
        this.maxStack = methodInfo.getCodeAttribute().getMax_stack();
        }
        this.methodInfo = methodInfo;
    }

    public JMethod() {
    }

    public static void main(String[] args) {

        JMethod jMethod = new JMethod();
        jMethod.descriptor = "(IILjava/lang/String;Ljava/opt;I[[IFDV)V";
        String[] ds = jMethod.splitDescriptor();
        System.out.println("hello");
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

    public JClass getClassObject() {
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

    public String[] splitDescriptor() {
        return DescriptorUtil.split(this.descriptor);
    }

    public String[] getArgsDesciptors() {
        String str = null;
        if (!this.isStatic()) {
            str = "L" + this.classObject.getName() + ";" + this.descriptor;
        } else
            str = this.descriptor;
        str = str.substring(0, str.indexOf(")"));
        return DescriptorUtil.split(str);
    }


    public boolean isStatic() {
        if ((this.access_flag & Const.ACC_STATIC) != 0)
            return true;
        else
            return false;
    }
}
