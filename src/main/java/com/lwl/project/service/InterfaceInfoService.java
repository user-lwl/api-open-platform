package com.lwl.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lwl.lwlapicommon.model.entity.InterfaceInfo;

/**
* @author user-lwl
* @description 针对表【interface_info(接口信息)】的数据库操作Service
* @createDate 2023-02-21 19:56:38
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {

    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);
}
