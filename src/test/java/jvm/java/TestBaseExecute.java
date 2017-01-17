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


    public static void pushLoadStore1() {
        int i1 = 100;
        int i2 = 200;
        int i3 = -1;

        float f1 = 10.1f;
        float f2 = 0.1f;
        float f3 = -1.1f;


        short s1 = 2000;
        short s2 = -1;
        short s3 = -2560;

        byte b1 = 100;
        byte b2 = -1;
        byte b3 = -100;

        long l1 = 1000L;
        long l2 = -1L;
        long l3 = -199999L;

        double d1 = 100.1D;
        double d2 = -0.1D;
        double d3 = -9999999.101D;

        char c1 = 'A';
        char c2 = 'a';

    }

    public static void intMath() {
        int i1, i2, i3, i4, i5, i6, i7, i8;
        i1 = 10001;         //  10001
        i2 = 100 + i1;       //  10101
        i3 = i2 + i1;        //  20102
        i4 = -1000 - i3;    // -21102
        i5 = i1 + i2 - i3 - i4;       // 21102;
        i6 = i1 * i2 * i4;      // 10001*10101*-21102
        i7 = i4 / i1;           // -21102 / 10001
        i8 = i1 * i2 / i4;        //  10001*10101/-21102
    }

    public static void byteShortMath() {
        byte b1, b2, b3, b4, b5, b6;
        b1 = 10;                // 10
        b2 = (byte) (b1 - 1);    // 9
        b3 = (byte) (b1 + b2);  // 19
        b4 = (byte) (-1 - b3 - b2);  // -29
        b5 = (byte) (b4 * b3 / b2);   //  -29 * 19 / 9
        b6 = (byte) (256 * 8);

        short s1, s2, s3, s4, s5;
        s1 = (short) (b1 + 256);    // 10 + 256
        s2 = (short) (s1 - 200000); // 10 + 256 - 200000
        s3 = (short) (s1 * s2);       // (10 + 256)*(10 + 256 - 200000)
        s4 = (short) (s3 / s1);     //  (10 + 256)*(10 + 256 - 200000)/(10 + 256)
        s5 = (short) (s1 - 20000);  // 10 + 256 - 20000

        char c1, c2, c3, c4, c5;
        c1 = 'a';           // 97
        c2 = (char) (c1 + 1);   // 98
        c3 = (char) (c2 * 100); // 98 * 100
        c4 = (char) (c2 + 10 - c1 -100); // 98 + 10 - 97 -100
        c5 = (char) (c2*1000); // 98 * 1000

    }

    @Test
    public void testPushLoadStore1() {
        JClassLoader jClassLoader = new JClassLoader(System.getProperty("user.dir") + "\\target\\test-classes" + "," + System.getProperty("user.dir") + "\\libs\\rt");
        ThreadStack threadStack = new ThreadStack();
        Klass jClass = jClassLoader.FindClass("jvm/java/TestBaseExecute");
        JMethod jMethod = jClass.FindMethod("pushLoadStore1", "()V");
        StackFrame frame = new StackFrame(threadStack, jMethod);
        threadStack.pushFrame(frame);
        threadStack.start();

        LocalVarsTable localVarsTable = frame.getLocalVarsTable();
        // 检测 int
        Assert.assertEquals(100, localVarsTable.getInt(0));
        Assert.assertEquals(200, localVarsTable.getInt(1));
        Assert.assertEquals(-1, localVarsTable.getInt(2));

        // 检测 float
        Assert.assertEquals(10.1f, localVarsTable.getFloat(3), 0.001);
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
        Assert.assertEquals(-9999999.101D, localVarsTable.getDouble(22), 0.001);

        // 检测char
        Assert.assertEquals((int) 'A', localVarsTable.getInt(24));
        Assert.assertEquals((int) 'a', localVarsTable.getInt(25));
    }

    @Test
    public void testIntMath() {
        JClassLoader jClassLoader = new JClassLoader(System.getProperty("user.dir") + "\\target\\test-classes" + "," + System.getProperty("user.dir") + "\\libs\\rt");
        ThreadStack threadStack = new ThreadStack();
        Klass jClass = jClassLoader.FindClass("jvm/java/TestBaseExecute");
        JMethod jMethod = jClass.FindMethod("intMath", "()V");
        StackFrame frame = new StackFrame(threadStack, jMethod);
        threadStack.pushFrame(frame);
        threadStack.start();

        LocalVarsTable localVarsTable = frame.getLocalVarsTable();
        Assert.assertEquals(10001, localVarsTable.getInt(0));
        Assert.assertEquals(10101, localVarsTable.getInt(1));
        Assert.assertEquals(20102, localVarsTable.getInt(2));
        Assert.assertEquals(-21102, localVarsTable.getInt(3));
        Assert.assertEquals(21102, localVarsTable.getInt(4));

        Assert.assertEquals(10001 * 10101 * (-21102), localVarsTable.getInt(5));
        Assert.assertEquals(-21102 / 10001, localVarsTable.getInt(6));
        Assert.assertEquals(10001 * 10101 / (-21102), localVarsTable.getInt(7));

    }

    @Test
    public void testByteShortMath() {
        JClassLoader jClassLoader = new JClassLoader(System.getProperty("user.dir") + "\\target\\test-classes" + "," + System.getProperty("user.dir") + "\\libs\\rt");
        ThreadStack threadStack = new ThreadStack();
        Klass jClass = jClassLoader.FindClass("jvm/java/TestBaseExecute");
        JMethod jMethod = jClass.FindMethod("byteShortMath", "()V");
        StackFrame frame = new StackFrame(threadStack, jMethod);
        threadStack.pushFrame(frame);
        threadStack.start();

        LocalVarsTable localVarsTable = frame.getLocalVarsTable();

        Assert.assertEquals(10, localVarsTable.getInt(0));
        Assert.assertEquals(9, localVarsTable.getInt(1));
        Assert.assertEquals(19, localVarsTable.getInt(2));
        Assert.assertEquals(-29, localVarsTable.getInt(3));

        Assert.assertEquals(-29 * 19 / 9, localVarsTable.getInt(4));
        Assert.assertEquals((byte) (256 * 8), localVarsTable.getInt(5));


        Assert.assertEquals(10 + 256, localVarsTable.getInt(6));
        Assert.assertEquals((short) (10 + 256 - 200000), localVarsTable.getInt(7));
        Assert.assertEquals((short) ((10 + 256) * (10 + 256 - 200000)), localVarsTable.getInt(8));
        Assert.assertEquals((short) (((short) ((10 + 256) * (10 + 256 - 200000)) / (10 + 256))), localVarsTable.getInt(9));
        Assert.assertEquals((10 + 256 - 20000), localVarsTable.getInt(10));

        Assert.assertEquals(97, localVarsTable.getInt(11));
        Assert.assertEquals(98, localVarsTable.getInt(12));
        Assert.assertEquals(98 * 100, localVarsTable.getInt(13));
        Assert.assertEquals((char)(98 + 10 - 97 -100) ,localVarsTable.getInt(14));
        Assert.assertEquals((char)(98 * 1000), localVarsTable.getInt(15));

    }


}
