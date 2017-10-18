package com.zc.cloud.order.web;

import com.zc.cloud.order.feign.UserApi;
import com.zc.cloud.order.vo.Order;
import com.zc.cloud.order.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 说明 . <br>
 * <p>
 * <p>
 * Copyright: Copyright (c) 2017/10/18 下午4:52
 * <p>
 * Company: 百趣
 * <p>
 *
 * @author zhongcheng_m@yeah.net
 * @version 1.0.0
 */
@RestController
public class OrderController {

    @SuppressWarnings("all")
    @Autowired
    private UserApi userApi;

    //@HystrixCommand(fallbackMethod = "defaultStores")
    @GetMapping("/order/{id}")
    public Order order(@PathVariable Long id) {
        Order o = new Order();
        o.setGoodName("电脑");
        o.setOrderNo(12874683264L);
        o.setUserId(3L);
        return o;
    }

    @GetMapping("/order/port")
    public String port() {
        String port = userApi.port();
        return port;
    }

}
