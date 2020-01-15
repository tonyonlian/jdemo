package com.tunyl.collections;

/**
 * @author create by Tunyl on 2019/12/20
 * @version 1.0
 */
public final class TimeUtils {
    //Suppress default constructor for noninstantiability
    private TimeUtils() {
        throw new AssertionError("TimeUtils no Instance for you ");
    }

    public long getTime() {
        return System.currentTimeMillis();
    }
}
