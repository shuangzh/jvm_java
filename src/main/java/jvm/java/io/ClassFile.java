package jvm.java.io;

/**
 * Created by admin on 2016/12/23.
 */
public class ClassFile {
    int magic;                       // u4
    short minor_version;             // u2
    short major_version;             // u2
    short constant_pool_count;       // u2


    byte[] bytes;

    public  ClassFile(byte[] bytes) {
        this.bytes = bytes;
    }
}
