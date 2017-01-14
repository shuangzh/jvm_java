package jvm.java.runtime;

import jvm.java.base.JArrayObject;
import jvm.java.base.Basic;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by admin on 2017/1/3.
 */

@Deprecated
public class RefHolder {
//    AtomicInteger atomicInteger = new AtomicInteger(100);
//    Map<Integer, Basic> refMap=new HashMap<Integer,Basic>();

//    public int saveNewObject(Basic obj) {
//        int i= 0;
//        for (;;) {
//            i=atomicInteger.getAndIncrement();
//            Object  o = refMap.get(i);
//            if (o !=null)
//                continue;
//           // obj.RefId(i);
//            obj.setRefValue(i);
//            refMap.put(i, obj);
//            break;
//        }
//        return i;
//    }
//
//    public  int saveNewArrayObject(JArrayObject obj) {
//        int i= 0;
//        for (;;) {
//            i=atomicInteger.getAndIncrement();
//            Object  o = refMap.get(i);
//            if (o !=null)
//                continue;
//            // obj.RefId(i);
//            obj.setArrayRefValue(i);
//            refMap.put(i, obj);
//            break;
//        }
//        return i;
//    }
//
//    public Basic fetchObject(int refvalue) {
//        return refMap.get(refvalue);
//    }
}
