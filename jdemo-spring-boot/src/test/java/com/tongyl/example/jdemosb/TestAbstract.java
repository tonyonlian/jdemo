package com.tongyl.example.jdemosb;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Created by Tunyl on 2019/7/26.
 * @version 1.0
 */

@RunWith(SpringRunner.class)
//SpringBootTest.WebEnvironment.RANDOM_PORT经常和测试类中@LocalServerPort一起在注入属性时使用。会随机生成一个端口号
@SpringBootTest(classes = JdemoSBApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class TestAbstract {
}
