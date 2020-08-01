package com.winter.controller;


import com.winter.mapper.ProjectMapper;
import com.winter.mapper.QuestionnaireMapper;
import com.winter.model.Questionnaire_info;
import com.winter.model.Questionnaire_info_type;
import com.winter.model.User;
import com.winter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private QuestionnaireMapper questionnaireMapper;

    @Autowired
    private ProjectMapper projectMapper;

    @RequestMapping(value = "/app")
    public String login(User user, Map<String, Object> map, Model model){
        System.out.println("返回值为"+userService.login(user));
        if(userService.login(user).equals("app")){
            List<Questionnaire_info> cums =  questionnaireMapper.findAllProject();
            List<Questionnaire_info_type> cums_type = projectMapper.findAllProject();
            System.out.println(cums);
            System.out.println(cums_type);
            model.addAttribute("cums", cums);
            model.addAttribute("cums_type", cums_type);
            System.out.println("test页面");
            return "app";
        }else if(userService.login(user) == "index"){
            System.out.println("输出错误提示");
            map.put("msg", "用户名或密码错误，请重新输入");
            return "index";
        }else {
            return userService.login(user);
        }
    }

    @RequestMapping("/toApp")
    public String login(Model model) {
        List<Questionnaire_info> cums = questionnaireMapper.findAllProject();
        List<Questionnaire_info_type> cums_type = projectMapper.findAllProject();
        System.out.println(cums);
        System.out.println(cums_type);
        model.addAttribute("cums", cums);
        model.addAttribute("cums_type", cums_type);
        System.out.println("test页面");
        return "app";
    }
}

