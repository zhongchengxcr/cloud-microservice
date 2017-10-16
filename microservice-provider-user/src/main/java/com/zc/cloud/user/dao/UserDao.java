package com.zc.cloud.user.dao;

import com.zc.cloud.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 说明 . <br>
 * <p>
 * <p>
 * Copyright: Copyright (c) 2017/10/16 21:46
 * <p>
 * Company: 百趣
 * <p>
 *
 * @author zhongcheng_m@yeah.net
 * @version 1.0.0
 */
public interface UserDao extends JpaRepository<User, Long> {
}
