package jvm.java.classfile.constantpool;

import jvm.java.classfile.ClassFile;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Created by admin on 2016/12/26.
 */
public class ConstantFieldrefInfo extends ConstantInfo {
    int classInfoIndex;     // u2
    int nameAndTypeIndex;   // u2

    public ConstantFieldrefInfo(DataInputStream dataInputStream) throws IOException {
        this.setTag(TAG_ConstantFieldrefInfo);
        this.classInfoIndex = dataInputStream.readUnsignedShort();
        this.nameAndTypeIndex = dataInputStream.readUnsignedShort();
    }

    public int getClassInfoIndex() {
        return classInfoIndex;
    }

    public int getNameAndTypeIndex() {
        return nameAndTypeIndex;
    }

    public String getClassName() {
        ConstantClassInfo constantClassInfo= (ConstantClassInfo) classFile.getConstantInfoPool()[classInfoIndex];
        return  constantClassInfo.getClassName();
    }

    public String getName(){
        ConstantNameAndTypeInfo constantNameAndTypeInfo = (ConstantNameAndTypeInfo) classFile.getConstantInfoPool()[nameAndTypeIndex];
        return  constantNameAndTypeInfo.getName();
    }

    public String getDescriptor(){
        ConstantNameAndTypeInfo constantNameAndTypeInfo = (ConstantNameAndTypeInfo) classFile.getConstantInfoPool()[nameAndTypeIndex];
        return  constantNameAndTypeInfo.getDescriptor();
    }

}
