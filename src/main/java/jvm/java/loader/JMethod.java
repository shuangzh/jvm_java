package jvm.java.loader;

import jvm.java.classfile.ClassFile;
import jvm.java.classfile.MethodInfo;

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
        this.code = methodInfo.getCodeAttribute().getCode();
        this.maxLocals = methodInfo.getCodeAttribute().getMax_locals();
        this.maxStack = methodInfo.getCodeAttribute().getMax_stack();
        this.methodInfo = methodInfo;
    }

    public JMethod()
    {}

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
        StringBuilder sb = new StringBuilder();
        char c;
        boolean isL = false;
        for (int i = 0; i < descriptor.length(); i++) {
            c = descriptor.charAt(i);
            JType jt = JType.transform(c);
            switch (jt) {
                case B:
                    ;
                case C:
                    ;
                case F:
                    ;
                case D:
                    ;
                case I:
                    ;
                case J:
                    ;
                case S:
                    ;
                case V:
                    ;
                case Z:
                    if (isL == false) {
                        sb.append(c);
                        sb.append(",");
                        break;
                    }
                case L:
                    isL = true;
                default:
                    switch (c) {
                        case '(':
                            break;
                        case ')':
                            break;
                        case ';':
                            isL = false;
                            sb.append(",");
                            break;
                        default:
                            sb.append(c);
                    }
            }

        }
        String s= sb.substring(0,sb.length());
        return s.split(",");
    }

    public JType[] splitedDescritorJType()
    {
        String[] dess= this.splitDescriptor();
        JType[] jTypes=new JType[dess.length];
        for(int i=0; i<dess.length; i++) {
            jTypes[i] = JType.transform(dess[i].charAt(0));
        }
        return  jTypes;
    }

    public static void main(String[] args) {

        JMethod jMethod=new JMethod();
        jMethod.descriptor="(IILjava/lang/String;Ljava/opt;I[[IFDV)V";
        String[] ds = jMethod.splitDescriptor();
        JType[] jTypes = jMethod.splitedDescritorJType();
        System.out.println("hello");

    }
}
