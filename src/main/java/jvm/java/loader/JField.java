package jvm.java.loader;

import jvm.java.base.Const;
import jvm.java.classfile.ClassFile;
import jvm.java.classfile.FieldInfo;

/**
 * Created by admin on 2017/1/3.
 */
public class JField {

    int access_flag;
    String name;
    String descriptor;
    Klass classObject;

    int slotId;

    public int getSlotId() {
        return slotId;
    }

    public int getSlotSize() {
        if(descriptor.equals(Const.TYP_J) || descriptor.equals(Const.TYP_D))
            return  2;
        else
            return  1;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public JField(Klass classObject, ClassFile classFile, FieldInfo fieldInfo) {
        this.access_flag = fieldInfo.getAccess_flag();
        this.name = classFile.getConstantUtf8InfoValue(fieldInfo.getName_index());
        this.descriptor = classFile.getConstantUtf8InfoValue(fieldInfo.getDescriptor_index());
        this.classObject = classObject;
    }

    public boolean isStatic() {
        if ((access_flag & Const.ACC_STATIC) != 0) {
            return true;
        } else return false;
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

    public Klass getJClass() {
        return classObject;
    }

    public String getType() {
        return  this.descriptor.substring(0,1);
    }

}
