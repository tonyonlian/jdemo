package com.tunyl.tthread;

/**
 * @author create by Tunyl on 2019/9/30
 * @version 1.0
 */
public interface MyFuture<V> {
    V get() throws  Exception;
}
