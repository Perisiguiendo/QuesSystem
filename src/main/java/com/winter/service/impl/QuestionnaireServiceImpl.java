package com.winter.service.impl;

import com.winter.beans.ResultResponse;
import com.winter.mapper.QuestionnaireMapper;
import com.winter.model.Questionnaire_info;
import com.winter.service.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "questionnaireService")

public class QuestionnaireServiceImpl implements QuestionnaireService{
    @Autowired
    private QuestionnaireMapper questionnaireMapper;

    @Override
    public ResultResponse addQuestionnaire(Questionnaire_info questionnaire) {
        System.out.println("addQuestionnaire");
        int f=questionnaireMapper.insert(questionnaire);
        System.out.println("add ok");
        return null;
    }

    //获取
    public List<Questionnaire_info> findAllProject() {
        System.out.println("findAllProject");
        return questionnaireMapper.findAllProject();
    }

    @Override
    public ResultResponse delQue(Questionnaire_info questionnaire_info) {
        System.out.println("delProject");
        int f=questionnaireMapper.delete(questionnaire_info.getId());
        System.out.println("del ok");
        return null;
    }

    @Override
    public ResultResponse modifyQuestionnaire(Questionnaire_info questionnaire) {
        System.out.println("modifyQuestionnaire");
        int f=questionnaireMapper.modify(questionnaire);
        System.out.println("modify ok");
        return null;
    }
}
