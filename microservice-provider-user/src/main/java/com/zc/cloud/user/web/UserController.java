package com.zc.cloud.user.web;

import com.zc.cloud.user.dao.UserDao;
import com.zc.cloud.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 说明 . <br>
 * <p>
 * <p>
 * Copyright: Copyright (c) 2017/10/16 21:47
 * <p>
 * Company: 百趣
 * <p>
 *
 * @author zhongcheng_m@yeah.net
 * @version 1.0.0
 */

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;



    @GetMapping("/user/{id}")
    private User getUser(@PathVariable Long id) {
        User user = userDao.getOne(id);

        return user;
    }
}
