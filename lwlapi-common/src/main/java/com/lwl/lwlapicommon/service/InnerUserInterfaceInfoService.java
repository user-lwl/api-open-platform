package com.lwl.lwlapicommon.service;


/**
* @author user-lwl
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Service
* @createDate 2023-02-23 14:40:13
*/
public interface InnerUserInterfaceInfoService {

    /**
     * 调用统计接口
     * @param interfaceInfoId interfaceInfoId
     * @param userId UserId
     * @return boolean
     */
    boolean invokeCount(long interfaceInfoId, long userId);
}
