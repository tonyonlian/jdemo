package com.tunyl.protostuffdemo;

import io.protostuff.*;
import io.protostuff.runtime.RuntimeSchema;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 使用protostudff实现编解码器
 * @author create by Tunyl on 2020/3/12
 * @version 1.0
 */
public class ProCode {
    /**
     * 序列化
     * @param obj
     * @param <T>
     * @return
     */
    public static <T> byte[] serialize(T obj) {
        Class<T> cls = (Class<T>) obj.getClass();
        LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
        try {
            Schema<T> schema = RuntimeSchema.getSchema(cls);
            return ProtostuffIOUtil.toByteArray(obj, schema, buffer);
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage(),e);

        }finally {
            buffer.clear();
        }


    }

    /**
     * 反序列化
     * @param data
     * @param cls
     * @param <T>
     * @return
     */
    public static <T> T deserialize(byte[] data, Class<T> cls) {
        try {

            Schema<T> schema = RuntimeSchema.getSchema(cls);
            T message = schema.newMessage();
            ProtostuffIOUtil.mergeFrom(data, message, schema);
            return message;
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage(),e);
        }
    }

    public static void main(String[] args) {
        Student stu = new Student();
        stu.setId("100");
        stu.setName("tty");
        stu.setAge(20);
        stu.setHeight(175);

        byte[] buf = ProCode.serialize(stu);
        stu = ProCode.deserialize(buf,Student.class);
        System.out.println(stu);
    }




}
