package jvm.java.loader;

import jvm.java.classfile.ClassFile;
import jvm.java.classfile.FieldInfo;
import jvm.java.classfile.MethodInfo;
import jvm.java.classfile.constantpool.ConstantClassInfo;

/**
 * Created by admin on 2017/1/3.
 */
public class ClassObjectLoader {

    public ClassObject defineClassObject(ClassFile classFile) {
        ClassObject classObject=new ClassObject();
        classObject.setAccess_flag(classFile.getAccess_flags());
        classObject.setName(classFile.getThisClassName());
        classObject.setSuperName(classFile.getSuperClassName());

        FieldInfo[] fieldInfos = classFile.getFields();
        if(fieldInfos.length > 0)
        {
            Field[] fields=new Field[fieldInfos.length];
            for(int i=0; i< fieldInfos.length ; i++) {
                fields[i]=new Field(classObject, classFile, fieldInfos[i]);
            }
            classObject.setFields(fields);
        }

        MethodInfo[] methodInfos = classFile.getMethods();
        if(methodInfos.length > 0)
        {
            Method[] methods = new Method[methodInfos.length];
            for (int i=0; i< methodInfos.length; i++) {
                methods[i]=new Method(classObject, classFile, methodInfos[i]);
            }
            classObject.setMethods(methods);
        }

        int interface_count=classFile.getInterfaces_count();
        if(interface_count > 0)
        {
            String[] interfaces=new String[interface_count];
            for(int i=0; i< interface_count; i++){
                ConstantClassInfo constantClassInfo= (ConstantClassInfo) classFile.getConstantInfoPool()[classFile.getInterfaces()[i]];
                interfaces[i] =constantClassInfo.getClassName();
            }
            classObject.setInterfaceNames(interfaces);
        }

        classObject.setLoader(this);



        return  classObject;
    }

}
