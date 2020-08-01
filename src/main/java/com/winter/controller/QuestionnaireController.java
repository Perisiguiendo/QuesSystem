package com.winter.controller;

import com.winter.mapper.QuestionnaireMapper;
import com.winter.model.Answer;
import com.winter.model.Problem_info;
import com.winter.model.Questionnaire_info;
import com.winter.service.AnswerService;
import com.winter.service.ProblemService;
import com.winter.service.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.Problem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.List;

@Controller
@RequestMapping(value = "/questionnaire")
public class QuestionnaireController {
    @Autowired
    private QuestionnaireService questionnaireService;//装载测试服务

    @Autowired
    private QuestionnaireMapper questionnaireMapper;

    @Autowired
    private AnswerService answerService;

    @Autowired
    private ProblemService problemService;

    /**
     * 保存测试数据
     * @param questionnaire_type 所属项目名
     * @param questionnaire_name 问卷名
     * @param questionnaire_content 问卷描述
     * @param creation_date 项目创建时间
     */
    @ResponseBody
    @RequestMapping(value = "/os",method = RequestMethod.POST,  produces = {"application/json;charset=UTF-8"})
    public void addQuestionnaire(Integer questionnaire_type, String proj_name, String questionnaire_name, String questionnaire_content, Timestamp creation_date, Timestamp last_update_date){

        System.out.println("questionnaire_type: "+questionnaire_type);
        System.out.println("poj_name: " + proj_name);
        System.out.println("questionnaire_name: "+questionnaire_name);
        System.out.println("questionnaire_content: "+questionnaire_content);
        System.out.println("creation_date: "+creation_date);
        System.out.println("last_update_date: "+last_update_date);

        Questionnaire_info questionnaire=new Questionnaire_info();
        questionnaire.setQuestionnaire_type(questionnaire_type);
        questionnaire.setProj_name(proj_name);
        questionnaire.setQuestionnaire_name(questionnaire_name);
        questionnaire.setQuestionnaire_content(questionnaire_content);
        questionnaire.setCreation_date(creation_date);
        questionnaire.setLast_update_date(last_update_date);
        this.questionnaireService.addQuestionnaire(questionnaire);
    }

    @RequestMapping(value = "/del",method = RequestMethod.POST,  produces = {"application/json;charset=UTF-8"})
    public String delQuestionnaire(String queid) {
        System.out.println(queid);
        Questionnaire_info questionnaire_info = new Questionnaire_info();
        Integer a = Integer.valueOf(queid);
        questionnaire_info.setId(a);
        this.questionnaireService.delQue(questionnaire_info);
        return "app";
    }

    @RequestMapping(value = "/edit")
    public String editQuestionnaire(String queid, Model model) {
        System.out.println("点击的问卷id为："+queid);
        List<Questionnaire_info> que =  questionnaireMapper.findAllProject();
        System.out.println("投影得到的结果为："+que);
        model.addAttribute("que", que);
        model.addAttribute("id", queid);
        //找到该问卷的题目
        List<Problem_info> problems = this.problemService.findAllProblem();
        model.addAttribute("problems", problems);
        //找到该问卷题目的选项
        List<Answer> answer = this.answerService.findAnswer();
        model.addAttribute("answer", answer);
        System.out.println("find ok");
        return "ques";
    }

    @RequestMapping(value = "/view")
    public String viewQuestionnaire(String queid, Model model) {
        System.out.println("点击的问卷id为："+queid);
        List<Questionnaire_info> que =  questionnaireMapper.findAllProject();
        System.out.println("投影得到的结果为："+que);
        model.addAttribute("que", que);
        model.addAttribute("id", queid);
        //找到该问卷的题目
        List<Problem_info> problems = this.problemService.findAllProblem();
        model.addAttribute("problems", problems);
        //找到该问卷题目的选项
        List<Answer> answer = this.answerService.findAnswer();
        model.addAttribute("answer", answer);
        System.out.println("find ok");
        return "preview";
    }

    @RequestMapping(value = "/modify")
    public String modifyQuestionnaire(String id, String questionnaire_name, String questionnaire_content){
        System.out.println("id: "+id);
        System.out.println("questionnaire_name: "+questionnaire_name);
        System.out.println("questionnaire_content: "+questionnaire_content);

        Questionnaire_info questionnaire=new Questionnaire_info();
        Integer b = Integer.valueOf(id);
        questionnaire.setId(b);
        questionnaire.setQuestionnaire_name(questionnaire_name);
        questionnaire.setQuestionnaire_content(questionnaire_content);
        this.questionnaireService.modifyQuestionnaire(questionnaire);
        return "ques";
    }
}