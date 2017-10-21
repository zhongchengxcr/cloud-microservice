package com.zc.cloud.movie.feign.hystrix;

import com.zc.cloud.movie.feign.UserApi;
import com.zc.cloud.movie.vo.User;
import org.springframework.stereotype.Component;

/**
 * 说明 . <br>
 * <p>
 * <p>
 * Copyright: Copyright (c) 2017/10/18 下午2:32
 * <p>
 * Company: 百趣
 * <p>
 *
 * @author zhongcheng_m@yeah.net
 * @version 1.0.0
 */
//@Component
public class UserHystrix implements UserApi {
    @Override
    public User getUser(Long id) {
        User u = new User();
        u.setName("ppppppp");
        u.setAge(999);
        u.setUsername("ooooooo");
        return u;
    }

    @Override
    public String port() {
        return "1234";
    }
}
