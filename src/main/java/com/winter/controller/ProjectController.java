package com.winter.controller;

import com.winter.model.Questionnaire_info_type;
import com.winter.service.ProjectService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;

@Controller
@RequestMapping(value = "/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;//装载测试服务

    /**
     * 保存测试数据
     * @param projectname 项目名
     * @param creation_date 项目创建时间
     */
    @ResponseBody
    @RequestMapping(value = "/os",method = RequestMethod.POST,  produces = {"application/json;charset=UTF-8"})
    public void addProject(Integer num, String projectname, Timestamp creation_date){

        System.out.println("projectname"+projectname);

        Questionnaire_info_type project=new Questionnaire_info_type();
        //set值
        project.setNum(num);
        project.setQuestionnaire_type(projectname);
        project.setCreated_by("");
        project.setCreation_date(creation_date);
        project.setLast_update_date(creation_date);
        project.setLast_updated_by("");
        System.out.println(project.getQuestionnaire_type());//显示pro内容
        this.projectService.addProject(project);
    }
    @RequestMapping(value = "/del",method = RequestMethod.POST,  produces = {"application/json;charset=UTF-8"})
    public String delProject(String projectid) {
        System.out.println(projectid);
        Questionnaire_info_type project = new Questionnaire_info_type();
        //set值\
        Integer a = Integer.valueOf(projectid);
        project.setNum(a);
        System.out.println("start delete");//显示pro内容
        this.projectService.delProject(project);
        return "app";
    }
}
