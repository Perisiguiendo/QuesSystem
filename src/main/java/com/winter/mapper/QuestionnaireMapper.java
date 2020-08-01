package com.winter.mapper;

import com.winter.model.Questionnaire_info;

import java.util.List;

//创建项目数据层接口
public interface QuestionnaireMapper {
    int insert(Questionnaire_info questionnaire);//save
    int delete(Integer id);//del
    public List<Questionnaire_info> findAllProject();//获取全部用户
    int modify(Questionnaire_info questionnaire);//
}
