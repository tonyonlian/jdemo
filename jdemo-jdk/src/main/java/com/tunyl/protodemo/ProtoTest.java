package com.tunyl.protodemo;

import com.google.protobuf.InvalidProtocolBufferException;

/**
 * @author create by Tunyl on 2019/12/27
 * @version 1.0
 */
public class ProtoTest {
    public static void main(String[] args) {
        System.out.println("=========== 构建一个GPS模型 ===============");
        GpsDataProto.gps_data.Builder gpsBuilder = GpsDataProto.gps_data.newBuilder();
        gpsBuilder.setAltitude(1);
        gpsBuilder.setDataTime("2017-12-17 16:21:44");
        gpsBuilder.setGpsStatus(1);
        gpsBuilder.setLat(39.123);
        gpsBuilder.setLon(120.112);
        gpsBuilder.setDirection(30.2F);
        gpsBuilder.setId(100L);


        GpsDataProto.gps_data gpsData = gpsBuilder.build();
        System.out.println(gpsData.toString());

        System.out.println("===== 构建GPS模型结束 =====");

        System.out.println("===== gps Byte 开始=====");
        for (byte b : gpsData.toByteArray()) {
            System.out.print(b);
        }
        System.out.println("\n" + "bytes长度" + gpsData.toByteString().size());
        System.out.println("===== gps Byte 结束 =====");

        System.out.println("===== 使用gps 反序列化生成对象开始 =====");
        GpsDataProto.gps_data gd = null;
        try {
            gd = GpsDataProto.gps_data.parseFrom(gpsData.toByteArray());
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
        System.out.print(gd.toString());
        System.out.println("===== 使用gps 反序列化生成对象结束 =====");


    }
}
