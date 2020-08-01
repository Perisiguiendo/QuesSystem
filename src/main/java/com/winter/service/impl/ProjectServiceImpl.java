package com.winter.service.impl;

import com.winter.beans.ResultResponse;
import com.winter.mapper.ProjectMapper;
import com.winter.model.Questionnaire_info_type;
import com.winter.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "projectService")

public class ProjectServiceImpl implements ProjectService{
    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public ResultResponse addProject(Questionnaire_info_type project) {
        System.out.println("addProject");
        int f=projectMapper.insert(project);
        System.out.println(project.getQuestionnaire_type());
        System.out.println("add ok");
        return null;
    }

    //获取
    public List<Questionnaire_info_type> findAllProject() {
        System.out.println("findAllProject");
        return projectMapper.findAllProject();
    }

    @Override
    public ResultResponse delProject(Questionnaire_info_type project) {
        System.out.println("delProject");
        System.out.println("num为："+project.getNum());
        int f=projectMapper.delete(project.getNum());
        System.out.println("del ok");
        return null;
    }

}
