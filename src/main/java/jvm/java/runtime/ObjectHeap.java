package jvm.java.runtime;

import jdk.nashorn.internal.scripts.JO;
import jvm.java.base.Const;
import jvm.java.base.JObject;
import jvm.java.base.SlotArray;
import jvm.java.loader.JClass;

/**
 * Created by admin on 2017/1/11.
 */
public class ObjectHeap {

    private  static final  RefHolder refHolder = new RefHolder();

    public static  JObject newObject(JClass jClass) {
        JObject jObject= new JObject();
        jObject.setClassname(jClass.getName());
        jObject.setjClass(jClass);
        jObject.setTyp(Const.TYP_L);
        jObject.setSlotArray( new SlotArray(jClass.getInstanceSlotCount()));
        refHolder.saveNewObject(jObject);
        return  jObject;
    }

    public static JObject fetchObject(int refValue){
        return refHolder.fetchObject(refValue);
    }

}
