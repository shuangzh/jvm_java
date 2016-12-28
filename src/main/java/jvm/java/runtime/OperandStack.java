package jvm.java.runtime;

/**
 * Created by admin on 2016/12/28.
 */
public class OperandStack extends  ByteArrayStack{

    public OperandStack(int maxStack) {
        super(maxStack * 4);
    }

}
