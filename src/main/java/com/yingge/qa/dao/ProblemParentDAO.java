package com.yingge.qa.dao;

import com.yingge.qa.entity.ProblemParentDO;
import com.yingge.qa.entity.ProblemParentParam;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * This class was generated by Ali-Generator
 * @author zhaoxiongy@163.com
 */
@Mapper
public interface ProblemParentDAO {
    /**
     * 根据WHERE条件COUNT
     * @param problemParentParam
     * @return
     *
     * @mbg.generated
     */
    long countByParam(ProblemParentParam problemParentParam);

    /**
     * 根据WHERE条件删除
     * @param problemParentParam
     * @return
     *
     * @mbg.generated
     */
    int deleteByParam(ProblemParentParam problemParentParam);

    /**
     * 根据主键删除
     * @param id
     * @return
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 插件单条记录
     * @param record
     * @return
     *
     * @mbg.generated
     */
    int insert(ProblemParentDO record);

    /**
     * 根据字段选择性插件单条记录
     * @param record
     * @return
     *
     * @mbg.generated
     */
    int insertSelective(ProblemParentDO record);

    /**
     * 根据WHERE条件查询，返回不包含长文本字段
     * @param problemParentParam
     * @return
     *
     * @mbg.generated
     */
    List<ProblemParentDO> selectByParam(ProblemParentParam problemParentParam);

    /**
     * 根据主键查询
     * @param id
     * @return
     *
     * @mbg.generated
     */
    ProblemParentDO selectByPrimaryKey(Long id);

    /**
     * 根据WHERE条件选择性更新
     * @param record
     * @param problemParentParam
     * @return
     *
     * @mbg.generated
     */
    int updateByParamSelective(@Param("record") ProblemParentDO record, @Param("problemParentParam") ProblemParentParam problemParentParam);

    /**
     * 根据WHERE条件更新，不更新长文本字段
     * @param record
     * @param problemParentParam
     * @return
     *
     * @mbg.generated
     */
    int updateByParam(@Param("record") ProblemParentDO record, @Param("problemParentParam") ProblemParentParam problemParentParam);

    /**
     * 根据主键选择性更新
     * @param record
     * @return
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(ProblemParentDO record);

    /**
     * 根据主键更新，不更新长文本字段
     * @param record
     * @return
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(ProblemParentDO record);

    /**
     * 批量插入
     * @param records
     * @return
     *
     * @mbg.generated
     */
    int batchInsert(List<ProblemParentDO> records);
}