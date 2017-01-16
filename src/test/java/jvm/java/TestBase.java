package jvm.java;

import jvm.java.base.ByteArray;
import jvm.java.base.ByteArrayStack;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by admin on 2017/1/12.
 */
public class TestBase {

    /**
     * 测试 ByteArray 的正确性
     */
    @Test
    public void testByteArray() {
        ByteArray byteArray = new ByteArray(10);
        Assert.assertEquals(10, byteArray.size());


        // 测试  int 数据类型
        int intValue = 23456;
        byteArray.setInt(0, intValue);
        int retIntValue = byteArray.getInt(0);
        Assert.assertEquals(intValue, retIntValue);

        intValue = -1999990;
        byteArray.setInt(byteArray.size() - 4, intValue);
        retIntValue = byteArray.getInt(byteArray.size() - 4);
        Assert.assertEquals(intValue, retIntValue);


        // 测试 long 数据类型
        long longValue = 123456789L;
        byteArray.setLong(2, longValue);
        long retLongValue = byteArray.getLong(2);
        Assert.assertEquals(longValue, retLongValue);

        longValue = -123456789L;
        byteArray.setLong(0, longValue);
        retLongValue = byteArray.getLong(0);
        Assert.assertEquals(longValue, retLongValue);

        // 测试 float 类型数据
        float floatValue = 1.88998f;
        byteArray.setFloat(5, floatValue);
        float retFloatValue = byteArray.getFloat(5);
        Assert.assertEquals(floatValue, retFloatValue, 0.00001);

        floatValue = -9876.321f;
        byteArray.setFloat(5, floatValue);
        retFloatValue = byteArray.getFloat(5);
        Assert.assertEquals(floatValue, retFloatValue, 0.001);


        // 测试 double 类型
        double doubleValue;
        double retDoubleValue;

        doubleValue = 1234567890.0999d;
        byteArray.setDouble(0, doubleValue);
        retDoubleValue = byteArray.getDouble(0);
        Assert.assertEquals(doubleValue, retDoubleValue, 0.0001);

        doubleValue = -1234567890.0999d;
        byteArray.setDouble(2, doubleValue);
        retDoubleValue = byteArray.getDouble(2);
        Assert.assertEquals(doubleValue, retDoubleValue, 0.0001);

        // 测试 byte 类型
        byte byteValue;
        byte retByteValue;

        byteValue = 120;
        byteArray.setByte(0, byteValue);
        retByteValue = byteArray.getByte(0);
        Assert.assertEquals(byteValue, retByteValue);

        byteValue = -120;
        byteArray.setByte(9, byteValue);
        retByteValue = byteArray.getByte(9);
        Assert.assertEquals(byteValue, retByteValue);

        byteValue = (byte) 0xFF;
        byteArray.setByte(0, byteValue);
        retByteValue = byteArray.getByte(0);
        Assert.assertEquals(byteValue, retByteValue);
        Assert.assertEquals(retByteValue, -1);
        Assert.assertEquals(0xFF, byteArray.getUnsignedByte(0));

        byteValue = (byte) -1;
        byteArray.setByte(0, byteValue);
        retByteValue = byteArray.getByte(0);
        Assert.assertEquals(byteValue, retByteValue);
        Assert.assertEquals(retByteValue, -1);
        Assert.assertNotEquals(-1, byteArray.getUnsignedByte(0));
        Assert.assertEquals(255, byteArray.getUnsignedByte(0));

        byteValue = (byte) -100;
        byteArray.setByte(0, byteValue);
        retByteValue = byteArray.getByte(0);
        Assert.assertEquals(byteValue, retByteValue);
        Assert.assertEquals(retByteValue, -100);
        Assert.assertNotEquals(-1, byteArray.getUnsignedByte(0));

        byteValue = (byte) 0xFA;
        byteArray.setByte(0, byteValue);
        retByteValue = byteArray.getByte(0);
        Assert.assertEquals(byteValue, retByteValue);
        Assert.assertEquals(0xFA, byteArray.getUnsignedByte(0));


        // 测试 short 类型
        short shortValue;
        short retShortValue;

        shortValue = 255;
        byteArray.setShort(2, shortValue);
        retShortValue = byteArray.getShort(2);
        Assert.assertEquals(shortValue, retShortValue);

        shortValue = -255;
        byteArray.setShort(2, shortValue);
        retShortValue = byteArray.getShort(2);
        Assert.assertEquals(shortValue, retShortValue);

        shortValue = (short) 0xFFFF;
        byteArray.setShort(2, shortValue);
        retShortValue = byteArray.getShort(2);
        Assert.assertEquals(shortValue, retShortValue);
        Assert.assertEquals(-1, retShortValue);

        Assert.assertEquals(0xFFFF, byteArray.getUnsignedShort(2));
        Assert.assertNotEquals(0xFFFF, retShortValue);

    }

    /**
     * 测试 ByteArrayStack
     */
    @Test
    public void testByteArrayStack() {
        ByteArrayStack stack = new ByteArrayStack(24);

        Assert.assertEquals(stack.capacity(), 24);
        Assert.assertEquals(stack.available(), 24);


        // 测试 byte 类型
        stack.pushByte(100);
        stack.pushByte(101);
        Assert.assertEquals(stack.available(), 22);
        Assert.assertEquals(stack.getPos(), 2);
        Assert.assertEquals(stack.popByte(), 101);
        Assert.assertEquals(stack.popByte(), 100);
        Assert.assertEquals(stack.available(), 24);
        Assert.assertEquals(stack.getPos(), 0);

        byte b = (byte) 0xFFFA;
        stack.pushByte(b);
        byte rb = (byte) stack.peekByte();
        Assert.assertNotEquals(b, stack.peekByte());
        Assert.assertEquals(stack.getPos(), 1);
        Assert.assertEquals(b, rb);

        Assert.assertEquals(0x00FA, stack.popByte());
        Assert.assertEquals(stack.getPos(), 0);

        stack.pushByte(-100);
        Assert.assertEquals(-100, (byte) stack.popByte());
        Assert.assertEquals(stack.getPos(), 0);

        // 测试short类型
        stack.pushShort(2345);
        stack.pushShort(9988);
        Assert.assertEquals(stack.available(), 20);
        Assert.assertEquals(stack.getPos(), 4);

        Assert.assertEquals(9988, stack.popShort());
        Assert.assertEquals(2345, stack.popShort());

        Assert.assertEquals(stack.available(), 24);
        Assert.assertEquals(stack.getPos(), 0);

        stack.pushShort(-321);
        Assert.assertNotEquals(-321, stack.peekShort());
        Assert.assertEquals(-321, (short) stack.peekShort());
        Assert.assertEquals(stack.getPos(), 2);
        Assert.assertEquals(-321, (short) stack.popShort());
        Assert.assertEquals(stack.getPos(), 0);

        // 测试 int 类型
        stack.pushInt(1);
        stack.pushInt(2);
        stack.pushInt(3);

        Assert.assertEquals(stack.available(), 12);
        Assert.assertEquals(stack.getPos(), 12);

        Assert.assertEquals(3, stack.peekInt());
        Assert.assertEquals(3, stack.popInt());
        Assert.assertEquals(stack.available(), 16);
        Assert.assertEquals(stack.getPos(), 8);

        Assert.assertEquals(2, stack.peekInt());
        Assert.assertEquals(2, stack.popInt());
        Assert.assertEquals(stack.available(), 20);
        Assert.assertEquals(stack.getPos(), 4);

        Assert.assertEquals(1, stack.peekInt());
        Assert.assertEquals(1, stack.popInt());
        Assert.assertEquals(stack.available(), 24);
        Assert.assertEquals(stack.getPos(), 0);

        stack.pushInt(-1);
        stack.pushInt(-2);
        stack.pushInt(-3);

        Assert.assertEquals(stack.available(), 12);
        Assert.assertEquals(stack.getPos(), 12);

        Assert.assertEquals(-3, stack.peekInt());
        Assert.assertEquals(-3, stack.popInt());
        Assert.assertEquals(stack.available(), 16);
        Assert.assertEquals(stack.getPos(), 8);

        Assert.assertEquals(-2, stack.peekInt());
        Assert.assertEquals(-2, stack.popInt());
        Assert.assertEquals(stack.available(), 20);
        Assert.assertEquals(stack.getPos(), 4);

        Assert.assertEquals(-1, stack.peekInt());
        Assert.assertEquals(-1, stack.popInt());
        Assert.assertEquals(stack.available(), 24);
        Assert.assertEquals(stack.getPos(), 0);

        // 测试 float 类型
        stack.pushLong(100001l);
        stack.pushLong(100002l);
        stack.pushLong(100003l);

        Assert.assertEquals(stack.available(), 0);
        Assert.assertEquals(stack.getPos(), 24);

        Assert.assertEquals(100003l, stack.peekLong());
        Assert.assertEquals(100003l, stack.popLong());
        Assert.assertEquals(stack.available(), 8);
        Assert.assertEquals(stack.getPos(), 16);

        Assert.assertEquals(100002l, stack.peekLong());
        Assert.assertEquals(100002l, stack.popLong());
        Assert.assertEquals(stack.available(), 16);
        Assert.assertEquals(stack.getPos(), 8);

        Assert.assertEquals(100001l, stack.peekLong());
        Assert.assertEquals(100001l, stack.popLong());
        Assert.assertEquals(stack.available(), 24);
        Assert.assertEquals(stack.getPos(), 0);

        stack.pushLong(-100001l);
        stack.pushLong(-100002l);
        stack.pushLong(-100003l);

        Assert.assertEquals(stack.available(), 0);
        Assert.assertEquals(stack.getPos(), 24);

        Assert.assertEquals(-100003l, stack.peekLong());
        Assert.assertEquals(-100003l, stack.popLong());
        Assert.assertEquals(stack.available(), 8);
        Assert.assertEquals(stack.getPos(), 16);

        Assert.assertEquals(-100002l, stack.peekLong());
        Assert.assertEquals(-100002l, stack.popLong());
        Assert.assertEquals(stack.available(), 16);
        Assert.assertEquals(stack.getPos(), 8);

        Assert.assertEquals(-100001l, stack.peekLong());
        Assert.assertEquals(-100001l, stack.popLong());
        Assert.assertEquals(stack.available(), 24);
        Assert.assertEquals(stack.getPos(), 0);

        // 测试 float 类型
        stack.pushFloat(10.0001f);
        stack.pushFloat(10.0002f);
        stack.pushFloat(10.0003f);

        Assert.assertEquals(stack.available(), 12);
        Assert.assertEquals(stack.getPos(), 12);
        Assert.assertEquals(10.0003f, stack.peekFloat(), 0.0001);
        Assert.assertEquals(10.0003f, stack.popFloat(), 0.0001);

        Assert.assertEquals(stack.available(), 16);
        Assert.assertEquals(stack.getPos(), 8);
        Assert.assertEquals(10.0002f, stack.peekFloat(), 0.0001);
        Assert.assertEquals(10.0002f, stack.popFloat(), 0.0001);

        Assert.assertEquals(stack.available(), 20);
        Assert.assertEquals(stack.getPos(), 4);
        Assert.assertEquals(10.0001f, stack.peekFloat(), 0.0001);
        Assert.assertEquals(10.0001f, stack.popFloat(), 0.0001);

        Assert.assertEquals(stack.available(), 24);
        Assert.assertEquals(stack.getPos(), 0);

        stack.pushFloat(-10.0001f);
        stack.pushFloat(-10.0002f);
        stack.pushFloat(-10.0003f);

        Assert.assertEquals(stack.available(), 12);
        Assert.assertEquals(stack.getPos(), 12);
        Assert.assertEquals(-10.0003f, stack.peekFloat(), 0.0001);
        Assert.assertEquals(-10.0003f, stack.popFloat(), 0.0001);

        Assert.assertEquals(stack.available(), 16);
        Assert.assertEquals(stack.getPos(), 8);
        Assert.assertEquals(-10.0002f, stack.peekFloat(), 0.0001);
        Assert.assertEquals(-10.0002f, stack.popFloat(), 0.0001);

        Assert.assertEquals(stack.available(), 20);
        Assert.assertEquals(stack.getPos(), 4);
        Assert.assertEquals(-10.0001f, stack.peekFloat(), 0.0001);
        Assert.assertEquals(-10.0001f, stack.popFloat(), 0.0001);

        Assert.assertEquals(stack.available(), 24);
        Assert.assertEquals(stack.getPos(), 0);


        // 测试double类型
        stack.pushDouble(-20.0001d);
        stack.pushDouble(-20.0002d);
        stack.pushDouble(-20.0003d);

        Assert.assertEquals(stack.available(), 0);
        Assert.assertEquals(stack.getPos(), 24);
        Assert.assertEquals(-20.0003f, stack.peekDouble(), 0.0001);
        Assert.assertEquals(-20.0003f, stack.popDouble(), 0.0001);

        Assert.assertEquals(stack.available(), 8);
        Assert.assertEquals(stack.getPos(), 16);

        Assert.assertEquals(-20.0002f, stack.peekDouble(), 0.0001);
        Assert.assertEquals(-20.0002f, stack.popDouble(), 0.0001);

        Assert.assertEquals(stack.available(), 16);
        Assert.assertEquals(stack.getPos(), 8);
        Assert.assertEquals(-20.0001f, stack.peekDouble(), 0.0001);
        Assert.assertEquals(-20.0001f, stack.popDouble(), 0.0001);

        Assert.assertEquals(stack.available(), 24);
        Assert.assertEquals(stack.getPos(), 0);

        // 测试double
        stack.pushDouble(20.0001d);
        stack.pushDouble(20.0002d);
        stack.pushDouble(20.0003d);

        Assert.assertEquals(stack.available(), 0);
        Assert.assertEquals(stack.getPos(), 24);
        Assert.assertEquals(20.0003f, stack.peekDouble(), 0.0001);
        Assert.assertEquals(20.0003f, stack.popDouble(), 0.0001);

        Assert.assertEquals(stack.available(), 8);
        Assert.assertEquals(stack.getPos(), 16);

        Assert.assertEquals(20.0002f, stack.peekDouble(), 0.0001);
        Assert.assertEquals(20.0002f, stack.popDouble(), 0.0001);

        Assert.assertEquals(stack.available(), 16);
        Assert.assertEquals(stack.getPos(), 8);
        Assert.assertEquals(20.0001f, stack.peekDouble(), 0.0001);
        Assert.assertEquals(20.0001f, stack.popDouble(), 0.0001);

        Assert.assertEquals(stack.available(), 24);
        Assert.assertEquals(stack.getPos(), 0);


        // 测试 empty, setpos
        stack.pushInt(2);
        stack.pushByte(3);
        Assert.assertEquals(stack.getPos(), 5);

        stack.empty();
        Assert.assertEquals(stack.getPos(), 0);
        Assert.assertEquals(stack.capacity(), 24);
        Assert.assertEquals(stack.available(), 24);

        stack.pushInt(201);
        stack.pushInt(301);
        stack.pushInt(401);
        stack.setPos(stack.getPos() - 4);
        Assert.assertEquals(stack.getPos(), 8);
        Assert.assertEquals(301, stack.peekInt());
        Assert.assertEquals(301, stack.popInt());
        Assert.assertEquals(201, stack.popInt());

        // 混合测试
        stack.pushInt(99099);
        stack.pushByte(10);
        stack.pushByte(-10);
        stack.pushFloat(50.55f);
        stack.pushLong(200000l);
        stack.pushInt(300);

        Assert.assertEquals(300, stack.popInt());
        Assert.assertEquals(200000l, stack.popLong());
        Assert.assertEquals(50.55f, stack.popFloat(), 0.01);
        Assert.assertEquals(-10, (byte) stack.popByte());
        Assert.assertEquals(10, (byte) stack.popByte());
        Assert.assertEquals(99099, stack.popInt());
        Assert.assertEquals(stack.getPos(), 0);

        stack.pushDouble(-1.0001d);
        stack.pushInt(888);
        stack.pushInt(200);

        Assert.assertEquals(200, stack.popInt());
        Assert.assertEquals(888, stack.popInt());
        Assert.assertEquals(8, stack.getPos());
        Assert.assertEquals(-1.0001d, stack.popDouble(), 0.0001);

    }

}
