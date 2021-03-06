package com.yingge.qa.controller;

import com.yingge.qa.entity.UserRoleRefDO;
import com.yingge.qa.entity.UserRoleRefDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * This class was generated by Ali-Generator
 * @author zhaoxiongy@163.com
 */
@Service
public class UserRoleRefConverter {

    /**
     * DTO模型转换成DO模型
     * @param userRoleRefDTO
     */
    public UserRoleRefDO convertFromDTO(UserRoleRefDTO userRoleRefDTO) {
        UserRoleRefDO userRoleRefDO = new UserRoleRefDO();
        BeanUtils.copyProperties(userRoleRefDTO,userRoleRefDO);
        return userRoleRefDO;
    }

    /**
     * DO模型转换成DTO模型
     * @param userRoleRefDO
     */
    public UserRoleRefDTO convertFromDO(UserRoleRefDO userRoleRefDO) {
        UserRoleRefDTO userRoleRefDTO = new UserRoleRefDTO();
        BeanUtils.copyProperties(userRoleRefDO,userRoleRefDTO);
        return userRoleRefDTO;
    }
}