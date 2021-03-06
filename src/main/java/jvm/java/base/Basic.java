package jvm.java.base;

/**
 * Created by admin on 2017/1/3.
 */
public class Basic {

    String typ ;

//    String classname;
//    Klass jClass;

    int intValue;
    char charValue;
    float floatValue;
    double doubleValue;
    long  longValue;

//    protected SlotArray slotArray;

    public String getType() {
        return typ;
    }

    public void setType(String typ) {
        this.typ = typ;
    }

    public String getValueInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("typ:").append(typ).append(",");
        sb.append("i:").append(intValue).append(",");
        sb.append("f:").append(floatValue).append(",");
        sb.append("l:").append(longValue).append(",");
        sb.append("d:").append(doubleValue).append(",");
        sb.append("c:").append(charValue);
        return sb.toString();
    };

    public long getLongValue() {
        return longValue;
    }

    public void setLongValue(long longValue) {
        this.longValue = longValue;
        this.typ = Const.TYP_J;
//        this.classname="J";
    }

//    public String getClassname() {
//        return classname;
//    }
//
//    public void setClassname(String classname) {
//        this.classname = classname;
//    }

    public int getIntValue() {
        return intValue;
    }

    public void setIntValue(int intValue) {
        this.intValue = intValue;
        this.typ  = Const.TYP_I;
    }

//    public Klass getjClass() {
//        return jClass;
//    }
//
//    public void setjClass(Klass jClass) {
//        this.jClass = jClass;
//    }

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

    public void setCharValue(char value) {
        this.charValue = value;
        this.typ = Const.TYP_C;
    }

    public char getCharValue() {
        return  this.charValue;
    }

    public void setVoid() {
        this.intValue=0;
        this.typ = Const.TYP_V;
    }

    public void setBoolValue(int value) {
        this.intValue = value;
        this.typ = Const.TYP_Z;
    }

    public boolean isReference() {
        if(typ.equals(Const.TYP_AR) || typ.equals(Const.TYP_L))
            return true;
        else
            return false;
    }

//    public SlotArray getSlotArray() {
//        return slotArray;
//    }
//
//    public void setSlotArray(SlotArray slotArray) {
//        this.slotArray = slotArray;
//    }



}
