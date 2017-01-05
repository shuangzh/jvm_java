package jvm.java.loader;

import jvm.java.base.SlotArray;
import jvm.java.classfile.ClassFile;
import jvm.java.classfile.ClassFileParser;
import jvm.java.classfile.FieldInfo;
import jvm.java.classfile.MethodInfo;
import jvm.java.classfile.constantpool.*;
import jvm.java.io.ClassReader;
import jvm.java.io.DirClassReader;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2017/1/3.
 */
public class JClassLoader {

    ClassReader classReader = new DirClassReader();
    ClassFileParser classFileParser = new ClassFileParser();

    Map<String, JClass> jClassMap = new HashMap<String, JClass>();

    public ClassFile obtainClassFile(String classname) throws IOException {
        return classFileParser.parse(classReader.getClassBytes(classname));
    }

    public synchronized void loadJClass(String classname) throws IOException {
        JClass jClass = this.exportJClass(obtainClassFile(classname));
        // 计算slotCount
        this.calSlotCount(jClass);

        // 运行类初始化方法


    }

    public void calSlotCount(JClass jClass) {
        int instCount = 0;
        int staticCount = 0;
        if (jClass.getSuperName() != "java/lang/Object") {
            JClass sp = this.FindClass(jClass.getSuperName());
            instCount = sp.getInstanceSlotCount();
        }

        for (JField jField : jClass.getFields()) {
            if (jField.isStatic()) {
                jField.setSlotId(staticCount);
                JType jType = jField.getJType();
                switch (jType) {
                    case J:
                        ;
                    case D:
                        staticCount = staticCount + 2;
                        break;
                    default:
                        staticCount = staticCount+1;
                        break;
                }
            } else {
                jField.setSlotId(instCount);
                JType jType = jField.getJType();
                switch (jType) {
                    case J:
                        ;
                    case D:
                        instCount = instCount + 2;
                        break;
                    default:
                        instCount = instCount + 1;
                }
            }
        }
        jClass.setInstanceSlotCount(instCount);
        jClass.setStaticSlotCount(staticCount);
        jClass.setStaticSlots(new SlotArray(staticCount));
    }

    public JClass FindClass(String classname) {
        return null;
    }

    ;


    public JClass exportJClass(ClassFile classFile) {
        JClass classObject = new JClass();
        classObject.setAccess_flag(classFile.getAccess_flags());
        classObject.setName(classFile.getThisClassName());
        classObject.setSuperName(classFile.getSuperClassName());

        // 设置fieldInfo
        FieldInfo[] fieldInfos = classFile.getFields();
        if (fieldInfos.length > 0) {
            JField[] fields = new JField[fieldInfos.length];
            for (int i = 0; i < fieldInfos.length; i++) {
                fields[i] = new JField(classObject, classFile, fieldInfos[i]);
            }
            classObject.setFields(fields);
        }

        // 设置 methodInfo
        MethodInfo[] methodInfos = classFile.getMethods();
        if (methodInfos.length > 0) {
            JMethod[] methods = new JMethod[methodInfos.length];
            for (int i = 0; i < methodInfos.length; i++) {
                methods[i] = new JMethod(classObject, classFile, methodInfos[i]);
            }
            classObject.setMethods(methods);
        }

        // 设置接口名
        int interface_count = classFile.getInterfaces_count();
        if (interface_count > 0) {
            String[] interfaces = new String[interface_count];
            for (int i = 0; i < interface_count; i++) {
                ConstantClassInfo constantClassInfo = (ConstantClassInfo) classFile.getConstantInfoPool()[classFile.getInterfaces()[i]];
                interfaces[i] = constantClassInfo.getClassName();
            }
            classObject.setInterfaceNames(interfaces);
        }
        classObject.setLoader(this);
        classObject.setConstantpool(classFile.getConstantInfoPool());

        return classObject;
    }

}
