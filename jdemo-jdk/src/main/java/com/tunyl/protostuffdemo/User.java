package com.tunyl.protostuffdemo;

import io.protostuff.LinkBuffer;
import io.protostuff.LinkedBuffer;
import io.protostuff.ProtobufIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;

/**
 * @author create by Tunyl on 2020/1/19
 * @version 1.0
 */
public class User {
    String name;
    int id;

    public User(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    static void roundTrip() {
        User user = new User("Jetty", 8);

        Schema<User> schema = RuntimeSchema.getSchema(User.class);
        LinkedBuffer buffer = LinkedBuffer.allocate(512);
        final byte[] protostuff;

        protostuff = ProtobufIOUtil.toByteArray(user,schema,buffer);
        System.out.println(protostuff);

        User userParsed =  schema.newMessage();
        ProtobufIOUtil.mergeFrom(protostuff,userParsed,schema);
        System.out.println(userParsed);
    }

    public static void main(String[] args) {
        User.roundTrip();
    }
}
