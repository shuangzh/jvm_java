package jvm.java.io;

/**
 * Created by admin on 2016/12/22.
 */

public interface ClassReader {
    String getLocation();
    byte[] getClassBytes(String classname);

}
