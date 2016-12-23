package jvm.java.utils;

import org.junit.Assert;
import org.junit.Test;


/**
 * Created by admin on 2016/12/23.
 */
public class ByteUtilsTest {

    @Test
    public void testByteUtil() {
        int i = 0x00FA1234;
        byte b = ByteUtil.intToByte(i);
        Assert.assertEquals(b, (byte) 0x34);

        int p = ByteUtil.byteToInt(b);
        Assert.assertEquals(p, 0x34);

        byte[] bytes = new byte[]{
                (byte) 0x00,
                (byte) 0xFA,
                (byte) 0x12,
                (byte) 0x34
        };

        byte[] barray = ByteUtil.intToByteArray(i);
        Assert.assertArrayEquals(bytes, barray);

        int pi = ByteUtil.byteArrayToInt(barray);
        Assert.assertEquals(pi, i);

        short s = (short) 0x0F8F;
        b = ByteUtil.shortToByte(s);
        Assert.assertEquals(b, (byte) 0x0F8F);

        short ps = ByteUtil.byteToShort(b);
        Assert.assertEquals(ps, 0x8F);

        barray = ByteUtil.shortToByteArray(s);
        bytes = new byte[]
                {
                        (byte) 0x0F,
                        (byte) 0x8F
                };
        Assert.assertArrayEquals(barray, bytes);
        ps = ByteUtil.byteArrayToShort(barray);
        Assert.assertEquals(ps, s);
    }
}
