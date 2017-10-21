package com.zc.cloud.movie.feign;

import com.zc.cloud.movie.vo.User;
import feign.hystrix.FallbackFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 说明 . <br>
 * <p>
 * <p>
 * Copyright: Copyright (c) 2017/10/18 下午2:00
 * <p>
 * Company: 百趣
 * <p>
 *
 * @author zhongcheng_m@yeah.net
 * @version 1.0.0
 */
@FeignClient(value = "microservice-provider-user", fallbackFactory = UserApiFallbackFactory.HystrixClientFallbackFactory.class)
public interface UserApiFallbackFactory {


    /**
     * @param id
     * @return
     */
    //http://www.jb51.net/article/106950.htm
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    User getUser(@PathVariable("id") Long id);


    /**
     * @return
     */
    @RequestMapping(value = "/port", method = RequestMethod.GET)
    String port();


    @Component
    class HystrixClientFallbackFactory implements FallbackFactory<UserApiFallbackFactory> {


        /**
         * 使用fallfactory可以捕获到 导致断路器开启的异常
         *
         * @param throwable
         * @return
         */
        @Override
        public UserApiFallbackFactory create(Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("抛异常");
            return new UserApiFallbackFactory() {

                @Override
                public User getUser(Long id) {
                    User u = new User();
                    u.setName("ppppppp");
                    u.setAge(666);
                    u.setUsername("ooooooo");
                    return u;
                }

                @Override
                public String port() {
                    return "4321";
                }
            };
        }
    }

    @Component
    class Fallback implements UserApiFallbackFactory {

        //断路器的线程默认是和主线程分开的,使用ThreadLocal的时候要注意,要想使统一线程,可在官方文档查询并且配置

        @Override
        public User getUser(Long id) {
            User u = new User();
            u.setName("ppppppp");
            u.setAge(888);
            u.setUsername("ooooooo");
            //在fallback内抛异常
            throw new RuntimeException();
            // return u;
        }

        @Override
        public String port() {
            return "1234";
        }
    }
}
