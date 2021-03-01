package com.yingge.qa.entity;

import java.util.Date;

/**
 *
 * @author zhaoxiongy@163.com
 */
public class RoleDO {
    /**
     * Database Column Remarks:
     *   编号
     *
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     * Database Column Remarks:
     *   创建时间
     *
     *
     * @mbg.generated
     */
    private Date gmtCreate;

    /**
     * Database Column Remarks:
     *   修改时间
     *
     *
     * @mbg.generated
     */
    private Date gmtModified;

    /**
     * Database Column Remarks:
     *   是否删除 1 删除 0未删除
     *
     *
     * @mbg.generated
     */
    private Byte isDelete;

    /**
     * Database Column Remarks:
     *   角色字母编号
     *
     *
     * @mbg.generated
     */
    private String roleCode;

    /**
     * Database Column Remarks:
     *   角色名称
     *
     *
     * @mbg.generated
     */
    private String roleName;

    /**
     * Database Column Remarks:
     *   描述
     *
     *
     * @mbg.generated
     */
    private String roleDesc;

    /**
     * Database Column Remarks:
     *   状态 1、正常 0、禁用
     *
     *
     * @mbg.generated
     */
    private Byte roleStatus;

    /**
     * Database Column Remarks:
     *   是否是超级管理员角色
     *
     *
     * @mbg.generated
     */
    private Byte isAdmin;

    /**
     *
     * @return the value of role.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id the value for role.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return the value of role.gmt_create
     *
     * @mbg.generated
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     *
     * @param gmtCreate the value for role.gmt_create
     *
     * @mbg.generated
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     *
     * @return the value of role.gmt_modified
     *
     * @mbg.generated
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     *
     * @param gmtModified the value for role.gmt_modified
     *
     * @mbg.generated
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     *
     * @return the value of role.is_delete
     *
     * @mbg.generated
     */
    public Byte getIsDelete() {
        return isDelete;
    }

    /**
     *
     * @param isDelete the value for role.is_delete
     *
     * @mbg.generated
     */
    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    /**
     *
     * @return the value of role.role_code
     *
     * @mbg.generated
     */
    public String getRoleCode() {
        return roleCode;
    }

    /**
     *
     * @param roleCode the value for role.role_code
     *
     * @mbg.generated
     */
    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    /**
     *
     * @return the value of role.role_name
     *
     * @mbg.generated
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     *
     * @param roleName the value for role.role_name
     *
     * @mbg.generated
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     *
     * @return the value of role.role_desc
     *
     * @mbg.generated
     */
    public String getRoleDesc() {
        return roleDesc;
    }

    /**
     *
     * @param roleDesc the value for role.role_desc
     *
     * @mbg.generated
     */
    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    /**
     *
     * @return the value of role.role_status
     *
     * @mbg.generated
     */
    public Byte getRoleStatus() {
        return roleStatus;
    }

    /**
     *
     * @param roleStatus the value for role.role_status
     *
     * @mbg.generated
     */
    public void setRoleStatus(Byte roleStatus) {
        this.roleStatus = roleStatus;
    }

    /**
     *
     * @return the value of role.is_admin
     *
     * @mbg.generated
     */
    public Byte getIsAdmin() {
        return isAdmin;
    }

    /**
     *
     * @param isAdmin the value for role.is_admin
     *
     * @mbg.generated
     */
    public void setIsAdmin(Byte isAdmin) {
        this.isAdmin = isAdmin;
    }

    /**
     * @return
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", roleCode=").append(roleCode);
        sb.append(", roleName=").append(roleName);
        sb.append(", roleDesc=").append(roleDesc);
        sb.append(", roleStatus=").append(roleStatus);
        sb.append(", isAdmin=").append(isAdmin);
        sb.append("]");
        return sb.toString();
    }
}