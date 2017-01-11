package jvm.java;

import jvm.java.loader.JClass;
import jvm.java.loader.JClassLoader;
import jvm.java.loader.JMethod;
import jvm.java.runtime.StackFrame;
import jvm.java.runtime.ThreadStack;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by admin on 2017/1/11.
 */

public class SimTest {

    @Test
    public  void testInvoke() throws IOException {
        JClassLoader jClassLoader = new JClassLoader(System.getProperty("user.dir")+"\\target\\test-classes"+","+ System.getProperty("user.dir")+"\\libs\\rt");
        ThreadStack threadStack= new ThreadStack();

        JClass jClass = jClassLoader.FindClass("jvm/java/SMain");
        JMethod jMethod= jClass.FindMethod("main","([Ljava/lang/String;)V");
        StackFrame frame = new StackFrame(threadStack, jMethod);
//        frame.setVmContext(vmContext);

        threadStack.pushFrame(frame);
        threadStack.start();

    }
}
