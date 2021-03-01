package com.yingge.qa.service.impl;

import com.yingge.qa.dao.ProblemParentDAO;
import com.yingge.qa.entity.ProblemParentDO;
import com.yingge.qa.entity.ProblemParentDTO;
import com.yingge.qa.entity.ProblemParentParam.Criteria;
import com.yingge.qa.entity.ProblemParentParam;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.yingge.qa.controller.ProblemParentConverter;
import com.yingge.qa.controller.ProblemParentParameter;
import com.yingge.qa.service.ProblemParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This class was generated by Ali-Generator
 * @author zhaoxiongy@163.com
 */
@Service
public class ProblemParentServiceImpl implements ProblemParentService {
    @Autowired
    private ProblemParentDAO problemParentDAO;

    @Autowired
    private ProblemParentConverter problemParentConverter;

    /**
     * 根据参数统计总数
     * @param param
     */
    @Override
    public long count(ProblemParentParameter param) {
        ProblemParentParam problemParentParam = new ProblemParentParam();
        Criteria criteria = problemParentParam.createCriteria();
        //TODO 注意：需要根据业务实际情况自行编写WHERE条件
        return problemParentDAO.countByParam(problemParentParam);
    }

    /**
     * 根据参数查询
     * @param param
     */
    @Override
    public ProblemParentDTO find(ProblemParentParameter param) {
        ProblemParentParam problemParentParam = new ProblemParentParam();
        Criteria criteria = problemParentParam.createCriteria();
        //TODO 注意：需要根据业务实际情况自行编写WHERE条件
        List<ProblemParentDO> list = problemParentDAO.selectByParam(problemParentParam);
        if (null == list || list.isEmpty()) {
                return null;
        }
        return problemParentConverter.convertFromDO(list.get(0));
    }

    /**
     * 列表查询
     * @param param
     */
    @Override
    public List<ProblemParentDTO> list(ProblemParentParameter param) {
        ProblemParentParam problemParentParam = new ProblemParentParam();
        Criteria criteria = problemParentParam.createCriteria();
        //TODO 注意：需要根据业务实际情况自行编写WHERE条件
        List<ProblemParentDO> list = problemParentDAO.selectByParam(problemParentParam);
        if (null == list || list.isEmpty()) {
                return null;
        }
        List<ProblemParentDTO> result = new ArrayList<>();
        for (ProblemParentDO record : list) {
            ProblemParentDTO problemParentDTO = problemParentConverter.convertFromDO(record);
                result.add(problemParentDTO);
        }
        return result;
    }

    /**
     * 创建
     * @param param
     */
    @Override
    public void create(ProblemParentParameter param) {
        ProblemParentDO record = new ProblemParentDO();
        record.setId(param.getId());
        record.setGmtCreate(new Date());
        record.setGmtModified(new Date());
        record.setAnswerContent(param.getAnswerContent());
        problemParentDAO.insert(record);
    }

    /**
     * 修改
     * @param dto
     * @param param
     */
    @Override
    public void updateSelective(ProblemParentDTO dto, ProblemParentParameter param) {
        ProblemParentDO record = problemParentConverter.convertFromDTO(dto);
        record.setGmtModified(new Date());
        ProblemParentParam problemParentParam = new ProblemParentParam();
        Criteria criteria = problemParentParam.createCriteria();
        //TODO 注意：需要根据业务实际情况自行编写WHERE条件
        problemParentDAO.updateByParamSelective(record, problemParentParam);
    }
}