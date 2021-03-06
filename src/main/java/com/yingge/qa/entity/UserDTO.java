package com.yingge.qa.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * This class was generated by Ali-Generator
 * @author zhaoxiongy@163.com
 */
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *   编号
     */
    private Long id;

    /**
     *   是否是超级管理员
     */
    private Byte isAdmin;

    /**
     *   登录账号
     */
    private String loginName;

    /**
     *   密码
     */
    private String password;

    /**
     *   加密秘钥
     */
    private String secretKey;

    /**
     *   手机号
     */
    private String mobile;

    /**
     *   邮箱
     */
    private String email;

    /**
     *   性别
     */
    private String sex;

    /**
     *   状态: 1 正常 0禁用
     */
    private Byte userStatus;

    /**
     *   创建时间
     */
    private Date gmtCreate;

    /**
     *   修改时间
     */
    private Date gmtModified;

    /**
     *   是否删除 1 删除 0未删除
     */
    private Byte isDelete;

    /**
     *   创建人
     */
    private Long creatorId;

    /**
     *   修改人
     */
    private Long modifierId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Byte getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Byte isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Byte getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Byte userStatus) {
        this.userStatus = userStatus;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public Long getModifierId() {
        return modifierId;
    }

    public void setModifierId(Long modifierId) {
        this.modifierId = modifierId;
    }
}