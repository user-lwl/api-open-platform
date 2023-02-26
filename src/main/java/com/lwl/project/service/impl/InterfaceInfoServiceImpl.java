package com.lwl.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lwl.lwlapicommon.model.entity.InterfaceInfo;
import com.lwl.project.common.ErrorCode;
import com.lwl.project.exception.BusinessException;
import com.lwl.project.mapper.InterfaceInfoMapper;
import com.lwl.project.service.InterfaceInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
* @author user-lwl
* @description 针对表【interface_info(接口信息)】的数据库操作Service实现
* @createDate 2023-02-21 19:56:38
*/
@Service
public class InterfaceInfoServiceImpl extends ServiceImpl<InterfaceInfoMapper, InterfaceInfo>
    implements InterfaceInfoService {

    @Override
    public void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add) {
        if (interfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        String name = interfaceInfo.getName();
        // 创建时，所有参数必须非空
        if (add) {
            if (StringUtils.isAnyBlank(name)) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR);
            }
        }
        if (StringUtils.isNotBlank(name) && name.length() > 50) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "名称过长");
        }

    }
}




