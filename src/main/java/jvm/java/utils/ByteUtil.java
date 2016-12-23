package jvm.java.utils;

/**
 * Created by admin on 2016/12/23.
 */
public class ByteUtil {

    public static int byteToInt(byte b) {
        return b & 0xFF;
    }

    public static byte intToByte(int i) {
        return (byte) i;
    }

    public static int byteArrayToInt(byte[] b) {
        return b[3] & 0xFF |
                (b[2] & 0xFF) << 8 |
                (b[1] & 0xFF) << 16 |
                (b[0] & 0xFF) << 24;
    }

    public static byte[] intToByteArray(int i) {
        return new byte[]{
                (byte) ((i >> 24) & 0xFF),
                (byte) ((i >> 16) & 0xFF),
                (byte) ((i >> 8) & 0xFF),
                (byte) (i & 0xFF)
        };
    }

    public static short byteToShort(byte b) {
        return (short) (b & 0xFF);
    }

    public static byte shortToByte(short s) {
        return (byte) s;
    }

    public static short byteArrayToShort(byte[] b) {
        return (short) ((b[1] & 0xFF) | ((b[0] & 0xFF) << 8));
    }

    public static byte[] shortToByteArray(short s) {
        return new byte[]
                {
                        (byte) ((s >> 8) & 0xFF),
                        (byte) (s & 0xFF)
                };
    }

    public static int byteArrayToInt(byte[] bytes, int pos) {
        return  (bytes[pos+3] & 0xFF) |
                (bytes[pos+2] & 0xFF) << 8 |
                (bytes[pos+1] & 0xFF) << 16 |
                (bytes[pos+0] & 0xFF) << 24;
    }

    public static short byteArrayToShort(byte[] bytes, int pos) {
        return (short) ((bytes[pos+1] & 0xFF) | ((bytes[pos+0] & 0xFF) << 8));
    }


}
