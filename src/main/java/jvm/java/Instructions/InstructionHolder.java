package jvm.java.Instructions;

import jvm.java.Instructions.cast.I2b;
import jvm.java.Instructions.cast.I2c;
import jvm.java.Instructions.cast.I2s;
import jvm.java.Instructions.constants.*;
import jvm.java.Instructions.invoke.IReturn;
import jvm.java.Instructions.invoke.Invokesepcial;
import jvm.java.Instructions.invoke.Invokestatic;
import jvm.java.Instructions.invoke.Return;
import jvm.java.Instructions.loads.*;
import jvm.java.Instructions.maths.*;
import jvm.java.Instructions.newinst.NewObj;
import jvm.java.Instructions.opstack.Dup;
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


        inst = new Invokestatic();
        instructionMap.put(inst.BC(), inst);


        inst = new IReturn();
        instructionMap.put(inst.BC(), inst);

        inst = new Return();
        instructionMap.put(inst.BC(), inst);

        inst = new Dup();
        instructionMap.put(inst.BC(), inst);

        inst = new Invokesepcial();
        instructionMap.put(inst.BC(), inst);

        inst = new NewObj();
        instructionMap.put(inst.BC(), inst);

        inst = new Aload();
        instructionMap.put(inst.BC(), inst);

        inst = new Aload_0();
        instructionMap.put(inst.BC(), inst);

        inst = new Aload_1();
        instructionMap.put(inst.BC(), inst);

        inst = new Aload_2();
        instructionMap.put(inst.BC(), inst);

        inst = new Aload_3();
        instructionMap.put(inst.BC(), inst);

        inst = new Astore();
        instructionMap.put(inst.BC(), inst);

        inst = new Astore_0();
        instructionMap.put(inst.BC(), inst);

        inst = new Astore_1();
        instructionMap.put(inst.BC(), inst);

        inst = new Astore_2();
        instructionMap.put(inst.BC(), inst);

        inst = new Astore_3();
        instructionMap.put(inst.BC(), inst);



        inst = new Lstore();
        instructionMap.put(inst.BC(), inst);

        inst = new Lstore_0();
        instructionMap.put(inst.BC(), inst);

        inst = new Lstore_1();
        instructionMap.put(inst.BC(), inst);

        inst = new Lstore_2();
        instructionMap.put(inst.BC(), inst);

        inst = new Lstore_3();
        instructionMap.put(inst.BC(), inst);

        inst = new Fstore();
        instructionMap.put(inst.BC(), inst);

        inst = new Fstore_0();
        instructionMap.put(inst.BC(), inst);

        inst = new Fstore_1();
        instructionMap.put(inst.BC(), inst);

        inst = new Fstore_2();
        instructionMap.put(inst.BC(), inst);

        inst = new Fstore_3();
        instructionMap.put(inst.BC(), inst);

        inst = new Dstore();
        instructionMap.put(inst.BC(), inst);

        inst = new Dstore_0();
        instructionMap.put(inst.BC(), inst);

        inst = new Dstore_1();
        instructionMap.put(inst.BC(), inst);

        inst = new Dstore_2();
        instructionMap.put(inst.BC(), inst);

        inst = new Dstore_3();
        instructionMap.put(inst.BC(), inst);

        inst = new Ldc();
        instructionMap.put(inst.BC(), inst);

        inst =new Ldc2_w();
        instructionMap.put(inst.BC(), inst);

        inst = new Iconst_m1();
        instructionMap.put(inst.BC(), inst);

        inst = new Iconst_0();
        instructionMap.put(inst.BC(), inst);

        inst = new Iconst_1();
        instructionMap.put(inst.BC(), inst);

        inst = new Iconst_2();
        instructionMap.put(inst.BC(), inst);

        inst = new Iconst_3();
        instructionMap.put(inst.BC(), inst);

        inst = new Iconst_4();
        instructionMap.put(inst.BC(), inst);

        inst = new Iconst_5();
        instructionMap.put(inst.BC(), inst);

        inst = new Isub();
        instructionMap.put(inst.BC(), inst);

        inst = new Imul();
        instructionMap.put(inst.BC(), inst);

        inst = new IDiv();
        instructionMap.put(inst.BC(), inst);

        inst = new I2b();
        instructionMap.put(inst.BC(), inst);

        inst = new I2s();
        instructionMap.put(inst.BC(), inst);

        inst = new I2c();
        instructionMap.put(inst.BC(), inst);

        inst = new Fadd();
        instructionMap.put(inst.BC(), inst);

        inst = new Fmul();
        instructionMap.put(inst.BC(), inst);

        inst = new Fdiv();
        instructionMap.put(inst.BC(), inst);

        inst = new Fsub();
        instructionMap.put(inst.BC(), inst);

        inst = new Fload();
        instructionMap.put(inst.BC(), inst);

        inst = new Fload_0();
        instructionMap.put(inst.BC(), inst);

        inst = new Fload_1();
        instructionMap.put(inst.BC(), inst);

        inst = new Fload_2();
        instructionMap.put(inst.BC(), inst);

        inst = new Fload_3();
        instructionMap.put(inst.BC(), inst);


        inst = new Dadd();
        instructionMap.put(inst.BC(), inst);

        inst = new Dsub();
        instructionMap.put(inst.BC(), inst);

        inst = new Dmul();
        instructionMap.put(inst.BC(), inst);

        inst = new Ddiv();
        instructionMap.put(inst.BC(), inst);

        inst = new Dload();
        instructionMap.put(inst.BC(), inst);

        inst = new Dload_0();
        instructionMap.put(inst.BC(), inst);

        inst = new Dload_1();
        instructionMap.put(inst.BC(), inst);

        inst = new Dload_2();
        instructionMap.put(inst.BC(), inst);

        inst = new Dload_3();
        instructionMap.put(inst.BC(), inst);

        inst = new Ladd();
        instructionMap.put(inst.BC(), inst);

        inst = new Lsub();
        instructionMap.put(inst.BC(), inst);

        inst = new Lmul();
        instructionMap.put(inst.BC(), inst);

        inst = new Ldiv();
        instructionMap.put(inst.BC(), inst);

        inst = new Lload();
        instructionMap.put(inst.BC(), inst);

        inst = new Lload_0();
        instructionMap.put(inst.BC(), inst);

        inst = new Lload_1();
        instructionMap.put(inst.BC(), inst);

        inst = new Lload_2();
        instructionMap.put(inst.BC(), inst);

        inst = new Lload_3();
        instructionMap.put(inst.BC(), inst);

    }


    public static Instruction  getInstruction(int bc) {
        return  instructionMap.get(bc);
    }



}
