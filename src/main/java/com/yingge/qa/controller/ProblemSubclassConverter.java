package com.yingge.qa.controller;

import com.yingge.qa.entity.ProblemSubclassDO;
import com.yingge.qa.entity.ProblemSubclassDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * This class was generated by Ali-Generator
 * @author zhaoxiongy@163.com
 */
@Service
public class ProblemSubclassConverter {

    /**
     * DTO模型转换成DO模型
     * @param problemSubclassDTO
     */
    public ProblemSubclassDO convertFromDTO(ProblemSubclassDTO problemSubclassDTO) {
        ProblemSubclassDO problemSubclassDO = new ProblemSubclassDO();
        BeanUtils.copyProperties(problemSubclassDTO,problemSubclassDO);
        return problemSubclassDO;
    }

    /**
     * DO模型转换成DTO模型
     * @param problemSubclassDO
     */
    public ProblemSubclassDTO convertFromDO(ProblemSubclassDO problemSubclassDO) {
        ProblemSubclassDTO problemSubclassDTO = new ProblemSubclassDTO();
        BeanUtils.copyProperties(problemSubclassDO,problemSubclassDTO);
        return problemSubclassDTO;
    }
}