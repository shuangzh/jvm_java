package jvm.java.array;

import jvm.java.loader.Klass;

/**
 * Created by admin on 2017/1/13.
 */
public class ArrayObject {
    final int id ;
    String type;
    String classname;
    Klass klass;
    final int length;

    public  ArrayObject(int id, Klass klass, int length){
        this.id = id;
        this.klass = klass;
        this.length = length;
        this.classname = klass.getName();
        this.type = classname.substring(1,2);
    }

    public int getId() {
        return id;
    }

    public int getLength() {
        return length;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

}
