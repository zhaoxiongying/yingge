package com.yingge.qa.controller;

import java.io.Serializable;

/**
 * This class was generated by Ali-Generator
 * @author zhaoxiongy@163.com
 */
public class RoleParameter implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *   编号
     */
    private Integer id;

    /**
     *   是否删除 1 删除 0未删除
     */
    private Byte isDelete;

    /**
     *   角色字母编号
     */
    private String roleCode;

    /**
     *   角色名称
     */
    private String roleName;

    /**
     *   描述
     */
    private String roleDesc;

    /**
     *   状态 1、正常 0、禁用
     */
    private Byte roleStatus;

    /**
     *   是否是超级管理员角色
     */
    private Byte isAdmin;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public Byte getRoleStatus() {
        return roleStatus;
    }

    public void setRoleStatus(Byte roleStatus) {
        this.roleStatus = roleStatus;
    }

    public Byte getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Byte isAdmin) {
        this.isAdmin = isAdmin;
    }
}