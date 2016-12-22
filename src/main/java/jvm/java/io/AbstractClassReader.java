package jvm.java.io;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2016/12/22.
 */
public abstract class AbstractClassReader  implements ClassReader{

    Map<String , byte[]> cache=new HashMap<String, byte[]>();
    String location;

    public AbstractClassReader(String location) {
        this.location = location;
    }

    public byte[] getClassBytes(String classname){
        byte[]  bytes=null;
        bytes = cache.get(classname);
        if (bytes != null)
            return bytes;

        try {
            bytes = this.readClass(classname);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(bytes != null)
            cache.put(classname, bytes);
        return bytes;
    }

    protected  abstract  byte[] readClass(String classname) throws IOException;

    public String getLocation() {
        return  location;
    }
}
