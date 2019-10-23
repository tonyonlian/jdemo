package com.tunyl;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author create by Tunyl on 2019/10/16
 * @version 1.0
 */
public class SimpleContainer {
    private static Map<Class<?>, Object> instances = new ConcurrentHashMap<>();
    public static <T> T getInstance(Class<T> cls){
       try {
           boolean sigleton = cls.isAnnotationPresent(SimpleSingleton.class);
           if(!sigleton){
               return createInstance(cls);
           }
           Object obj = instances.get(cls);
           if(obj != null){
               return (T) obj;
           }
           synchronized(cls){
               obj = instances.get(cls);
               if(obj ==null){
                   obj = createInstance(cls);
                   instances.put(cls,obj);
               }
           }
           return (T) obj;

       }catch(Exception e){
           throw new RuntimeException(e);
       }
    }

    private static <T> T createInstance(Class<T> cls) {
        try {
            T obj = cls.newInstance();
            Field[] fields = cls.getDeclaredFields();
            for (Field f : fields) {
                if (f.isAnnotationPresent(SimpleInject.class)) {
                    if (!f.isAccessible()) {
                        f.setAccessible(true);
                    }
                    Class<?> fieldCls = f.getType();
                    f.set(obj, getInstance(fieldCls));
                }
            }
            return obj;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
