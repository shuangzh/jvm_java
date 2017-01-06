package jvm.java.runtime;

import jvm.java.loader.JClassLoader;
import jvm.java.prims.JNIEnv;

/**
 * Created by admin on 2017/1/5.
 */
public class VMContext {
    ThreadStack threadStack;

    public ThreadStack getThreadStack() {
        return threadStack;
    }

    public void setThreadStack(ThreadStack threadStack) {
        this.threadStack = threadStack;
    }

    public RefHolder getRefHolder() {
        return refHolder;
    }

    public void setRefHolder(RefHolder refHolder) {
        this.refHolder = refHolder;
    }

    public JClassLoader getjClassLoader() {
        return jClassLoader;
    }

    public void setjClassLoader(JClassLoader jClassLoader) {
        this.jClassLoader = jClassLoader;
    }

    RefHolder refHolder;
    JClassLoader jClassLoader;

    JNIEnv jniEnv ;

    public JNIEnv getJniEnv() {
        return jniEnv;
    }

    public void setJniEnv(JNIEnv jniEnv) {
        this.jniEnv = jniEnv;
    }
}
