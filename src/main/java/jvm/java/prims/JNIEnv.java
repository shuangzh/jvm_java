package jvm.java.prims;

import jvm.java.base.Basic;
import jvm.java.loader.Klass;
import jvm.java.loader.JMethod;
import jvm.java.runtime.LocalVarsTable;
import jvm.java.runtime.StackFrame;
import jvm.java.runtime.ThreadStack;
import jvm.java.runtime.VMContext;

/**
 * Created by admin on 2017/1/5.
 */
public class JNIEnv {
    VMContext vmContext;

    public Basic CallStaticMethod(Klass jClass, JMethod jMethod, Basic[] jObjects) {
        StackFrame newFrame = new StackFrame(vmContext.getThreadStack(), jMethod);
        ThreadStack threadStack= vmContext.getThreadStack();
        LocalVarsTable localVarsTable=newFrame.getLocalVarsTable();
        if(jObjects !=null && jObjects.length >0) {
//            for (int i=0; i<jObjects.length; i++) {
//                JType jType=jObjects[i].getjType();
//                switch (jType){
//                    case J:
//                        localVarsTable.setLong(i, jObjects[i].getLongValue());
//                        i++;
//                        break;
//                    case D:
//                        localVarsTable.setDouble(i,jObjects[i].getDoubleValue());
//                        i++;
//                        break;
//                    case F:
//                        localVarsTable.setFloat(i, jObjects[i].getFloatValue());
//                        break;
//                    default:
//                        localVarsTable.setInt(i, jObjects[i].getIntValue());
//                }
//            }
        }
        newFrame.loop();
        return  null;
    };

    public VMContext getVmContext() {
        return vmContext;
    }

    public void setVmContext(VMContext vmContext) {
        this.vmContext = vmContext;
    }
}
