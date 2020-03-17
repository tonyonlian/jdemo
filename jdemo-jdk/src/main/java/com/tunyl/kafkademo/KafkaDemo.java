package com.tunyl.kafkademo;

import com.alibaba.fastjson.JSONObject;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Map;
import java.util.Properties;
import java.util.Random;

/**
 * @author create by Tunyl on 2020/3/2
 * @version 1.0
 */
public class KafkaDemo {

    public static final String[] CRASHTYPE = {"WEB_JS","JSN_JS","NATIVE_CRASH","NATIVE_EXCEPTION","ANR"};
    public static final String[] APP_ID = {"com.hs.net.hopesspecial","com.huhuang.light","com.hundsun.sxgz.uat","com.hundsun.hblh.pro","com.zhong.com.hundsun.xjhty.uat"};
    private static final String topic = "lighttdh1";
    public static Random random = new Random();
    public static Producer<String,String> producer ;
    static{
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "tdh-1:9092,tdh-2:9092,tdh-3:9092");
        properties.put("acks", "all");
        properties.put("retries", 0);
        properties.put("batch.size", 16384);
        properties.put("linger.ms", 1);
        properties.put("buffer.memory", 33554432);
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        producer = new KafkaProducer<String, String>(properties);
    }


    public static void send(String msg) {
        producer.send(new ProducerRecord<String,String>(topic,msg));
    }

    public static void close(Producer producer) {
        if (producer != null) {
            producer.close();
        }
    }



    public static void main(String[] args) {

       String jsonStr = "{\"l_crashtime\":1560499290598,\"c_consumerid\":\"Light\",\"c_platform\":\"ios\",\"c_username\":\"\",\"c_crashsource\":\"\",\"c_appid\":\"com.hundsun.light.lightIn\",\"c_cpu\":\"CPU_TYPE_ARM64\",\"c_appkey\":\"e42d99b6a25e4398a8c2934a30f3c561\",\"c_model\":\"iPhone,2\",\"c_crashfile\":\"NSInvalidArgumentException: -[__NSArrayM boolValue]: unrecognized selector sent to instance 0x174251a90\\t0   CoreFoundation                      0x000000018dfaeff0 <redacted>   148\\t1   libobjc.A.dylib                     0x000000018ca10538 objc_exception_throw   56\\t2   CoreFoundation                      0x000000018dfb5ef4 <redacted>   0\\t3   CoreFoundation                      0x000000018dfb2f4c <redacted>   916\\t4   CoreFoundation                      0x000000018deaed2c _CF_forwarding_prep_0   92\\t5   Template                            0x0000000100087518 Template   210200\\t6   Template                            0x0000000100075074 Template   135284\\t7   libdispatch.dylib                   0x000000018ce669e0 <redacted>   24\\t8   libdispatch.dylib                   0x000000018ce669a0 <redacted>   16\\t9   libdispatch.dylib                   0x000000018ce6b5e8 _dispatch_main_queue_callback_4CF   996\\t10  CoreFoundation                      0x000000018df5d0c0 <redacted>   12\\t11  CoreFoundation                      0x000000018df5acdc <redacted>   1572\\t12  CoreFoundation                      0x000000018de8ad94 CFRunLoopRunSpecific   424\\t13  GraphicsServices                    0x000000018f8f4074 GSEventRunModal   100\\t14  UIKit                               0x0000000194143130 UIApplicationMain   208\\t15  Template                            0x000000010005b55c Template   30044\\t16  libdyld.dylib                       0x000000018ce9959c <redacted>   4\",\"c_components\":\"[\\\"jsnative\\\",\\\"main\\\",\\\"service\\\",\\\"settings\\\",\\\"ubasanalytics\\\",\\\"web\\\"]\",\"c_fwversion\":\"2.2.2.20190527\",\"c_crashtype\":\"NATIVE_CRASH\",\"c_udid\":\"00:EC:0A:F6:83:5D\",\"c_sdkversion\":\"UBAS-SDK-iOS-2.2.0\",\"c_sysinfo\":\"iOS 10.3.1\",\"c_userid\":\"\",\"c_appname\":\"Light���ܲ���\",\"c_channel\":\"DEV\",\"c_type\":\"CRASH\",\"c_buserid\":\"\",\"c_sessionid\":\"be63589e369d4bd7a7c69ca7eb03aee4\",\"i_buildno\":1,\"l_starttime\":1559645005075,\"c_appversion\":\"1.0\",\"c_imei\":\"\"}";
       String dd = "{\"l_crashtime\":1563498172919,\"c_consumerid\":\"Light"+System.currentTimeMillis()+"\",\"c_platform\":\"iOS\",\"c_username\":\"\",\"c_crashsource\":\"file:///private/var/mobile/Containers/Data/Application/09136184-F5DC-41FF-8527-0983F7D581A6/tmp/www/login-test(1).html\",\"c_appid\":\"com.astronergy.quality\",\"c_cpu\":\"CPU_TYPE_ARM\",\"c_appkey\":\"a05a10109f1411e9b39fa91f36eb94f1\",\"c_model\":\"iPhone5,3\",\"c_crashfile\":\"ReferenceError: Can't find ^A variable: VConsole\\r\\t\\nfile:///private/var/mobile/Containers/Data/Application/09136184-F5DC-41FF-8527-0983F7D581A6/tmp/www/login-test(1).html:29:36\",\"c_components\":\"[\\\"contact\\\",\\\"feedback\\\",\\\"file\\\",\\\"globalquote\\\",\\\"globalquote_components\\\",\\\"imageacquisition\\\",\\\"jpush\\\",\\\"jsnative\\\",\\\"jsnativequote\\\",\\\"location\\\",\\\"lock\\\",\\\"login\\\",\\\"main\\\",\\\"media\\\",\\\"mystock\\\",\\\"push\\\",\\\"safekeyboard\\\",\\\"service\\\",\\\"settings\\\",\\\"share\\\",\\\"tradekeyboard\\\",\\\"ubasanalytics\\\",\\\"web\\\"]\",\"c_fwversion\":\"2.4.4.20190704\",\"c_crashtype\":\"NATIVE_CRASH\",\"c_udid\":\"13c075e3b27d2587702a3a1c9bc432c33ab0541e00000000010000005082401b\",\"c_sdkversion\":\"UBAS-SDK-iOS-2.2.1\",\"c_sysinfo\":\"iPhone OS 8.4\",\"c_userid\":\"\",\"c_appname\":\"7-18ty冒烟测试用\",\"c_channel\":\"App Store\",\"c_type\":\"START\",\"c_buserid\":\"\",\"c_sessionid\":\"D83BE3A4-66FD-4CAC-B9C9-1E74F2AF8559\",\"i_buildno\":494,\"l_starttime\":1563498172919,\"c_appversion\":\"13.6.9\",\"c_imei\":\"\"}";

       int k= 600;
        while (k > 0) {
            Map<String, Object> map = (Map<String, Object>) JSONObject.parse(jsonStr);
            map.put("c_appid", APP_ID[random.nextInt(4)]);
            map.put("c_udid","add1q22sdredfe3f4trasee"+k +random.nextInt(10000)+System.currentTimeMillis());
            map.put("c_crashtype",CRASHTYPE[2]);
            map.put("l_crashtime", System.currentTimeMillis());
            map.put("l_starttime",System.currentTimeMillis());
            map.put("c_userid","userid"+random.nextInt());
            map.put("c_type","START");
            String data = JSONObject.toJSONString(map);
            System.out.println(data);
            send(data);
            producer.flush();
            k--;

        }
        close(producer);
    }
}
