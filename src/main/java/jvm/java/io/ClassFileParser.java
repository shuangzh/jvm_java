package jvm.java.io;

import com.sun.xml.internal.ws.util.ByteArrayDataSource;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

/**
 * Created by admin on 2016/12/25.
 */
public class ClassFileParser {
    public ClassFile parse(byte[] bytes) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
        return parse(dataInputStream);
    }

    public ClassFile parse(DataInputStream dataInputStream) {
        ClassFile classFile = new ClassFile();

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
                    info = null;
                    throw new IOException("can't regnized tag " + tag);
            }
            classFile.constantInfoPool[i] = info;
        }
    }



}
