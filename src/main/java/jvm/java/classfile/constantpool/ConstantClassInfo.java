package jvm.java.classfile.constantpool;

import jvm.java.loader.ClassObject;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Created by admin on 2016/12/26.
 */
public class ConstantClassInfo extends ConstantInfo {
    final int name_index;    // u2

    // 目标class对象
    ClassObject targetClassObject;

    public ConstantClassInfo(DataInputStream dataInputStream) throws IOException {
        this.setTag(ConstantInfo.TAG_ConstantClassInfo);
        this.name_index = dataInputStream.readUnsignedShort();
    }

    public int getName_index() {
        return name_index;
    }

    public String getClassName() {
        return  this.classFile.getConstantUtf8InfoValue(this.name_index);
    }



    public ClassObject getTargetClassObject() {
        return targetClassObject;
    }

    public void setTargetClassObject(ClassObject targetClassObject) {
        this.targetClassObject = targetClassObject;
    }
}
