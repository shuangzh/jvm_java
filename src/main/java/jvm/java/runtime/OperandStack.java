package jvm.java.runtime;

import jvm.java.base.ByteArrayStack;

/**
 * Created by admin on 2016/12/28.
 */
public class OperandStack extends ByteArrayStack {

    public OperandStack(int maxStack) {
        super(maxStack * 4);
    }

    public void pushRef(int ref){
        this.pushInt(ref);
    }

    public int popRef(){
        return  this.popInt();
    }

}
