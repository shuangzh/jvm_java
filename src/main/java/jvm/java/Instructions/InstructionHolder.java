package jvm.java.Instructions;

import jvm.java.Instructions.constants.Bipush;
import jvm.java.Instructions.constants.Sipush;
import jvm.java.Instructions.loads.*;
import jvm.java.Instructions.maths.Iadd;
import jvm.java.Instructions.stores.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2016/12/29.
 */
public class InstructionHolder {

    private static Map<Integer, Instruction> instructionMap = new HashMap<Integer, Instruction>();

    static {
        Instruction inst=null;

        // constants instructions
        inst = new Bipush();
        instructionMap.put(inst.BC(), inst);

        inst = new Sipush();
        instructionMap.put(inst.BC(), inst);

        // loads instructions;

        inst = new Iload();
        instructionMap.put(inst.BC(), inst);

        inst = new Iload_0();
        instructionMap.put(inst.BC(), inst);

        inst = new Iload_1();
        instructionMap.put(inst.BC(), inst);

        inst = new Iload_2();
        instructionMap.put(inst.BC(), inst);

        inst = new Iload_3();
        instructionMap.put(inst.BC(), inst);

        // maths insttructions

        inst = new Iadd();
        instructionMap.put(inst.BC(), inst);


        // stores instructions;

        inst = new Istore();
        instructionMap.put(inst.BC(), inst);

        inst = new Istore_0();
        instructionMap.put(inst.BC(), inst);

        inst = new Istore_1();
        instructionMap.put(inst.BC(), inst);

        inst = new Istore_2();
        instructionMap.put(inst.BC(), inst);

        inst = new Istore_3();
        instructionMap.put(inst.BC(), inst);

    }


    public static Instruction  getInstruction(int bc) {
        return  instructionMap.get(bc);
    }



}
