package jvm.java.classfile.attribute;

import javafx.scene.chart.PieChart;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Created by admin on 2016/12/26.
 */
public class ExceptionTable {
    int start_pc;       // u2
    int end_pc;         // u2
    int handler_pc;     // u2
    int catch_type;     // u2

    public ExceptionTable(DataInputStream dataInputStream) throws IOException {
        this.start_pc = dataInputStream.readUnsignedShort();
        this.end_pc = dataInputStream.readUnsignedShort();
        this.handler_pc = dataInputStream.readUnsignedShort();
        this.catch_type = dataInputStream.readUnsignedShort();
    }

    public int getStart_pc() {
        return start_pc;
    }

    public void setStart_pc(int start_pc) {
        this.start_pc = start_pc;
    }

    public int getEnd_pc() {
        return end_pc;
    }

    public void setEnd_pc(int end_pc) {
        this.end_pc = end_pc;
    }

    public int getHandler_pc() {
        return handler_pc;
    }

    public void setHandler_pc(int handler_pc) {
        this.handler_pc = handler_pc;
    }

    public int getCatch_type() {
        return catch_type;
    }

    public void setCatch_type(int catch_type) {
        this.catch_type = catch_type;
    }
}
