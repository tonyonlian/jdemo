package com.tongyl.example.jdemomysql;


import com.hundsun.light.signaturesdk.main.SignaturesdkMain;

/**
 * @author create by Tunyl on 2019/12/17
 * @version 1.0
 */
public class SignTest {
    public static void main(String[] args) {
        System.out.println(SignaturesdkMain.readLicense());

        //接口body的String
        String body = "{\"userSource\":\"GTN\",\"loginName\":\"13256237896\",\"hsid\":\"A0000000000000\",\"company\":null,\"email\":null}";
        //调用light-signaturesdk的signPost方法，计算签名url
        String signUrl = SignaturesdkMain.signPost(body);
        System.out.println(signUrl);
        //将url粘到postman中发送post请求 ，请求的Content-Type:application/json ,Body中粘上述body的参数
    }
}
