package jvm.java.io;

import jvm.java.base.ByteArray;
import jvm.java.classfile.ClassFile;
import jvm.java.classfile.ClassFileParser;
import jvm.java.classfile.MethodInfo;
import jvm.java.classfile.constantpool.ConstantInfo;
import jvm.java.classfile.constantpool.ConstantUtf8Info;
import jvm.java.runtime.StackFrame;
import jvm.java.runtime.ThreadStack;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;

/**
 * Created by admin on 2016/12/22.
 */
public class ClassReaderTest {

    @Test
    public void testDirClassReader() throws IOException {
        String file = "target\\test\\TClass.class";
        File f=new File(file);
        String abstring = f.getAbsolutePath();
        System.out.println(abstring);

        FileOutputStream out=new FileOutputStream(abstring);
        String text="Hello World!";
        out.write(text.getBytes());
        out.close();

        DirClassReader dirClassReader = new DirClassReader(System.getProperty("user.dir"));
        byte[] bytes=dirClassReader.getClassBytes("target.test.TClass");
        Assert.assertNotNull(bytes);

        String rtest=new String(bytes);
        System.out.println(rtest);
        Assert.assertEquals(rtest,text);
    }

    @Test
    public void testDefaultClassParser() throws IOException {
        DirClassReader dirClassReader = new DirClassReader(System.getProperty("user.dir")+"\\target\\classes");
        byte[] bytes=dirClassReader.getClassBytes("jvm.java.main.JVMMain");
        ClassFileParser classFileParser = new ClassFileParser();

        ClassFile classFile = classFileParser.parse(bytes);


        System.out.println("Hello");

    }

    @Test
    public  void testStackFrame() throws IOException {

        DirClassReader dirClassReader = new DirClassReader(System.getProperty("user.dir")+"\\target\\test-classes");
        byte[] bytes=dirClassReader.getClassBytes("jvm.java.SimpleTest");
        ClassFileParser classFileParser = new ClassFileParser();
        ClassFile classFile = classFileParser.parse(bytes);

        ThreadStack threadStack = new ThreadStack();
        MethodInfo methodInfo = ClassReaderTest.getMainFunc(classFile);
        StackFrame stackFrame = new StackFrame(threadStack, methodInfo);
        stackFrame.loop();

        System.out.println("OK");
    }

    public static  MethodInfo getMainFunc(ClassFile classFile) {
        MethodInfo[] methodInfos = classFile.getMethods();
        for(MethodInfo methodInfo: methodInfos) {
            ConstantUtf8Info constantInfo = (ConstantUtf8Info)classFile.getConstantInfoPool()[methodInfo.getName_index()];
            if(constantInfo.getValue().equals("main"))
            {
                return methodInfo;
            }
        }
        return  null;
    }

    @Test
    public void testDataStream() throws IOException {
        byte[] bytes = new  byte[20];
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream(20);
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);

        long l1 = (long)0xF0F0F0F0 << 32 ;
        long l2 = (long)0xF0F0F0F0;

        l1=-1;

        dataOutputStream.writeLong( l1 );

        byte[] bout = byteArrayOutputStream.toByteArray();


        long lb1=(long)bout[0] << 56;
        long lb2= ((long)(bout[1] & 255) << 48);
        long lb3= ((long)(bout[2] & 255) << 40);
        long lb4=((long)(bout[3] & 255) << 32);
        long lb5= ((long)(bout[4] & 255) << 24);
        long lb6= ((bout[5] & 255) << 16);
        long lb7= ((bout[6] & 255) <<  8);
        long lb8 =  ((bout[7] & 255) <<  0);

        long lb = lb1+lb2 +lb3 + lb4 +lb5 +lb6 +lb7 +lb8;

//        return (((long)readBuffer[0] << 56) +
//                ((long)(readBuffer[1] & 255) << 48) +
//                ((long)(readBuffer[2] & 255) << 40) +
//                ((long)(readBuffer[3] & 255) << 32) +
//                ((long)(readBuffer[4] & 255) << 24) +
//                ((readBuffer[5] & 255) << 16) +
//                ((readBuffer[6] & 255) <<  8) +
//                ((readBuffer[7] & 255) <<  0));



        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bout);
        DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);

        long lout = dataInputStream.readLong();


    }

}
