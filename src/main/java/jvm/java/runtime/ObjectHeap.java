package jvm.java.runtime;

import jvm.java.array.*;
import jvm.java.base.*;
import jvm.java.loader.Klass;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by admin on 2017/1/11.
 */
public class ObjectHeap {

    private static final RefHolder refHolder = new RefHolder();

    private static final AtomicInteger sequence = new AtomicInteger(100);
    private static final HashMap<Integer, Object> heapmap=new HashMap<Integer, Object>();

    private static int generateID() {
        return  sequence.getAndIncrement();
    }

//    @Deprecated
//    public static Basic newObject(Klass jClass) {
//        Basic jObject = new Basic();
//        jObject.setClassname(jClass.getName());
//        jObject.setjClass(jClass);
//        jObject.setTyp(Const.TYP_L);
//        jObject.setSlotArray(new SlotArray(jClass.getInstanceSlotCount()));
//        refHolder.saveNewObject(jObject);
//        return jObject;
//    }

//    @Deprecated
//    public static Basic fetchObject(int refValue) {
//        return refHolder.fetchObject(refValue);
//    }

//    @Deprecated
//    public static JArrayObject newBaseArray(Klass ajclass, int len) {
//        String etype = ajclass.getName().substring(1);
//        JArrayObject jArrayObject = new JArrayObject();
////        jArrayObject.setClassname(ajclass.getName());
////        jArrayObject.setjClass(ajclass);
//        jArrayObject.setEtype(etype);
//        if (etype.equals(Const.TYP_D) || etype.equals(Const.TYP_J)) {
//            SlotArray slotArray = new SlotArray(len * 2);
////            jArrayObject.setSlotArray(slotArray);
////        } else {
////            SlotArray slotArray = new SlotArray(len);
////            jArrayObject.setSlotArray(slotArray);
//        }
//        refHolder.saveNewArrayObject(jArrayObject);
//        return jArrayObject;
//    }

//    @Deprecated
//    public static JArrayObject newMutiArray(Klass ajclass, int[] dims) {
//        JArrayObject jArrayObject = null;
//        if (dims.length == 1) {
//            return newBaseArray(ajclass, dims[0]);
//        } else {
//            int len = dims[0];
//            int[] subdims = new int[dims.length - 1];
//            System.arraycopy(dims, 1, subdims, 0, dims.length - 1);
//            jArrayObject = newBaseArray(ajclass, len);
//            try {
//                Klass subjclass = ajclass.getLoader().FindClass(ajclass.getName().substring(1));
//                for (int i = 0; i < len; i++) {
//                    JArrayObject subArrayObject = newMutiArray(subjclass, subdims);
//                    jArrayObject.setAInt(i, subArrayObject.getArrayRefValue());
//                }
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return jArrayObject;
//    }

    public static KlassObject newKlassObject(Klass klass) {
        KlassObject klassObject=new  KlassObject(generateID(), klass);
        heapmap.put(klassObject.getId(), klassObject);
        return klassObject;
    }

    public static ArrayObject newArrayObject(Klass klass, int len){
        String type = klass.getName().substring(1,2);
        ArrayObject arrayObject=null;
        if(type.equals(Const.TYP_I))
            arrayObject = new IntArrayObject(generateID(), klass, len);
        else if (type.equals(Const.TYP_B))
            arrayObject = new ByteArrayObject(generateID(), klass, len);
        else if (type.equals(Const.TYP_S))
            arrayObject = new ShortArrayObject(generateID(),klass, len);
        else if (type.equals(Const.TYP_L))
            arrayObject = new LongArrayObject(generateID(), klass, len);
        else if (type.equals(Const.TYP_F))
            arrayObject = new FloatArrayObject(generateID(), klass, len);
        else if (type.equals(Const.TYP_D))
            arrayObject = new DoubleArrayObject(generateID(), klass,len);
        else
            arrayObject = new ReferenceArrayObject(generateID(), klass, len);
        heapmap.put(arrayObject.getId(), arrayObject);
        return arrayObject;
    };

    public static ArrayObject multiArrayObject(Klass klass, int[] dims) {
        if(dims.length == 1)
            return newArrayObject(klass, dims[0]);
        //TODO  需要编写多维数组生成代码
        return null;
    }


    public static KlassObject fetchKlassObject(int id){
        return (KlassObject) heapmap.get(id);
    }

    public static ArrayObject fetchArrayObject(int id){
        return (ArrayObject) heapmap.get(id);
    }

}
