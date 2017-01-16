package jvm.java.nativemethod;

import java.lang.reflect.Method;

/**
 * Created by admin on 2017/1/16.
 */
public class NativeRegister {

    public static  void register(String classname, String name, String descriptor, Method nativeMethod) {
        //TODO 添加注册本地方法的功能
    }

    public static  Method find(String classname, String name, String descriptor){
        return  null;
    }

}
