package com.lwl.project.service.impl;

import cn.hutool.system.UserInfo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lwl.lwlapicommon.model.entity.UserInterfaceInfo;
import com.lwl.project.common.ErrorCode;
import com.lwl.project.exception.BusinessException;
import com.lwl.project.mapper.UserInterfaceInfoMapper;
import com.lwl.project.service.UserInterfaceInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author user-lwl
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Service实现
* @createDate 2023-02-23 14:40:13
*/
@Service
public class UserInterfaceInfoServiceImpl extends ServiceImpl<UserInterfaceInfoMapper, UserInterfaceInfo>
    implements UserInterfaceInfoService {

    @Override
    public void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add) {
        if (userInterfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 创建时，所有参数必须非空
        if (add) {
            if (userInterfaceInfo.getInterfaceInfoId() <= 0 || userInterfaceInfo.getUserId() <= 0) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR, "接口或用户不存在");
            }
        }
        if (userInterfaceInfo.getLeftNum() < 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "剩余次数不能小于 0");
        }

    }

    /**
     * 调用统计接口
     * @param interfaceInfoId interfaceInfoId
     * @param userId UserId
     * @return boolean
     */
    @Override
    public boolean invokeCount(long interfaceInfoId, long userId) {
        if (interfaceInfoId <= 0 || userId <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        QueryWrapper<UserInterfaceInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("interfaceInfoId", interfaceInfoId);
        queryWrapper.eq("userId", userId);
        List<UserInterfaceInfo> list = this.list(queryWrapper);
        if (list.isEmpty()) {
            UserInterfaceInfo userInterfaceInfo = new UserInterfaceInfo();
            userInterfaceInfo.setInterfaceInfoId(interfaceInfoId);
            userInterfaceInfo.setUserId(userId);
            userInterfaceInfo.setTotalNum(0);
            userInterfaceInfo.setLeftNum(1000);// 免费调用次数
            this.save(userInterfaceInfo);
        }
        UpdateWrapper<UserInterfaceInfo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("interfaceInfoId", interfaceInfoId);
        updateWrapper.eq("userId", userId);
//        updateWrapper.gt("leftNum", 0);
        updateWrapper.setSql("leftNum = leftNum - 1, totalNum = totalNum + 1");
        return this.update(updateWrapper);
    }
}




