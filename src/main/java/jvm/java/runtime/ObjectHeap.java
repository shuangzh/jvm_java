package jvm.java.runtime;

import jvm.java.array.*;
import jvm.java.base.*;
import jvm.java.loader.Klass;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by admin on 2017/1/11.
 */
public class ObjectHeap {

    private static final RefHolder refHolder = new RefHolder();

    private static final AtomicInteger sequence = new AtomicInteger(100);

    private static int generateID() {
        return  sequence.getAndIncrement();
    }

    public static Basic newObject(Klass jClass) {
        Basic jObject = new Basic();
        jObject.setClassname(jClass.getName());
        jObject.setjClass(jClass);
        jObject.setTyp(Const.TYP_L);
        jObject.setSlotArray(new SlotArray(jClass.getInstanceSlotCount()));
        refHolder.saveNewObject(jObject);
        return jObject;
    }

    public static Basic fetchObject(int refValue) {
        return refHolder.fetchObject(refValue);
    }

    public static JArrayObject newBaseArray(Klass ajclass, int len) {
        String etype = ajclass.getName().substring(1);
        JArrayObject jArrayObject = new JArrayObject();
//        jArrayObject.setClassname(ajclass.getName());
//        jArrayObject.setjClass(ajclass);
        jArrayObject.setEtype(etype);
        if (etype.equals(Const.TYP_D) || etype.equals(Const.TYP_J)) {
            SlotArray slotArray = new SlotArray(len * 2);
//            jArrayObject.setSlotArray(slotArray);
//        } else {
//            SlotArray slotArray = new SlotArray(len);
//            jArrayObject.setSlotArray(slotArray);
        }
        refHolder.saveNewArrayObject(jArrayObject);
        return jArrayObject;
    }

    public static JArrayObject newMutiArray(Klass ajclass, int[] dims) {
        JArrayObject jArrayObject = null;
        if (dims.length == 1) {
            return newBaseArray(ajclass, dims[0]);
        } else {
            int len = dims[0];
            int[] subdims = new int[dims.length - 1];
            System.arraycopy(dims, 1, subdims, 0, dims.length - 1);
            jArrayObject = newBaseArray(ajclass, len);
            try {
                Klass subjclass = ajclass.getLoader().FindClass(ajclass.getName().substring(1));
                for (int i = 0; i < len; i++) {
                    JArrayObject subArrayObject = newMutiArray(subjclass, subdims);
                    jArrayObject.setAInt(i, subArrayObject.getArrayRefValue());
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return jArrayObject;
    }


    public static KlassObject newKlassObject(Klass klass) {
        return new KlassObject(generateID(), klass);
    }

    public static ArrayObject newArrayObject(Klass klass, int len){
        String type = klass.getName().substring(1,2);
        if(type.equals(Const.TYP_I))
            return new IntArrayObject(generateID(), klass, len);
        else if (type.equals(Const.TYP_B))
            return new ByteArrayObject(generateID(), klass, len);
        else if (type.equals(Const.TYP_S))
            return new ShortArrayObject(generateID(),klass, len);
        else if (type.equals(Const.TYP_L))
            return new LongArrayObject(generateID(), klass, len);
        else if (type.equals(Const.TYP_F))
            return new FloatArrayObject(generateID(), klass, len);
        else if (type.equals(Const.TYP_D))
            return new DoubleArrayObject(generateID(), klass,len);
        else
            return new ReferenceArrayObject(generateID(), klass, len);
    };

    public static ArrayObject multiArrayObject(Klass klass, int[] dims)
    {
        if(dims.length == 1)
            return newArrayObject(klass, dims[0]);
        

    }
}
