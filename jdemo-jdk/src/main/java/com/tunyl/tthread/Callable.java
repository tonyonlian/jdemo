package com.tunyl.tthread;

/**
 * @author create by Tunyl on 2019/9/30
 * @version 1.0
 */
public interface Callable<V> {
    V call() throws Exception;
}
