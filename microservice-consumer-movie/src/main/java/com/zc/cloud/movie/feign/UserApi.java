package com.zc.cloud.movie.feign;

import com.zc.cloud.movie.feign.hystrix.UserHystrix;
import com.zc.cloud.movie.vo.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
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
@FeignClient(value = "user01",fallback=UserHystrix.class)
public interface UserApi {


    /**
     *
     * @param id
     * @return
     */
    //http://www.jb51.net/article/106950.htm
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    User getUser(@PathVariable("id") Long id);


    /**
     *
     * @return
     */
    @RequestMapping(value = "/port", method = RequestMethod.GET)
    String port();
}
