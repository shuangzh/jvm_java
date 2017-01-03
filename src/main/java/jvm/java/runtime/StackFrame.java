package jvm.java.runtime;

import jvm.java.Instructions.Instruction;
import jvm.java.Instructions.InstructionHolder;
import jvm.java.classfile.MethodInfo;
import jvm.java.classfile.attribute.CodeAttribute;

/**
 * Created by admin on 2016/12/28.
 */
public class StackFrame {
    LocalVarsTable localVarsTable;
    OperandStack operandStack;
    CodeAttribute codeAttribute;
    CodeReader codeReader;

    int nextPC;

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

    public MethodInfo getMethodInfo() {
        return methodInfo;
    }

    public ThreadStack getThreadStack() {
        return threadStack;
    }

    MethodInfo methodInfo;
    ThreadStack threadStack;

    public StackFrame(ThreadStack threadStack, MethodInfo methodInfo) {
        this.threadStack = threadStack;
        this.methodInfo = methodInfo;
        codeAttribute = this.methodInfo.getCodeAttribute();

        localVarsTable = new LocalVarsTable(codeAttribute.getMax_locals());
        operandStack = new OperandStack(codeAttribute.getMax_stack());
        codeReader = new CodeReader(codeAttribute.getCode());
    }

    public void setNextPC(int nextPC) {
        this.nextPC = nextPC;
    }

    public void loop() {
        for (; ; ) {
            this.execute();
        }
    }

    public void execute() {
        int pc = this.getNextPC();
        int opcode = this.codeReader.readInstructionCode(pc);
        Instruction inst = InstructionHolder.getInstruction(opcode);
        inst.fetchOperands(codeReader);
        this.setNextPC(codeReader.PC());
        inst.execute(this);
    }
}
