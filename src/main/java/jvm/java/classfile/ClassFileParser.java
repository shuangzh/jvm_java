package jvm.java.classfile;

import jvm.java.classfile.attribute.AttributeInfo;
import jvm.java.classfile.constantpool.*;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

/**
 * Created by admin on 2016/12/25.
 */
public class ClassFileParser {
    public ClassFile parse(byte[] bytes) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
        return parse(dataInputStream);
    }

    public ClassFile parse(DataInputStream dataInputStream) throws IOException {
        ClassFile classFile = new ClassFile();

        this.readMagic(dataInputStream, classFile);
        this.readVersion(dataInputStream, classFile);
        this.readConstantInfo(dataInputStream, classFile);
        this.readAccessFlag(dataInputStream, classFile);
        this.readThisClass(dataInputStream, classFile);
        this.readSuperClass(dataInputStream, classFile);
        this.readInterfaces(dataInputStream, classFile);
        this.readFields(dataInputStream, classFile);
        this.readMethods(dataInputStream, classFile);
        this.readAttributes(dataInputStream, classFile);

        return classFile;
    }

    public void readMagic(DataInputStream dataInputStream, ClassFile classFile) throws IOException {
        int magic = dataInputStream.readInt();
        if (magic == 0xCAFEBABE)
            classFile.setMagic(magic);
        else
            throw new IOException("Class Magic is not 0xCAFEBABE");
    }

    public void readVersion(DataInputStream dataInputStream, ClassFile classFile) throws IOException {
        int minor_version = dataInputStream.readUnsignedShort();
        int major_version = dataInputStream.readUnsignedShort();
        classFile.setMinor_version(minor_version);
        classFile.setMajor_version(major_version);
    }

    public void readConstantInfo(DataInputStream dataInputStream, ClassFile classFile) throws IOException {
        int constant_pool_count = dataInputStream.readUnsignedShort();
        classFile.setConstant_pool_count(constant_pool_count);
        classFile.constantInfoPool = new ConstantInfo[constant_pool_count];
        for (int i = 1; i < constant_pool_count; i++) {
            int tag = dataInputStream.readUnsignedByte();
            ConstantInfo info = null;
            switch (tag) {
                case ConstantInfo.TAG_ConstantUtf8Info:
                    info = new ConstantUtf8Info(dataInputStream);
                    break;
                case ConstantInfo.TAG_ConstantIntegerInfo:
                    info = new ConstantIntegerInfo(dataInputStream);
                    break;
                case ConstantInfo.TAG_ConstantFloatInfo:
                    info = new ConstantFloatInfo(dataInputStream);
                    break;
                case ConstantInfo.TAG_ConstantDoubleInfo:
                    info = new ConstantDoubleInfo(dataInputStream);
                    break;
                case ConstantInfo.TAG_ConstantLongInfo:
                    info = new ConstantLongInfo(dataInputStream);
                    break;
                case ConstantInfo.TAG_ConstantClassInfo:
                    info = new ConstantClassInfo(dataInputStream);
                    break;
                case ConstantInfo.TAG_ConstantStringInfo:
                    info = new ConstantStringInfo(dataInputStream);
                    break;
                case ConstantInfo.TAG_ConstantFieldrefInfo:
                    info = new ConstantFieldrefInfo(dataInputStream);
                    break;
                case ConstantInfo.TAG_ConstantMethodrefInfo:
                    info = new ConstantMethodrefInfo(dataInputStream);
                    break;
                case ConstantInfo.TAG_ConstantInterfaceMethodrefInfo:
                    info = new ConstantInterfaceMethodrefInfo(dataInputStream);
                    break;
                case ConstantInfo.TAG_ConstantNameAndTypeInfo:
                    info = new ConstantNameAndTypeInfo(dataInputStream);
                    break;
                case ConstantInfo.TAG_ConstantMethodHandleInfo:
                    info = new ConstantMethodHandleInfo(dataInputStream);
                    break;
                case ConstantInfo.TAG_ConstantMethodTypeInfo:
                    info = new ConstantMethodTypeInfo(dataInputStream);
                    break;
                case ConstantInfo.TAG_ConstantInvokeDynamicInfo:
                    info = new ConstantInvokeDynamicInfo(dataInputStream);
                    break;
                default:
                    throw new IOException("can't regnized tag " + tag);
            }
            classFile.constantInfoPool[i] = info;
        }
    }

    public void readAccessFlag(DataInputStream dataInputStream, ClassFile classFile) throws IOException {
        int access_flags = dataInputStream.readUnsignedShort();
        classFile.setAccess_flags(access_flags);
    }

    public void readThisClass(DataInputStream dataInputStream, ClassFile classFile) throws IOException {
        int this_class = dataInputStream.readUnsignedShort();
        classFile.setThis_class(this_class);
    }

    public void readSuperClass(DataInputStream dataInputStream, ClassFile classFile) throws IOException {
        int super_class = dataInputStream.readUnsignedShort();
        classFile.setSuper_class(super_class);
    }

    public void readInterfaces(DataInputStream dataInputStream, ClassFile classFile) throws IOException {
        int interfaces_count = dataInputStream.readUnsignedShort();
        classFile.setInterfaces_count(interfaces_count);
        if (interfaces_count > 0) {
            int[] interfaces = new int[interfaces_count];
            classFile.setInterfaces(interfaces);
            for (int i = 0; i < interfaces_count; i++) {
                interfaces[i] = dataInputStream.readUnsignedShort();
            }
        }
    }

    public void readFields(DataInputStream dataInputStream, ClassFile classFile) throws IOException {
        int field_count = dataInputStream.readUnsignedShort();
        classFile.setFields_count(field_count);
        if (field_count > 0) {
            FieldInfo[] fields = new FieldInfo[field_count];
            classFile.setFields(fields);
            for (int i = 0; i < field_count; i++) {
                fields[i] = new FieldInfo(dataInputStream, classFile);
            }
        }
    }

    public void readMethods(DataInputStream dataInputStream, ClassFile classFile) throws IOException {
        int method_count = dataInputStream.readUnsignedShort();
        classFile.setMethods_count(method_count);
        if (method_count > 0) {
            MethodInfo[] methods = new MethodInfo[method_count];
            classFile.setMethods( methods );
            for (int i = 0; i < method_count; i++) {
                methods[i] = new MethodInfo(dataInputStream, classFile);
            }
        }
    }

    public void readAttributes(DataInputStream dataInputStream, ClassFile classFile) throws IOException {
        int attributes_count= dataInputStream.readUnsignedShort();
        classFile.setAttributes_count(attributes_count);
        if (attributes_count > 0) {
            AttributeInfo[] attributeInfos = new  AttributeInfo[attributes_count];
            classFile.setAttributes(attributeInfos);
            for(int i=0; i<attributes_count; i++) {
                attributeInfos[i] = new AttributeInfo(dataInputStream, classFile);
            }
        }
    }

}
