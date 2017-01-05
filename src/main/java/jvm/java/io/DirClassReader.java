package jvm.java.io;

import java.io.*;

/**
 * Created by admin on 2016/12/22.
 *
 * @author zhoushuang
 */
public class DirClassReader extends AbstractClassReader {

    public DirClassReader(String location) {
        super(location);
    }

    public DirClassReader() {
        super();
    }

    @Override
    protected byte[] readClass(String classname) throws IOException {
        String rpath = classname.replace('/', File.separatorChar);
        String[] locations = this.location.split(",");
        byte[] bytes = null;
        for (String locat : locations) {
            String path = locat + File.separator + rpath + ".class";
            File f = new File(path);
            if (f.exists() && f.isFile()) {
                try {
                    InputStream in = new FileInputStream(f);
                    int len = in.available();
                    bytes = new byte[len];
                    in.read(bytes);
                    in.close();
                    break;
                } catch (IOException e) {
                    e.printStackTrace();
                    bytes = null;
                }
            }
        }
        return bytes;
    }


}
