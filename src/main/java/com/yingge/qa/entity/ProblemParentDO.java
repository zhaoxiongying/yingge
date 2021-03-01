package com.yingge.qa.entity;

import java.util.Date;

/**
 *
 * @author zhaoxiongy@163.com
 */
public class ProblemParentDO {
    /**
     *
     *
     * @mbg.generated
     */
    private Long id;

    /**
     *
     *
     * @mbg.generated
     */
    private Date gmtCreate;

    /**
     *
     *
     * @mbg.generated
     */
    private Date gmtModified;

    /**
     * Database Column Remarks:
     *   问题分类
     *
     *
     * @mbg.generated
     */
    private String answerContent;

    /**
     *
     * @return the value of problem_parent.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id the value for problem_parent.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @return the value of problem_parent.gmt_create
     *
     * @mbg.generated
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     *
     * @param gmtCreate the value for problem_parent.gmt_create
     *
     * @mbg.generated
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     *
     * @return the value of problem_parent.gmt_modified
     *
     * @mbg.generated
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     *
     * @param gmtModified the value for problem_parent.gmt_modified
     *
     * @mbg.generated
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     *
     * @return the value of problem_parent.answer_content
     *
     * @mbg.generated
     */
    public String getAnswerContent() {
        return answerContent;
    }

    /**
     *
     * @param answerContent the value for problem_parent.answer_content
     *
     * @mbg.generated
     */
    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
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
        sb.append(", answerContent=").append(answerContent);
        sb.append("]");
        return sb.toString();
    }
}