package com.winter.service;

import com.winter.beans.ResultResponse;
import com.winter.model.Questionnaire_info;

import java.util.List;


public interface QuestionnaireService {
    ResultResponse addQuestionnaire(Questionnaire_info questionnaire);//保存 pro信息
    public List<Questionnaire_info> findAllProject(); //
    ResultResponse delQue(Questionnaire_info questionnaire_info);//删除pro信息
    ResultResponse modifyQuestionnaire(Questionnaire_info questionnaire);//保存 pro信息
}
