package com.lwl.project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lwl.lwlapicommon.model.entity.UserInterfaceInfo;

import java.util.List;

/**
* @author user-lwl
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Mapper
* @createDate 2023-02-23 14:40:13
*/
public interface UserInterfaceInfoMapper extends BaseMapper<UserInterfaceInfo> {

    // select interfaceInfoId, sum(totalNum) as totalNum from user_interface_info group by interfaceInfoId order by totalNum desc limit 3;
    List<UserInterfaceInfo> listTopInvokeInterfaceInfo(int limit);
}




