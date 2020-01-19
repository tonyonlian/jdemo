package com.tunyl.redisdemo;

import com.tunyl.protostuffdemo.User;
import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulConnection;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import io.lettuce.core.codec.ByteArrayCodec;
import io.lettuce.core.codec.RedisCodec;
import io.lettuce.core.resource.ClientResources;
import io.protostuff.LinkedBuffer;
import io.protostuff.ProtobufIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;

import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * @author create by Tunyl on 2020/1/19
 * @version 1.0
 */
public class RedisClientExample {

    public static void main(String[] args) {

     RedisClient   redisClient = RedisClient.create("redis://light-dev@l4.qinglight.com:6396/0");
     StatefulRedisConnection<String, User> connection = redisClient.connect(new RCodec());
     RedisCommands<String, User> syncCommands = connection.sync();
     long startTime = System.currentTimeMillis();
     syncCommands.set("foo", new User("hello",8));
     User user = syncCommands.get("foo");
        System.out.println("take time:"+ (System.currentTimeMillis() - startTime));
     System.out.println(user);
     String userStr = "{\"name\":\"hello\",\"id\":8}";
        System.out.println(userStr.getBytes().length);
     connection.close();
     redisClient.shutdown();
    }



    static class RCodec implements  RedisCodec<String, User>{
        Charset charset = Charset.forName("UTF-8");
        CharsetDecoder charsetDecoder = charset.newDecoder();
        Schema<User> schema = RuntimeSchema.getSchema(User.class);

        @Override
        public String decodeKey(ByteBuffer byteBuffer) {

            try {
                return charsetDecoder.decode(byteBuffer.asReadOnlyBuffer()).toString();
            } catch (CharacterCodingException e) {
                throw new RuntimeException(e.getMessage());
            }
        }

        @Override
        public User decodeValue(ByteBuffer byteBuffer) {
            User userParsed =  schema.newMessage();

            byte[] bytes = new byte[9];
            byteBuffer.get(bytes);
            System.out.println(bytes.length);
            ProtobufIOUtil.mergeFrom(bytes,userParsed,schema);
            return userParsed;
        }

        @Override
        public ByteBuffer encodeKey(String s) {
            return ByteBuffer.wrap(s.getBytes());
        }

        @Override
        public ByteBuffer encodeValue(User user) {

            LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
            byte[] protostuff;
            protostuff = ProtobufIOUtil.toByteArray(user,schema,buffer);
            System.out.println("encode:" +protostuff.length);
            return ByteBuffer.wrap(protostuff);

        }
    }
}
