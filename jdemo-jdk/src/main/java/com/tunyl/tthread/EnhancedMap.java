package com.tunyl.tthread;

import java.util.Collections;
import java.util.Map;

/**
 * 演示并发容器复合操作，先检查后更新
 * @author create by Tunyl on 2019/9/19
 * @version 1.0
 */
public class EnhancedMap<K,V> {
    Map<K,V> map;
    public EnhancedMap(Map<K,V> map){
        this.map = Collections.synchronizedMap(map);
    }

    public synchronized V putIfAbsent(K key,V value){
        V old = map.get(key);
        if(old != null){
            return old;
        }
        return map.put(key,value);
    }
}
