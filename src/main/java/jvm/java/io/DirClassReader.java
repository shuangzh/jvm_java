package jvm.java.io;

import java.io.*;

/**
 * Created by admin on 2016/12/22.
 * @author  zhoushuang
 *
 *
 *
 *
 */
public class DirClassReader extends AbstractClassReader {

    public DirClassReader(String location) {
        super(location);
    }

    @Override
    protected byte[] readClass(String classname) throws IOException {
        String rpath = classname.replace('.', File.separatorChar);
        String path = this.location + File.separator + rpath + ".class";
        File f = new File(path);
        byte[] bytes = null;
        if (f.exists() && f.isFile()) {
            try {
                InputStream in = new FileInputStream(f);
                int len = in.available();
                bytes = new byte[len];
                in.read(bytes);
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
                bytes = null;
            }
        }
        return bytes;
    }
}
