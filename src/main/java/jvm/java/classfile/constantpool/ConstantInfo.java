package jvm.java.classfile.constantpool;

/**
 * Created by admin on 2016/12/23.
 */
public class ConstantInfo {

    public final static int TAG_ConstantUtf8Info    = 1;
    public final static int TAG_ConstantIntegerInfo = 3;
    public final static int TAG_ConstantFloatInfo   = 4;
    public final static int TAG_ConstantLongInfo    = 5;
    public final static int TAG_ConstantDoubleInfo  = 6;
    public final static int TAG_ConstantClassInfo   = 7;
    public final static int TAG_ConstantStringInfo  = 8;
    public final static int TAG_ConstantFieldrefInfo= 9;
    public final static int TAG_ConstantMethodrefInfo = 10;
    public final static int TAG_ConstantInterfaceMethodrefInfo = 11;
    public final static int TAG_ConstantNameAndTypeInfo = 12;
    public final static int TAG_ConstantMethodHandleInfo = 15;
    public final static int TAG_ConstantMethodTypeInfo = 16;
    public final static int TAG_ConstantInvokeDynamicInfo = 18;

    int tag;        // u1

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }
}
