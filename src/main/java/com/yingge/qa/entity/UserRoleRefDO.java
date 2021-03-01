package com.yingge.qa.entity;

import java.util.Date;

/**
 *
 * @author zhaoxiongy@163.com
 */
public class UserRoleRefDO {
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
     * Database Column Remarks:
     *   用户id
     *
     *
     * @mbg.generated
     */
    private Long userId;

    /**
     * Database Column Remarks:
     *   角色id
     *
     *
     * @mbg.generated
     */
    private Long roleId;

    /**
     *
     * @return the value of user_role_ref.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id the value for user_role_ref.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @return the value of user_role_ref.gmt_create
     *
     * @mbg.generated
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     *
     * @param gmtCreate the value for user_role_ref.gmt_create
     *
     * @mbg.generated
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     *
     * @return the value of user_role_ref.gmt_modified
     *
     * @mbg.generated
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     *
     * @param gmtModified the value for user_role_ref.gmt_modified
     *
     * @mbg.generated
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     *
     * @return the value of user_role_ref.is_delete
     *
     * @mbg.generated
     */
    public Byte getIsDelete() {
        return isDelete;
    }

    /**
     *
     * @param isDelete the value for user_role_ref.is_delete
     *
     * @mbg.generated
     */
    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    /**
     *
     * @return the value of user_role_ref.creator_id
     *
     * @mbg.generated
     */
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     *
     * @param creatorId the value for user_role_ref.creator_id
     *
     * @mbg.generated
     */
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     *
     * @return the value of user_role_ref.modifier_id
     *
     * @mbg.generated
     */
    public Long getModifierId() {
        return modifierId;
    }

    /**
     *
     * @param modifierId the value for user_role_ref.modifier_id
     *
     * @mbg.generated
     */
    public void setModifierId(Long modifierId) {
        this.modifierId = modifierId;
    }

    /**
     *
     * @return the value of user_role_ref.user_id
     *
     * @mbg.generated
     */
    public Long getUserId() {
        return userId;
    }

    /**
     *
     * @param userId the value for user_role_ref.user_id
     *
     * @mbg.generated
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     *
     * @return the value of user_role_ref.role_id
     *
     * @mbg.generated
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     *
     * @param roleId the value for user_role_ref.role_id
     *
     * @mbg.generated
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
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
        sb.append(", creatorId=").append(creatorId);
        sb.append(", modifierId=").append(modifierId);
        sb.append(", userId=").append(userId);
        sb.append(", roleId=").append(roleId);
        sb.append("]");
        return sb.toString();
    }
}