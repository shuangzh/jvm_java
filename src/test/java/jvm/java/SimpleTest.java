package jvm.java;

/**
 * Created by admin on 2016/12/29.
 */
public class SimpleTest extends Object {

    public  static  int add10(int k, int j)
    {
        int r = k +10 +j;
        return  r;
    }

    public static void main(String[] args) {
        int i = 100;
        int r = i + 8;
        r= r + add10(8, 16);
    }
}
