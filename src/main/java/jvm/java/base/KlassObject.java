package jvm.java.base;

import jvm.java.loader.JField;
import jvm.java.loader.Klass;

/**
 * Created by admin on 2017/1/13.
 */

public class KlassObject {
    final int id;
    String classname;
    Klass klass;

    public SlotArray getFieldSlots() {
        return fieldSlots;
    }

    SlotArray fieldSlots;

    public KlassObject(int id, Klass klass) {
        this.id = id;
        this.klass = klass;
        this.classname = klass.getName();
        fieldSlots = new SlotArray(klass.getInstanceSlotCount());
    }

    public int getId() {
        return id;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public Klass getKlass() {
        return klass;
    }

    public void setKlass(Klass klass) {
        this.klass = klass;
    }

    public void setField(JField jField, Basic value) {
        //
    }

    public Basic getField(JField jField) {
        return  null;
    }


}
