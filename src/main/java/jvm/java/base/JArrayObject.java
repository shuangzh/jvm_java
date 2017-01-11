package jvm.java.base;

/**
 * Created by admin on 2017/1/11.
 */
public class JArrayObject extends JObject {

    String etype;

    public String getEtype() {
        return etype;
    }

    public void setEtype(String etype) {
        this.etype = etype;
    }

    public int length() {
        if (etype.equals(Const.TYP_J) || (etype.equals(Const.TYP_D)))
            return this.slotArray.getLength() / 2;
        else
            return this.slotArray.getLength();
    }

    ;

    public int getAInt(int index) {
        return this.slotArray.getInt(index);
    }

    public void setAInt(int index, int value) {
        this.slotArray.setInt(index, value);
    }

    public double getADouble(int index) {
        return this.slotArray.getDouble(index);
    }

    public void setADouble(int index, double value) {
        this.slotArray.setDouble(index, value);
    }

    public long getALong(int index) {
        return slotArray.getLong(index);
    }

    public void setALong(int index, long value) {
        slotArray.setLong(index, value);
    }

    public static JArrayObject createArrayObject(String arraytype, int[] dims) {
        return null;
    }

    public static JArrayObject createBaseArray(String typ, int length) {
        JArrayObject jArrayObject = new JArrayObject();
        jArrayObject.setEtype(typ);
        jArrayObject.setTyp("[");
        jArrayObject.setClassname("[" + typ);

        if (typ.equals(Const.TYP_J) || (typ.equals(Const.TYP_D))) {
            SlotArray slotArray = new SlotArray(2 * length);
            jArrayObject.setSlotArray(slotArray);
        } else {
            SlotArray slotArray = new SlotArray( length);
            jArrayObject.setSlotArray(slotArray);
        }
        return jArrayObject;
    }

}

