package jvm.java.runtime;

import jvm.java.Instructions.Instruction;
import jvm.java.Instructions.InstructionHolder;
import jvm.java.base.Const;
import jvm.java.base.Basic;
import jvm.java.classfile.MethodInfo;
import jvm.java.classfile.attribute.CodeAttribute;
import jvm.java.loader.Klass;
import jvm.java.loader.JMethod;

/**
 * Created by admin on 2016/12/28.
 */
public class StackFrame {

    public final static int STATE_INIT = 0;
    public final static int STATE_RUN = 1;
    public final static int STATE_INVOKE = 2;
    public final static int STATE_RETURN = 3;
    public final static int STATE_EXCEPTION = 4;

    LocalVarsTable localVarsTable;
    OperandStack operandStack;
    CodeAttribute codeAttribute;
    CodeReader codeReader;
    int nextPC;
    int state;
    MethodInfo methodInfo;
    ThreadStack threadStack;
    JMethod method;

    Klass jclass;

    public Klass getJclass() {
        return jclass;
    }

    public void setJclass(Klass jclass) {
        this.jclass = jclass;
    }

    public StackFrame(Klass jclass) {
        this.jclass = jclass;
    }

    public String getFrameName() {
        return  jclass.getName() + "->" + method.getName();
    }

    public Basic getReturnValue() {
        return returnValue;
    }

    public void setReturnValue(Basic returnValue) {
        this.returnValue = returnValue;
    }

    Basic returnValue;

    public StackFrame(ThreadStack threadStack, MethodInfo methodInfo) {
        this.threadStack = threadStack;
        this.methodInfo = methodInfo;
        codeAttribute = this.methodInfo.getCodeAttribute();

        localVarsTable = new LocalVarsTable(codeAttribute.getMax_locals());
        operandStack = new OperandStack(codeAttribute.getMax_stack());
        codeReader = new CodeReader(codeAttribute.getCode());
    }


    public StackFrame(ThreadStack threadStack, JMethod method) {
        this.threadStack = threadStack;
        this.method = method;

        localVarsTable = new LocalVarsTable(method.getMaxLocals());
        operandStack = new OperandStack(method.getMaxStack());
        codeReader = new CodeReader(method.getCode());
        jclass = method.getClassObject();
    }

//    public VMContext getVmContext() {
//        return vmContext;
//    }
//
//    public void setVmContext(VMContext vmContext) {
//        this.vmContext = vmContext;
//    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public LocalVarsTable getLocalVarsTable() {
        return localVarsTable;
    }

    public OperandStack getOperandStack() {
        return operandStack;
    }

    public CodeAttribute getCodeAttribute() {
        return codeAttribute;
    }

    public CodeReader getCodeReader() {
        return codeReader;
    }

    public int getNextPC() {
        return nextPC;
    }

    public void setNextPC(int nextPC) {
        this.nextPC = nextPC;
    }

    public MethodInfo getMethodInfo() {
        return methodInfo;
    }

    public ThreadStack getThreadStack() {
        return threadStack;
    }

    public JMethod getMethod() {
        return method;
    }

    public void setMethod(JMethod method) {
        this.method = method;
    }

    public void loop() {
        this.state = STATE_RUN;
        for (; ; ) {
            if (this.state == STATE_RETURN || this.state == STATE_EXCEPTION)
                break;
            int pc = this.getNextPC();
            int opcode = this.codeReader.readInstructionCode(pc);
            Instruction inst = InstructionHolder.getInstruction(opcode);
            inst.fetchOperands(codeReader);
            this.setNextPC(codeReader.PC());
            inst.execute(this);
        }
    }

    public void execute() {
        this.loop();
//        int pc = this.getNextPC();
//        int opcode = this.codeReader.readInstructionCode(pc);
//        Instruction inst = InstructionHolder.getInstruction(opcode);
//        inst.fetchOperands(codeReader);
//        this.setNextPC(codeReader.PC());
//        inst.execute(this);

    }


    public Basic[] popArgsForMethod(JMethod method) {
        String[] argsDesc = method.getArgsDesciptors();
        Basic[] args = null;

        if(argsDesc !=null && argsDesc.length > 0)
            args = new Basic[argsDesc.length];
        else
            return  null;

        for (int i = args.length - 1; i >= 0; i--) {
            String desc = argsDesc[i].substring(0, 1);
            Basic obj = new Basic();
            if (desc.equals(Const.TYP_D)) {
                double d = this.operandStack.popDouble();
                obj.setDoubleValue(d);
                obj.setType(desc);
            } else if (desc.equals(Const.TYP_J)) {
                long l = this.operandStack.popLong();
                obj.setLongValue(l);
                obj.setType(desc);
            } else {
                int k = this.operandStack.popInt();
                obj.setIntValue(k);
                obj.setType(desc);
            }
            args[i] = obj;
        }
        return args;
    }

    public void setLocalVarsForMethod(JMethod jMethod, Basic[] jObjects) {
        String[] argsDesc = method.getArgsDesciptors();
        int index = 0;
        if (argsDesc != null && argsDesc.length >= 1) {
            for (int i = 0; i < argsDesc.length; i++) {
                String desc = argsDesc[i].substring(0, 1);
                if (desc.equals(Const.TYP_D)) {
                    localVarsTable.setDouble(index, jObjects[i].getDoubleValue());
                    index += 2;
                } else if (desc.equals(Const.TYP_J)) {
                    localVarsTable.setLong(index, jObjects[i].getLongValue());
                    index += 2;
                } else {
                    localVarsTable.setInt(index, jObjects[i].getIntValue());
                    index++;
                }
            }
        }
    }

}
