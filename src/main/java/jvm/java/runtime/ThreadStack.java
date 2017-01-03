package jvm.java.runtime;

import java.util.Stack;

/**
 * Created by admin on 2016/12/28.
 */
public class ThreadStack {

    private Stack<StackFrame> stack = null;

    public void pushFrame(StackFrame stackFrame) {
        this.stack.push(stackFrame);
    }

    public StackFrame popFrame() {
        return stack.pop();
    }

    public StackFrame currentFrame() {
        return this.stack.peek();
    }


    public void loop(int num) {
        if (num < 0) {
            for (; ; ) {
                StackFrame frame = currentFrame();
                frame.execute();
            }
        } else {
            for (int i = 0; i < num; i++) {
                StackFrame frame = currentFrame();
                frame.execute();
            }
        }
    }

}
