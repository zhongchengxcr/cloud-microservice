package com.zc.cloud.movie.web;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.zc.cloud.movie.feign.UserApi;
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

    @SuppressWarnings("all")
    @Autowired
    private EurekaClient discoveryClient;

    @Value("${remote.user.url}")
    private String getUserUrl;

    @SuppressWarnings("all")
    @Autowired
    private UserApi userApi;

    @GetMapping("eureka/instance")
    public String serviceUrl() {
        InstanceInfo instance = discoveryClient.getNextServerFromEureka("microservice-consumer-movie", false);
        return instance.getHomePageUrl();
    }


//    @Value("${remote.user.url}")
//    private String getUserUrl;

    @GetMapping(value = "/movie/{id}", produces = { "application/json;charset=UTF-8" } )
    public User movie(@PathVariable Long id){



        User user = restTemplate.getForObject("http://microservice-provider-user/user/"+id,User.class);
        return user;
    }

    @GetMapping("/movie/port")
    public String port() {
        String port = userApi.port();
        return port;
    }

    public User defaultStores(Long id) {
        User u = new User();
        u.setName("xxxxx");
        u.setAge(999);
        u.setUsername("yyyyyy");
        return u;
    }
}
