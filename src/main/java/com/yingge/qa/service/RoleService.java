package com.yingge.qa.service;

import java.util.List;

import com.yingge.qa.controller.RoleParameter;
import com.yingge.qa.entity.RoleDTO;

/**
 * This class was generated by Ali-Generator
 * @author zhaoxiongy@163.com
 */
public interface RoleService {
    /**
     * 根据参数统计总数
     * @param param
     */
    long count(RoleParameter param);

    /**
     * 根据参数查询
     * @param param
     */
    RoleDTO find(RoleParameter param);

    /**
     * 列表查询
     * @param param
     */
    List<RoleDTO> list(RoleParameter param);

    /**
     * 创建
     * @param param
     */
    void create(RoleParameter param);

    /**
     * 选择性修改
     * @param dto
     * @param param
     */
    void updateSelective(RoleDTO dto, RoleParameter param);
}