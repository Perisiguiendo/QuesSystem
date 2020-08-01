package com.winter.service;

import com.winter.beans.ResultResponse;
import com.winter.model.Questionnaire_info_type;

import java.util.List;


public interface ProjectService {
    ResultResponse addProject(Questionnaire_info_type project);//保存 pro信息
    ResultResponse delProject(Questionnaire_info_type project);//删除pro信息
    public List<Questionnaire_info_type> findAllProject(); //

}
