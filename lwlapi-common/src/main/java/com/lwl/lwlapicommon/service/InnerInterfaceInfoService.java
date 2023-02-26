package com.lwl.lwlapicommon.service;

import com.lwl.lwlapicommon.model.entity.InterfaceInfo;

/**
 *
 */
public interface InnerInterfaceInfoService {

    /**
     * 从数据库中查询模拟接口是否存在（请求路径、请求方法、请求参数）
     * @param url url
     * @param method method
     * @return InterfaceInfo
     */
    InterfaceInfo getInterfaceInfo(String url, String method);

}