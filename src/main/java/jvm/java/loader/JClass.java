package jvm.java.loader;

import jvm.java.base.SlotArray;
import jvm.java.classfile.constantpool.ConstantInfo;

/**
 * Created by admin on 2017/1/3.
 */
public class JClass {

    int access_flag;
    String name;
    String superName;

    String[] interfaceNames;
    JField[] fields;
    JMethod[] methods;

    JClassLoader loader;

    ConstantInfo[] constantpool;

    int instanceSlotCount;
    int staticSlotCount;
    SlotArray  staticSlots;

    public int getInstanceSlotCount() {
        return instanceSlotCount;
    }

    public void setInstanceSlotCount(int instanceSlotCount) {
        this.instanceSlotCount = instanceSlotCount;
    }

    public int getStaticSlotCount() {
        return staticSlotCount;
    }

    public void setStaticSlotCount(int staticSlotCount) {
        this.staticSlotCount = staticSlotCount;
    }

    public SlotArray getStaticSlots() {
        return staticSlots;
    }

    public void setStaticSlots(SlotArray staticSlots) {
        this.staticSlots = staticSlots;
    }

    public ConstantInfo[] getConstantpool() {
        return constantpool;
    }

    public void setConstantpool(ConstantInfo[] constantpool) {
        this.constantpool = constantpool;
    }

    public int getAccess_flag() {
        return access_flag;
    }

    public void setAccess_flag(int access_flag) {
        this.access_flag = access_flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSuperName() {
        return superName;
    }

    public void setSuperName(String superName) {
        this.superName = superName;
    }

    public String[] getInterfaceNames() {
        return interfaceNames;
    }

    public void setInterfaceNames(String[] interfaceNames) {
        this.interfaceNames = interfaceNames;
    }

    public JField[] getFields() {
        return fields;
    }

    public void setFields(JField[] fields) {
        this.fields = fields;
    }

    public JMethod[] getMethods() {
        return methods;
    }

    public void setMethods(JMethod[] methods) {
        this.methods = methods;
    }

    public JClassLoader getLoader() {
        return loader;
    }

    public void setLoader(JClassLoader loader) {
        this.loader = loader;
    }

}
