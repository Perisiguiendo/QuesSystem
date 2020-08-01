package com.winter.mapper;

import com.winter.model.Questionnaire_info_type;

import java.util.List;

//创建项目数据层接口
public interface ProjectMapper {
    int insert(Questionnaire_info_type project);//save
    int delete(Integer id);//del
    public List<Questionnaire_info_type> findAllProject();//获取全部用户
}
