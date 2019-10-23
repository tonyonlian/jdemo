package com.tunyl.refect;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author create by Tunyl on 2019/10/15
 * @version 1.0
 */
public class AnnoDemo {
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    static @interface  Test{

    }
    @Test
    static class Base{

    }
    static class Child extends Base{

    }

    public static void main(String[] args) {
        System.out.println(Child.class.isAnnotationPresent(Test.class));
    }
}
