package com.zc.cloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 说明 . <br>
 * <p>
 * <p>
 * Copyright: Copyright (c) 2017/10/16 23:20
 * <p>
 * Company: 百趣
 * <p>
 *
 * @author zhongcheng_m@yeah.net
 * @version 1.0.0
 */
@SpringBootApplication
@EnableEurekaServer
public class MicrosecviceDiscoverEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicrosecviceDiscoverEurekaApplication.class,args);
    }
}
