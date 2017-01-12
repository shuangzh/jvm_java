package jvm.java.runtime;

import jdk.nashorn.internal.scripts.JO;
import jvm.java.base.Const;
import jvm.java.base.JArrayObject;
import jvm.java.base.JObject;
import jvm.java.base.SlotArray;
import jvm.java.loader.JClass;

import java.io.IOException;

/**
 * Created by admin on 2017/1/11.
 */
public class ObjectHeap {

    private static final RefHolder refHolder = new RefHolder();

    public static JObject newObject(JClass jClass) {
        JObject jObject = new JObject();
        jObject.setClassname(jClass.getName());
        jObject.setjClass(jClass);
        jObject.setTyp(Const.TYP_L);
        jObject.setSlotArray(new SlotArray(jClass.getInstanceSlotCount()));
        refHolder.saveNewObject(jObject);
        return jObject;
    }

    public static JObject fetchObject(int refValue) {
        return refHolder.fetchObject(refValue);
    }

    public static JArrayObject newBaseArray(JClass ajclass, int len) {
        String etype = ajclass.getName().substring(1);
        JArrayObject jArrayObject = new JArrayObject();
        jArrayObject.setClassname(ajclass.getName());
        jArrayObject.setjClass(ajclass);
        jArrayObject.setEtype(etype);
        if (etype.equals(Const.TYP_D) || etype.equals(Const.TYP_J)) {
            SlotArray slotArray = new SlotArray(len * 2);
            jArrayObject.setSlotArray(slotArray);
        } else {
            SlotArray slotArray = new SlotArray(len);
            jArrayObject.setSlotArray(slotArray);
        }
        refHolder.saveNewArrayObject(jArrayObject);
        return jArrayObject;
    }

    public static JArrayObject newMutiArray(JClass ajclass, int[] dims) {
        JArrayObject jArrayObject = null;
        if (dims.length == 1) {
            return newBaseArray(ajclass, dims[0]);
        } else {
            int len = dims[0];
            int[] subdims = new int[dims.length - 1];
            System.arraycopy(dims, 1, subdims, 0, dims.length - 1);
            jArrayObject = newBaseArray(ajclass, len);
            try {
                JClass subjclass = ajclass.getLoader().FindClass(ajclass.getName().substring(1));
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
}
