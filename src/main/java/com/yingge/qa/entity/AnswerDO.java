package com.yingge.qa.entity;

import java.util.Date;

/**
 *
 * @author zhaoxiongy@163.com
 */
public class AnswerDO {
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
     *   答案内容
     *
     *
     * @mbg.generated
     */
    private String answerContent;

    /**
     * Database Column Remarks:
     *   问题编号
     *
     *
     * @mbg.generated
     */
    private Long problemId;

    /**
     * Database Column Remarks:
     *   回答者
     *
     *
     * @mbg.generated
     */
    private String respondent;

    /**
     * Database Column Remarks:
     *   回答时间
     *
     *
     * @mbg.generated
     */
    private String answerTime;

    /**
     * Database Column Remarks:
     *   提问者评论好评次数
     *
     *
     * @mbg.generated
     */
    private String count;

    /**
     *
     * @return the value of answer.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id the value for answer.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @return the value of answer.gmt_create
     *
     * @mbg.generated
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     *
     * @param gmtCreate the value for answer.gmt_create
     *
     * @mbg.generated
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     *
     * @return the value of answer.gmt_modified
     *
     * @mbg.generated
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     *
     * @param gmtModified the value for answer.gmt_modified
     *
     * @mbg.generated
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     *
     * @return the value of answer.answer_content
     *
     * @mbg.generated
     */
    public String getAnswerContent() {
        return answerContent;
    }

    /**
     *
     * @param answerContent the value for answer.answer_content
     *
     * @mbg.generated
     */
    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

    /**
     *
     * @return the value of answer.problem_id
     *
     * @mbg.generated
     */
    public Long getProblemId() {
        return problemId;
    }

    /**
     *
     * @param problemId the value for answer.problem_id
     *
     * @mbg.generated
     */
    public void setProblemId(Long problemId) {
        this.problemId = problemId;
    }

    /**
     *
     * @return the value of answer.respondent
     *
     * @mbg.generated
     */
    public String getRespondent() {
        return respondent;
    }

    /**
     *
     * @param respondent the value for answer.respondent
     *
     * @mbg.generated
     */
    public void setRespondent(String respondent) {
        this.respondent = respondent;
    }

    /**
     *
     * @return the value of answer.answer_time
     *
     * @mbg.generated
     */
    public String getAnswerTime() {
        return answerTime;
    }

    /**
     *
     * @param answerTime the value for answer.answer_time
     *
     * @mbg.generated
     */
    public void setAnswerTime(String answerTime) {
        this.answerTime = answerTime;
    }

    /**
     *
     * @return the value of answer.count
     *
     * @mbg.generated
     */
    public String getCount() {
        return count;
    }

    /**
     *
     * @param count the value for answer.count
     *
     * @mbg.generated
     */
    public void setCount(String count) {
        this.count = count;
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
        sb.append(", problemId=").append(problemId);
        sb.append(", respondent=").append(respondent);
        sb.append(", answerTime=").append(answerTime);
        sb.append(", count=").append(count);
        sb.append("]");
        return sb.toString();
    }
}