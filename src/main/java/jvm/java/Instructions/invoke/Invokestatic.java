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
 * Created by admin on 2017/1/4.
 */
public class Invokestatic extends Instruction{

    public Invokestatic() {
        this.name="invokestatic";
        this.bc =  184; // 0xb8
    }

    int index ;
//    JMethod newMethod;
//    StackFrame newStackFrame;
//    StackFrame currentStackFrame;

    @Override
    public void fetchOperands(CodeReader codeReader) {
        this.index = codeReader.readShort();
    }

    @Override
    public void execute(StackFrame stackFrame) {
        JMethod method = stackFrame.getJclass().castConstantMethodRefInfo(index);
        StackFrame newFrame = new StackFrame(stackFrame.getThreadStack(),method);

        Basic[] args=stackFrame.popArgsForMethod(method);
        newFrame.setLocalVarsForMethod(method, args);

        stackFrame.getThreadStack().pushFrame(newFrame);
        newFrame.loop();
        postInvoke(stackFrame, newFrame);

//        this.currentStackFrame = stackFrame;
//
//        try {
//            this.findMethod();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        this.buidNewStackFrame();
//
//        System.out.println("StaticInvoke Start: "+newStackFrame.getFrameName() );
//        newStackFrame.loop();
//        postInvoke();
//
//        System.out.println("StaticInvoke End: "+newStackFrame.getFrameName());

    }


//    protected void findMethod() throws IOException {
//        ConstantMethodrefInfo methodrefInfo= (ConstantMethodrefInfo)currentStackFrame.getMethod().getClassObject().getConstantpool()[index];
//        String classname = methodrefInfo.getClassName();
//        String name = methodrefInfo.getName();
//        String descriptor = methodrefInfo.getDescriptor();
//        JClassLoader jClassLoader = currentStackFrame.getMethod().getClassObject().getLoader();
//        Klass tjclass = jClassLoader.FindClass(classname);
//        this.newMethod = tjclass.FindMethod(name, descriptor);
//    }
//
//    protected  void buidNewStackFrame() {
//        this.newStackFrame =  new StackFrame(currentStackFrame.getThreadStack(), newMethod);
//        Basic[] args=currentStackFrame.popArgsForMethod(newMethod);
//        this.newStackFrame.setLocalVarsForMethod(newMethod, args);
//        currentStackFrame.getThreadStack().pushFrame(newStackFrame);
//    }
//
//    protected void postInvoke() {
//        Basic ret=newStackFrame.getReturnValue();
//        if(ret!=null) {
//            System.out.println(newStackFrame.getFrameName() + " return value :" + ret.getValueInfo());
//        }
//    }

    protected void postInvoke(StackFrame currentFrame, StackFrame invokedFrame) {
            //TODO 增加函数调用后处理功能
    }

}
