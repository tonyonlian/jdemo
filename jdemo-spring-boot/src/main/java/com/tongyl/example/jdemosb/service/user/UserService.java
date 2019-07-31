package com.tongyl.example.jdemosb.service.user;

import com.tongyl.example.jdemosb.entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Created by Tunyl on 2019/7/26.
 * @version 1.0
 */
public interface UserService {
    /**
     * 获取用户列表
     * @return
     */
    List<User> list();
    User selectUserByName(String name);
    List<User> selectAllUser();
    void insertService();
    void deleteService(int id);
    @Transactional
    void changemoney();

}
