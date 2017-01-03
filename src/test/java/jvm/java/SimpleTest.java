package jvm.java;

/**
 * Created by admin on 2016/12/29.
 */
public class SimpleTest {

    public  static  int ii = 9999;
    public  static  float f = 1.99f;
    public  static  long  lv=  99L;


    public  static  int add10(int k, int j)
    {
        int r = k +10 +j;
        return  r;
    }

    public static void main(String[] args) {
        int i = 100;
        int j = 200;
        int k = 300;
        int r = i+j;
        r=r+k;

        r= r + add10(8, 16);


        System.out.println(r);
        Class c = SimpleTest.class;

    }
}
