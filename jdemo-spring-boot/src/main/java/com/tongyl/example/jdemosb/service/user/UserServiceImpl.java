package com.tongyl.example.jdemosb.service.user;

import com.tongyl.example.jdemosb.dao.UserDao;
import com.tongyl.example.jdemosb.entity.User;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by Tunyl on 2019/7/26.
 * @version 1.0
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> list() {
        List<User> list =  new ArrayList<>();
        User user = new User(); //User.builder().age(1).id(1).name("Dave").money(2000).build();
        user.setId(1);
        list.add(user);
        return list;
    }

    @Override
    public User selectUserByName(String name) {
        return userDao.findUserByName(name);
    }

    @Override
    public List<User> selectAllUser() {
        return userDao.findAllUser();
    }

    @Override
    public void insertService() {
        userDao.insertUser("SnailClimb", 22, 3000.0);
        userDao.insertUser("Daisy", 19, 3000.0);
    }

    @Override
    public void deleteService(int id) {
        userDao.deleteUser(id);
    }
    /**
     * 模拟事务。由于加上了 @Transactional注解，如果转账中途出了意外 SnailClimb 和 Daisy 的钱都不会改变。
     */
    @Override
    public void changemoney() {
        userDao.updateUser("SnailClimb", 22, 2000.0, 5);
        // 模拟转账过程中可能遇到的意外状况
        int temp = 1 / 0;
        userDao.updateUser("Daisy", 19, 4000.0, 4);
    }
}
