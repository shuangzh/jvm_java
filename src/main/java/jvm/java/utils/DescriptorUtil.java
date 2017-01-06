package jvm.java.utils;

/**
 * Created by admin on 2017/1/6.
 */
public class DescriptorUtil {
    public static String[] split(String descriptor) {
        StringBuilder sb = new StringBuilder();
        char c;
        boolean isL = false;
        for (int i = 0; i < descriptor.length(); i++) {
            c = descriptor.charAt(i);
            if (c == '(' || c == ')')
                continue;
            if (c == ';') {
                sb.append(",");
                isL = false;
                continue;
            }
            if (c == 'L')
                isL = true;
            if (c == '[') {
                sb.append(c);
                continue;
            }
            if (isL == false) {
                sb.append(c);
                sb.append(",");
                continue;
            }
            sb.append(c);
        }
        return sb.substring(0, sb.length()).split(",");
    }
}
