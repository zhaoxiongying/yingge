package com.yingge.qa.controller;

import java.util.List;

import com.yingge.qa.entity.ProblemParentDTO;
import com.yingge.qa.service.ProblemParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class was generated by Ali-Generator
 * @author zhaoxiongy@163.com
 */
@RestController
@RequestMapping(value = "/ProblemParent")
public class ProblemParentController {
    @Autowired
    private ProblemParentService problemParentService;

    /**
     * 根据参数查找
     */
    @ResponseBody
    @GetMapping("/find")
    public ProblemParentDTO find(@RequestParam(required = false) Long id, @RequestParam(required = false) String answerContent) {
        ProblemParentParameter param = new ProblemParentParameter();
        param.setId(id);
        param.setAnswerContent(answerContent);
        return problemParentService.find(param);
    }

    /**
     * 列表查询
     */
    @ResponseBody
    @GetMapping("/list")
    public List<ProblemParentDTO> list(@RequestParam(required = false) Long id, @RequestParam(required = false) String answerContent) {
        ProblemParentParameter param = new ProblemParentParameter();
        param.setId(id);
        param.setAnswerContent(answerContent);
        return problemParentService.list(param);
    }

    /**
     * 创建
     */
    @RequestMapping("/create")
    public void create(@RequestParam(required = false) Long id, @RequestParam(required = false) String answerContent) {
        ProblemParentParameter param = new ProblemParentParameter();
        param.setId(id);
        param.setAnswerContent(answerContent);
        problemParentService.create(param);
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public void updateSelective(@RequestParam(required = false) Long id, @RequestParam(required = false) String answerContent) {
        ProblemParentDTO dto = new ProblemParentDTO();
        dto.setId(id);
        dto.setAnswerContent(answerContent);
        ProblemParentParameter param = new ProblemParentParameter();
        param.setId(id);
        param.setAnswerContent(answerContent);
        problemParentService.updateSelective(dto, param);
    }
}