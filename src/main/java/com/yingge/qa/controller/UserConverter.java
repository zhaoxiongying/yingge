package com.yingge.qa.controller;

import com.yingge.qa.entity.UserDO;
import com.yingge.qa.entity.UserDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * This class was generated by Ali-Generator
 * @author zhaoxiongy@163.com
 */
@Service
public class UserConverter {

    /**
     * DTO模型转换成DO模型
     * @param userDTO
     */
    public UserDO convertFromDTO(UserDTO userDTO) {
        UserDO userDO = new UserDO();
        BeanUtils.copyProperties(userDTO,userDO);
        return userDO;
    }

    /**
     * DO模型转换成DTO模型
     * @param userDO
     */
    public UserDTO convertFromDO(UserDO userDO) {
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(userDO,userDTO);
        return userDTO;
    }
}