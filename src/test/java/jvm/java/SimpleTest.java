package jvm.java;

/**
 * Created by admin on 2016/12/29.
 */
public class SimpleTest {

    public  static  int ii = 9999;
    public  static  float f = 1.99f;

    public static void main(String[] args) {
        int i = 100;
        int j = 200;
        int k = 300;
        int r = i+j;
        r=r+k;
        r= r + ii;
        System.out.println(r);

        Class c = SimpleTest.class;

    }
}
