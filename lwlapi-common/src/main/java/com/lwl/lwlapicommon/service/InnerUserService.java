package com.lwl.lwlapicommon.service;

import com.lwl.lwlapicommon.model.entity.User;

/**
 * 用户服务
 *
 * @author yupi
 */
public interface InnerUserService {

    /**
     * 数据库中查是否已分配给用户秘钥（accessKey）
     * @param accessKey accessKey
     * @return User
     */
    User getInvokeUser(String accessKey);
}
