package com.zc.cloud.movie.web;

import com.zc.cloud.movie.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 说明 . <br>
 * <p>
 * <p>
 * Copyright: Copyright (c) 2017/10/16 22:09
 * <p>
 * Company: 百趣
 * <p>
 *
 * @author zhongcheng_m@yeah.net
 * @version 1.0.0
 */
@RestController
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;


    @Value("${remote.user.url}")
    private String getUserUrl;

    @GetMapping("/movie/{id}")
    public User movie(@PathVariable Long id){
        User user = restTemplate.getForObject(getUserUrl+id,User.class);
        return user;
    }
}
