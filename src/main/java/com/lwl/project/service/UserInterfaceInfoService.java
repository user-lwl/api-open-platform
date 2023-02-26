package com.lwl.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lwl.lwlapicommon.model.entity.UserInterfaceInfo;

/**
* @author user-lwl
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Service
* @createDate 2023-02-23 14:40:13
*/
public interface UserInterfaceInfoService extends IService<UserInterfaceInfo> {

    void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add);

    /**
     * 调用统计接口
     * @param interfaceInfoId interfaceInfoId
     * @param userId UserId
     * @return boolean
     */
    boolean invokeCount(long interfaceInfoId, long userId);
}
