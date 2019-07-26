package com.tongyl.example.jdemosb.service.user;

import com.tongyl.example.jdemosb.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by Tunyl on 2019/7/26.
 * @version 1.0
 */

@Service
public class UserServiceImpl implements UserService {
    @Override
    public List<User> list() {
        List<User> list =  new ArrayList<>();
        User user = new User();
        user.setId(1L);
        list.add(user);
        return list;
    }
}
