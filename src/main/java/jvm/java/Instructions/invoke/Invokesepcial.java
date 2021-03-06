package jvm.java.Instructions.invoke;

import jvm.java.Instructions.Instruction;
import jvm.java.base.Basic;
import jvm.java.classfile.constantpool.ConstantMethodrefInfo;
import jvm.java.loader.Klass;
import jvm.java.loader.JClassLoader;
import jvm.java.loader.JMethod;
import jvm.java.runtime.CodeReader;
import jvm.java.runtime.StackFrame;

import java.io.IOException;

/**
 * Created by admin on 2017/1/11.
 */
public class Invokesepcial extends Instruction {

    int index;

//    StackFrame currentFrame;
//    StackFrame newFrame;
//    JMethod newMethod;

    public Invokesepcial() {
        this.name = "invokespecial";
        this.bc = 183 ;
    }

    public void fetchOperands(CodeReader codeReader) {
        this.index = codeReader.readUnsignedShort();
    }

    public void execute(StackFrame stackFrame) {
        JMethod method = stackFrame.getJclass().castConstantMethodRefInfo(index);
        StackFrame newFrame = new StackFrame(stackFrame.getThreadStack(),method);

        Basic[] args=stackFrame.popArgsForMethod(method);
        newFrame.setLocalVarsForMethod(method, args);

        stackFrame.getThreadStack().pushFrame(newFrame);
        newFrame.loop();
        postInvoke(stackFrame, newFrame);

//        this.currentFrame = stackFrame;
//
//        try {
//            this.findMethod();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        this.buidNewStackFrame();
//
//        String frameName = newFrame.getFrameName();
//        System.out.println("StaticInvoke Start: "+frameName );
//        newFrame.loop();
//        postInvoke();
//
//        System.out.println("StaticInvoke End: "+ frameName);

    }

    private void postInvoke(StackFrame stackFrame, StackFrame newFrame) {
        //TODO 增加后处理
    }

//    protected void findMethod() throws IOException {
//
//        ConstantMethodrefInfo methodrefInfo= (ConstantMethodrefInfo)currentFrame.getMethod().getClassObject().getConstantpool()[index];
//        String classname = methodrefInfo.getClassName();
//        String name = methodrefInfo.getName();
//        Object obj= new Object();
//        String descriptor = methodrefInfo.getDescriptor();
//        JClassLoader jClassLoader = currentFrame.getMethod().getClassObject().getLoader();
//        Klass tjclass = jClassLoader.FindClass(classname);
//        this.newMethod = tjclass.FindMethod(name, descriptor);
//
//    }


//    protected  void buidNewStackFrame() {
//        this.newFrame =  new StackFrame(currentFrame.getThreadStack(), newMethod);
//        Basic[] args=currentFrame.popArgsForMethod(newMethod);
//        this.newFrame.setLocalVarsForMethod(newMethod, args);
//        currentFrame.getThreadStack().pushFrame(newFrame);
//    }
//
//    protected void postInvoke() {
//        Basic ret=newFrame.getReturnValue();
//        if(ret!=null) {
//            System.out.println(newFrame.getFrameName() + " return value :" + ret.getValueInfo());
//        }
//    }
}
