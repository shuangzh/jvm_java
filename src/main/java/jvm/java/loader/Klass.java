package jvm.java.loader;

import jvm.java.base.SlotArray;
import jvm.java.classfile.constantpool.ConstantClassInfo;
import jvm.java.classfile.constantpool.ConstantFieldrefInfo;
import jvm.java.classfile.constantpool.ConstantInfo;
import jvm.java.classfile.constantpool.ConstantMethodrefInfo;

/**
 * Created by admin on 2017/1/3.
 */
public class Klass {

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

    public  boolean isArray() {
        if (name.startsWith("["))
            return  true;
        else
            return false;
    }

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


    public JMethod FindMethod(String name, String descriptor) {
        for (int i=0; i< this.methods.length; i++) {
            if (methods[i].getName().equals(name) && methods[i].getDescriptor().equals(descriptor))
                return  methods[i];
        }
        return null;
    }

    public JField FindField(String name, String descriptor) {
        for(int i=0; i < this.fields.length; i++) {
            if(fields[i].getName().equals(name) && fields[i].getDescriptor().equals(descriptor))
                return fields[i];
        }
        return  null;
    }


    public Klass castConstantClassInfo(int index) {
        ConstantClassInfo constantClassInfo = (ConstantClassInfo) constantpool[index];
        String classname = constantClassInfo.getClassName();
        Klass klass = this.loader.FindClass(classname);
        return klass;
    }

    public JMethod castConstantMethodRefInfo(int index) {
        ConstantMethodrefInfo methodrefInfo = (ConstantMethodrefInfo) constantpool[index];
//        String classname = methodrefInfo.getClassName();
        Klass klass = castConstantClassInfo(methodrefInfo.getClassInfoIndex());

        String name = methodrefInfo.getName();
        String descriptor = methodrefInfo.getDescriptor();
//        JClassLoader jClassLoader = currentStackFrame.getMethod().getClassObject().getLoader();
//        Klass tjclass = jClassLoader.FindClass(classname);
//        this.newMethod = tjclass.FindMethod(name, descriptor);
        return  klass.FindMethod(name, descriptor);
    }

    public JField  castConstantFieldRefInfo(int index) {
        ConstantFieldrefInfo constantFieldrefInfo = (ConstantFieldrefInfo) constantpool[index];
//        ConstantFieldrefInfo constantFieldrefInfo = (ConstantFieldrefInfo) stackFrame.getJclass().getConstantpool()[index];
        String name = constantFieldrefInfo.getName();
        String descriptor = constantFieldrefInfo.getDescriptor();
//        String classname = constantFieldrefInfo.getClassName();
        Klass klass= castConstantClassInfo(constantFieldrefInfo.getClassInfoIndex());
        return klass.FindField(name, descriptor);
    }

}
