package com.zc.cloud.order.feign;

import com.zc.cloud.order.feign.hystrix.UserHystrix;
import com.zc.cloud.order.vo.User;
import org.springframework.cloud.netflix.feign.FeignClient;
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
@FeignClient(value = "user01", fallback = UserHystrix.class)
public interface UserApi {


    /**
     * //http://www.jb51.net/article/106950.htm
     * @param id
     * @return
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    User getUser(@PathVariable("id") Long id);


    /**
     * 获取端口号
     * @return
     */
    @RequestMapping(value = "/port", method = RequestMethod.GET)
    String port();
}
