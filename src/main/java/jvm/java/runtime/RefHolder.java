package jvm.java.runtime;

import jvm.java.base.JObject;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by admin on 2017/1/3.
 */
public class RefHolder {
    AtomicInteger atomicInteger = new AtomicInteger();
    Map<Integer, JObject> refMap=new HashMap<Integer,JObject>();

    public int saveNewObject(JObject obj) {
        int i= 0;
        for (;;) {
            i=atomicInteger.getAndIncrement();
            Object  o = refMap.get(i);
            if (o !=null)
                continue;
           // obj.RefId(i);
            obj.setRefValue(i);
            refMap.put(i, obj);
            break;
        }
        return i;
    }

    public JObject fetchObject(int refvalue) {
        return refMap.get(refvalue);
    }
}
