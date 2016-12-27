package jvm.java.classfile;

import jvm.java.classfile.attribute.AttributeInfo;
import jvm.java.classfile.constantpool.ConstantInfo;

/**
 * Created by admin on 2016/12/23.
 */
public class ClassFile {
    int magic;                          // u4
    int  minor_version;                 // u2
    int major_version;                  // u2
    int  constant_pool_count;           // u2
    ConstantInfo[] constantInfoPool;
    int access_flags;                   // u2
    int this_class;                     // u2
    int super_class;                    // u2
    int interfaces_count;               // u2
    int[] interfaces;                   // u2
    int fields_count;                   // u2;
    FieldInfo[] fields;
    int methods_count;                  // u2;
    MethodInfo[] methods;
    int attributes_count;               // u2;
    AttributeInfo[] attributes;

    public int getMagic() {
        return magic;
    }

    public void setMagic(int magic) {
        this.magic = magic;
    }

    public int getMinor_version() {
        return minor_version;
    }

    public void setMinor_version(int minor_version) {
        this.minor_version = minor_version;
    }

    public int getMajor_version() {
        return major_version;
    }

    public void setMajor_version(int major_version) {
        this.major_version = major_version;
    }

    public int getConstant_pool_count() {
        return constant_pool_count;
    }

    public void setConstant_pool_count(int constant_pool_count) {
        this.constant_pool_count = constant_pool_count;
    }

    public ConstantInfo[] getConstantInfoPool() {
        return constantInfoPool;
    }

    public void setConstantInfoPool(ConstantInfo[] constantInfoPool) {
        this.constantInfoPool = constantInfoPool;
    }

    public int getAccess_flags() {
        return access_flags;
    }

    public void setAccess_flags(int access_flags) {
        this.access_flags = access_flags;
    }

    public int getThis_class() {
        return this_class;
    }

    public void setThis_class(int this_class) {
        this.this_class = this_class;
    }

    public int getSuper_class() {
        return super_class;
    }

    public void setSuper_class(int super_class) {
        this.super_class = super_class;
    }

    public int getInterfaces_count() {
        return interfaces_count;
    }

    public void setInterfaces_count(int interfaces_count) {
        this.interfaces_count = interfaces_count;
    }

    public int[] getInterfaces() {
        return interfaces;
    }

    public void setInterfaces(int[] interfaces) {
        this.interfaces = interfaces;
    }

    public int getFields_count() {
        return fields_count;
    }

    public void setFields_count(int fields_count) {
        this.fields_count = fields_count;
    }

    public FieldInfo[] getFields() {
        return fields;
    }

    public void setFields(FieldInfo[] fields) {
        this.fields = fields;
    }

    public int getMethods_count() {
        return methods_count;
    }

    public void setMethods_count(int methods_count) {
        this.methods_count = methods_count;
    }

    public MethodInfo[] getMethods() {
        return methods;
    }

    public void setMethods(MethodInfo[] methods) {
        this.methods = methods;
    }

    public int getAttributes_count() {
        return attributes_count;
    }

    public void setAttributes_count(int attributes_count) {
        this.attributes_count = attributes_count;
    }

    public AttributeInfo[] getAttributes() {
        return attributes;
    }

    public void setAttributes(AttributeInfo[] attributes) {
        this.attributes = attributes;
    }
}
