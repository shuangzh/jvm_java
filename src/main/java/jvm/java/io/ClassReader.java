package jvm.java.io;

/**
 * Created by admin on 2016/12/22.
 */

public interface ClassReader {
    String getLocation();
    void  setLocation(String location);
    byte[] getClassBytes(String classname);

}
