package com.yingge.qa.service.impl;

import com.yingge.qa.entity.AnswerDO;
import com.yingge.qa.entity.AnswerDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * This class was generated by Ali-Generator
 * @author zhaoxiongy@163.com
 */
@Service
public class AnswerConverter {

    /**
     * DTO模型转换成DO模型
     * @param answerDTO
     */
    public AnswerDO convertFromDTO(AnswerDTO answerDTO) {
        AnswerDO answerDO = new AnswerDO();
        BeanUtils.copyProperties(answerDTO,answerDO);
        return answerDO;
    }

    /**
     * DO模型转换成DTO模型
     * @param answerDO
     */
    public AnswerDTO convertFromDO(AnswerDO answerDO) {
        AnswerDTO answerDTO = new AnswerDTO();
        BeanUtils.copyProperties(answerDO,answerDTO);
        return answerDTO;
    }
}