package jvm.java.loader;

/**
 * Created by admin on 2017/1/3.
 */
public class ClassObject{

    int access_flag;
    String name;
    String superName;

    String[] interfaceNames;
    Field[] fields;
    Method[] methods;

    ClassObjectLoader loader;

    ConstantPool constantpool;

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

    public Field[] getFields() {
        return fields;
    }

    public void setFields(Field[] fields) {
        this.fields = fields;
    }

    public Method[] getMethods() {
        return methods;
    }

    public void setMethods(Method[] methods) {
        this.methods = methods;
    }

    public ClassObjectLoader getLoader() {
        return loader;
    }

    public void setLoader(ClassObjectLoader loader) {
        this.loader = loader;
    }

    public ConstantPool getConstantpool() {
        return constantpool;
    }

    public void setConstantpool(ConstantPool constantpool) {
        this.constantpool = constantpool;
    }
}
