package com.yingge.qa.entity;

import java.util.Date;

/**
 *
 * @author zhaoxiongy@163.com
 */
public class UserDO {
    /**
     * Database Column Remarks:
     *   编号
     *
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * Database Column Remarks:
     *   是否是超级管理员
     *
     *
     * @mbg.generated
     */
    private Byte isAdmin;

    /**
     * Database Column Remarks:
     *   登录账号
     *
     *
     * @mbg.generated
     */
    private String loginName;

    /**
     * Database Column Remarks:
     *   密码
     *
     *
     * @mbg.generated
     */
    private String password;

    /**
     * Database Column Remarks:
     *   加密秘钥
     *
     *
     * @mbg.generated
     */
    private String secretKey;

    /**
     * Database Column Remarks:
     *   手机号
     *
     *
     * @mbg.generated
     */
    private String mobile;

    /**
     * Database Column Remarks:
     *   邮箱
     *
     *
     * @mbg.generated
     */
    private String email;

    /**
     * Database Column Remarks:
     *   性别
     *
     *
     * @mbg.generated
     */
    private String sex;

    /**
     * Database Column Remarks:
     *   状态: 1 正常 0禁用
     *
     *
     * @mbg.generated
     */
    private Byte userStatus;

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
     *   创建人
     *
     *
     * @mbg.generated
     */
    private Long creatorId;

    /**
     * Database Column Remarks:
     *   修改人
     *
     *
     * @mbg.generated
     */
    private Long modifierId;

    /**
     *
     * @return the value of user.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id the value for user.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @return the value of user.is_admin
     *
     * @mbg.generated
     */
    public Byte getIsAdmin() {
        return isAdmin;
    }

    /**
     *
     * @param isAdmin the value for user.is_admin
     *
     * @mbg.generated
     */
    public void setIsAdmin(Byte isAdmin) {
        this.isAdmin = isAdmin;
    }

    /**
     *
     * @return the value of user.login_name
     *
     * @mbg.generated
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     *
     * @param loginName the value for user.login_name
     *
     * @mbg.generated
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    /**
     *
     * @return the value of user.password
     *
     * @mbg.generated
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password the value for user.password
     *
     * @mbg.generated
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return the value of user.secret_key
     *
     * @mbg.generated
     */
    public String getSecretKey() {
        return secretKey;
    }

    /**
     *
     * @param secretKey the value for user.secret_key
     *
     * @mbg.generated
     */
    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    /**
     *
     * @return the value of user.mobile
     *
     * @mbg.generated
     */
    public String getMobile() {
        return mobile;
    }

    /**
     *
     * @param mobile the value for user.mobile
     *
     * @mbg.generated
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     *
     * @return the value of user.email
     *
     * @mbg.generated
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email the value for user.email
     *
     * @mbg.generated
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return the value of user.sex
     *
     * @mbg.generated
     */
    public String getSex() {
        return sex;
    }

    /**
     *
     * @param sex the value for user.sex
     *
     * @mbg.generated
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     *
     * @return the value of user.user_status
     *
     * @mbg.generated
     */
    public Byte getUserStatus() {
        return userStatus;
    }

    /**
     *
     * @param userStatus the value for user.user_status
     *
     * @mbg.generated
     */
    public void setUserStatus(Byte userStatus) {
        this.userStatus = userStatus;
    }

    /**
     *
     * @return the value of user.gmt_create
     *
     * @mbg.generated
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     *
     * @param gmtCreate the value for user.gmt_create
     *
     * @mbg.generated
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     *
     * @return the value of user.gmt_modified
     *
     * @mbg.generated
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     *
     * @param gmtModified the value for user.gmt_modified
     *
     * @mbg.generated
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     *
     * @return the value of user.is_delete
     *
     * @mbg.generated
     */
    public Byte getIsDelete() {
        return isDelete;
    }

    /**
     *
     * @param isDelete the value for user.is_delete
     *
     * @mbg.generated
     */
    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    /**
     *
     * @return the value of user.creator_id
     *
     * @mbg.generated
     */
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     *
     * @param creatorId the value for user.creator_id
     *
     * @mbg.generated
     */
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     *
     * @return the value of user.modifier_id
     *
     * @mbg.generated
     */
    public Long getModifierId() {
        return modifierId;
    }

    /**
     *
     * @param modifierId the value for user.modifier_id
     *
     * @mbg.generated
     */
    public void setModifierId(Long modifierId) {
        this.modifierId = modifierId;
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
        sb.append(", isAdmin=").append(isAdmin);
        sb.append(", loginName=").append(loginName);
        sb.append(", password=").append(password);
        sb.append(", secretKey=").append(secretKey);
        sb.append(", mobile=").append(mobile);
        sb.append(", email=").append(email);
        sb.append(", sex=").append(sex);
        sb.append(", userStatus=").append(userStatus);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", creatorId=").append(creatorId);
        sb.append(", modifierId=").append(modifierId);
        sb.append("]");
        return sb.toString();
    }
}