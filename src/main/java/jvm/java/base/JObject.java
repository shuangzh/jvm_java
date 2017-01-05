package jvm.java.base;

import jvm.java.loader.JClass;
import jvm.java.loader.JType;

/**
 * Created by admin on 2017/1/3.
 */
public class JObject {
    JType jType;
    String classname;
    JClass jClass;
    int intValue;
    float floatValue;
    double doubleValue;
    long  longValue;

    public long getLongValue() {
        return longValue;
    }

    public void setLongValue(long longValue) {
        this.longValue = longValue;
    }

    public JType getjType() {
        return jType;
    }

    public void setjType(JType jType) {
        this.jType = jType;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public int getIntValue() {
        return intValue;
    }

    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }

    public JClass getjClass() {
        return jClass;
    }

    public void setjClass(JClass jClass) {
        this.jClass = jClass;
    }

    public float getFloatValue() {
        return floatValue;
    }

    public void setFloatValue(float floatValue) {
        this.floatValue = floatValue;
    }

    public double getDoubleValue() {
        return doubleValue;
    }

    public void setDoubleValue(double doubleValue) {
        this.doubleValue = doubleValue;
    }

    public int getRefValue() {
        return intValue;
    }

    public void setRefValue(int refValue) {
        this.intValue = refValue;
    }

    public SlotArray[] getSlotArray() {
        return slotArray;
    }

    public void setSlotArray(SlotArray[] slotArray) {
        this.slotArray = slotArray;
    }

    SlotArray slotArray[];
}
