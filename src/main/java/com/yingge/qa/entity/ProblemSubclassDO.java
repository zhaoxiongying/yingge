package com.yingge.qa.entity;

import java.util.Date;

/**
 *
 * @author zhaoxiongy@163.com
 */
public class ProblemSubclassDO {
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
     *   分类名称
     *
     *
     * @mbg.generated
     */
    private String classificationName;

    /**
     * Database Column Remarks:
     *   子类名称
     *
     *
     * @mbg.generated
     */
    private String subclassName;

    /**
     * Database Column Remarks:
     *   父类id
     *
     *
     * @mbg.generated
     */
    private Long respondent;

    /**
     *
     * @return the value of problem_subclass.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id the value for problem_subclass.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @return the value of problem_subclass.gmt_create
     *
     * @mbg.generated
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     *
     * @param gmtCreate the value for problem_subclass.gmt_create
     *
     * @mbg.generated
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     *
     * @return the value of problem_subclass.gmt_modified
     *
     * @mbg.generated
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     *
     * @param gmtModified the value for problem_subclass.gmt_modified
     *
     * @mbg.generated
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     *
     * @return the value of problem_subclass.classification_name
     *
     * @mbg.generated
     */
    public String getClassificationName() {
        return classificationName;
    }

    /**
     *
     * @param classificationName the value for problem_subclass.classification_name
     *
     * @mbg.generated
     */
    public void setClassificationName(String classificationName) {
        this.classificationName = classificationName;
    }

    /**
     *
     * @return the value of problem_subclass.subclass_name
     *
     * @mbg.generated
     */
    public String getSubclassName() {
        return subclassName;
    }

    /**
     *
     * @param subclassName the value for problem_subclass.subclass_name
     *
     * @mbg.generated
     */
    public void setSubclassName(String subclassName) {
        this.subclassName = subclassName;
    }

    /**
     *
     * @return the value of problem_subclass.respondent
     *
     * @mbg.generated
     */
    public Long getRespondent() {
        return respondent;
    }

    /**
     *
     * @param respondent the value for problem_subclass.respondent
     *
     * @mbg.generated
     */
    public void setRespondent(Long respondent) {
        this.respondent = respondent;
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
        sb.append(", classificationName=").append(classificationName);
        sb.append(", subclassName=").append(subclassName);
        sb.append(", respondent=").append(respondent);
        sb.append("]");
        return sb.toString();
    }
}