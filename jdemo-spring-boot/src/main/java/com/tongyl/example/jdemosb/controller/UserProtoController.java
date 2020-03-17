package com.tongyl.example.jdemosb.controller;

import com.tongyl.example.jdemosb.entity.protoentity.UserInfo;
import com.tongyl.example.jdemosb.entity.protoentity.user_info;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 返回protobuf ,现在返回之前需要步骤
 * 1：根据proto文件生成javaod
 * 2：增加protobuf的http的解析器
 * 3：拦截器中的返回姐结果不能使用json解析
 * @author create by Tunyl on 2020/1/20
 * @version 1.0
 */

@Slf4j
@Controller
@RequestMapping("/proto")
public class UserProtoController {
    @RequestMapping(value = "/user_info",method = RequestMethod.POST, produces = "application/x-protobuf")
    public @ResponseBody user_info getUserInfo() {
        log.info("开始请求/proto/user_info");
      user_info.Builder builder = user_info.newBuilder();

      return  builder.setId(1000l)
               .setAge(20)
               .setName("kaili")
               .setMoney(2000)
               .build();


    }

}
