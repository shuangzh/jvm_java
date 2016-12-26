package jvm.java.io;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

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
//        ClassFile classFile = new ClassFile(bytese);
//        DefaultClassParser defaultClassParser = new DefaultClassParser();
//        defaultClassParser.parse(classFile);
        ClassFileParser classFileParser = new ClassFileParser();

        ClassFile classFile = classFileParser.parse(bytes);


        System.out.println("Hello");

    }

}
