package jvm.java;

import jvm.java.loader.JClassLoader;
import jvm.java.loader.JMethod;
import jvm.java.loader.Klass;
import jvm.java.runtime.LocalVarsTable;
import jvm.java.runtime.StackFrame;
import jvm.java.runtime.ThreadStack;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by admin on 2017/1/16.
 */
public class TestBaseExecute {


    public static  void pushLoadStore1() {
        int i1=100;
        int i2=200;
        int i3=-1;

        float f1=10.1f;
        float f2 = 0.1f;
        float f3 = -1.1f;


        short s1=2000;
        short s2=-1;
        short s3=-2560;

        byte b1= 100;
        byte b2 = -1;
        byte b3 = -100;

        long l1= 1000L;
        long l2=-1L;
        long l3= -199999L;

        double d1 = 100.1D;
        double d2 = -0.1D;
        double d3 = -9999999.101D;

        char c1 = 'A';
        char c2 = 'a';

    }

    @Test
    public void testPushLoadStore1() {
        JClassLoader jClassLoader = new JClassLoader(System.getProperty("user.dir")+"\\target\\test-classes"+","+ System.getProperty("user.dir")+"\\libs\\rt");
        ThreadStack threadStack= new ThreadStack();
        Klass jClass = jClassLoader.FindClass("jvm/java/TestBaseExecute");
        JMethod jMethod= jClass.FindMethod("pushLoadStore1","()V");
        StackFrame frame = new StackFrame(threadStack, jMethod);
        threadStack.pushFrame(frame);
        threadStack.start();

        LocalVarsTable localVarsTable = frame.getLocalVarsTable();
        // 检测 int
        Assert.assertEquals(100, localVarsTable.getInt(0));
        Assert.assertEquals(200, localVarsTable.getInt(1));
        Assert.assertEquals(-1, localVarsTable.getInt(2));

        // 检测 float
        Assert.assertEquals(10.1f, localVarsTable.getFloat(3),0.001);
        Assert.assertEquals(0.1f, localVarsTable.getFloat(4), 0.001);
        Assert.assertEquals(-1.1f, localVarsTable.getFloat(5), 0.001);

        // 检测short
        Assert.assertEquals(2000, localVarsTable.getInt(6));
        Assert.assertEquals(-1, localVarsTable.getInt(7));
        Assert.assertEquals(-2560, localVarsTable.getInt(8));

        // 检测byte
        Assert.assertEquals(100, localVarsTable.getInt(9));
        Assert.assertEquals(-1, localVarsTable.getInt(10));
        Assert.assertEquals(-100, localVarsTable.getInt(11));

        // 检测long
        Assert.assertEquals(1000L, localVarsTable.getLong(12));
        Assert.assertEquals(-1L, localVarsTable.getLong(14));
        Assert.assertEquals(-199999L, localVarsTable.getLong(16));

        // 检测double
        Assert.assertEquals(100.1D, localVarsTable.getDouble(18), 0.0001);
        Assert.assertEquals(-0.1D, localVarsTable.getDouble(20), 0.00001);
        Assert.assertEquals(-9999999.101D,localVarsTable.getDouble(22), 0.001);

        // 检测char
        Assert.assertEquals((int)'A', localVarsTable.getInt(24));
        Assert.assertEquals((int)'a', localVarsTable.getInt(25));
    }


}
