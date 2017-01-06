package jvm.java.base;

import jvm.java.loader.JClass;
import jvm.java.loader.JType;

/**
 * Created by admin on 2017/1/3.
 */
public class JObject {

    String typ ;

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

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
        this.typ = Const.TYP_J;
        this.classname="J";
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
        this.typ  = Const.TYP_I;
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
        this.typ = Const.TYP_F;
    }

    public double getDoubleValue() {
        return doubleValue;
    }

    public void setDoubleValue(double doubleValue) {
        this.doubleValue = doubleValue;
        this.typ = Const.TYP_D;
    }

    public int getRefValue() {
        return intValue;
    }

    public void setRefValue(int refValue) {
        this.intValue = refValue;
        this.typ = Const.TYP_L;
    }


    public void setArrayRefValue(int refValue){
        this.intValue = refValue;
        this.typ = Const.TYP_AR;
    }


    public int getArrayRefValue() {
        return this.intValue;
    }

    public void setByteValue(int value) {
        this.intValue = value;
        this.typ = Const.TYP_B;
    }

    public int getByteValue() {
        return this.intValue;
    }

    public void setShortValue(int value){
        this.intValue = value;
        this.typ = Const.TYP_S;
    }

    public int getShortValue()
    {
        return intValue;
    }

    public void setCharValue(int value) {
        this.intValue = value;
        this.typ = Const.TYP_C;
    }

    public void setVoid() {
        this.intValue=0;
        this.typ = Const.TYP_V;
    }

    public void setBoolValue(int value) {
        this.intValue = value;
        this.typ = Const.TYP_Z;
    }

    public SlotArray[] getSlotArray() {
        return slotArray;
    }

    public void setSlotArray(SlotArray[] slotArray) {
        this.slotArray = slotArray;
    }

    SlotArray slotArray[];
}
