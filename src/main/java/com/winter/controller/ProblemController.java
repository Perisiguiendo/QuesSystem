package com.winter.controller;

import com.winter.model.Answer;
import com.winter.model.Problem_info;
import com.winter.service.AnswerService;
import com.winter.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/problem")
public class ProblemController {
    @Autowired
    private ProblemService problemService;//装载测试服务

    @Autowired
    private AnswerService answerService;

    @ResponseBody
    @RequestMapping(value = "/add",method = RequestMethod.POST,  produces = {"application/json;charset=UTF-8"})
    public void addProblem(Integer kind_id, Integer questionnaire_id, String problem_name, Timestamp creation_date, Integer pos, String str){
        System.out.println("kind_id:" +kind_id);
        System.out.println("questionnaire_id: " + questionnaire_id);
        System.out.println("problem_name: "+problem_name);
        System.out.println("creation_date: "+creation_date);
//        System.out.println("last_update_date: "+last_update_date);
        System.out.println("pos:" +pos);
        System.out.println("str: "+str);

        System.out.println("处理后的各选项为：");
        String[] strArray=str.split("@");
        for (int i = 0; i < strArray.length; i++){
            System.out.println(strArray[i]);
        }

        Problem_info problem=new Problem_info();
        problem.setKind_id(kind_id);
        problem.setQuestionnaire_id(questionnaire_id);
        problem.setProblem_name(problem_name);
        problem.setCreation_date(creation_date);
//        problem.setLast_update_date("");
        problem.setPos(pos);
        System.out.println("传值成功");
        problem = this.problemService.findProblem(problem);
        System.out.println("find成功");
        if (problem!=null){
            System.out.println("已存在，只更新");
            System.out.println("查找到的id为："+problem.getId());
            Problem_info modifypro=new Problem_info();
            modifypro.setId(problem.getId());
            modifypro.setProblem_name(problem_name);
            this.problemService.modifyProblem(modifypro);
            System.out.println("更改成功");

            System.out.println("首先先删除以前的选项");
            Answer ans = new Answer();
            ans.setPro_id(problem.getId());
            this.answerService.delAnswer(ans);

            System.out.println("再开始添加选项");
            for (int i=0;i<strArray.length;i++){
                Answer answer = new Answer();
                answer.setPro_id(problem.getId());
                answer.setAnswer_name(strArray[i]);
                this.answerService.addAnswer(answer);
            }
            System.out.println("添加成功");

        }else{
            System.out.println("不存在，添加");
            Problem_info addpro=new Problem_info();
            addpro.setKind_id(kind_id);
            addpro.setQuestionnaire_id(questionnaire_id);
            addpro.setProblem_name(problem_name);
            addpro.setCreation_date(creation_date);
//        problem.setLast_update_date("");
            addpro.setPos(pos);
            this.problemService.addProblem(addpro);
            Problem_info tem =new Problem_info();
            tem = this.problemService.findProblem(addpro);
            System.out.println("添加成功");

            System.out.println("开始添加选项");
            for (int i=0;i<strArray.length;i++){
                Answer answer = new Answer();
                answer.setPro_id(tem.getId());
                answer.setAnswer_name(strArray[i]);
                this.answerService.addAnswer(answer);
            }
            System.out.println("添加成功");
        }
    }


    @ResponseBody
    @RequestMapping(value = "/up",method = RequestMethod.POST,  produces = {"application/json;charset=UTF-8"})
    public void upProblem(Integer questionnaire_id, Integer pos) {
        System.out.println("questionnaire_id: " + questionnaire_id);
        System.out.println("更改之后的位置为：" + pos);
        System.out.println("更改之前的位置为：" + (pos+1));

        //上移的找到更改位置之前的位置
        Problem_info problem = new Problem_info();
        problem.setQuestionnaire_id(questionnaire_id);
        problem.setPos(pos+1);
        problem = this.problemService.findProblem(problem);
        System.out.println("搜索要上移的题目的id："+problem.getId());

        //下移的找到更改位置之前的位置
        Problem_info pro = new Problem_info();
        pro.setQuestionnaire_id(questionnaire_id);
        pro.setPos(pos);
        pro = this.problemService.findProblem(pro);
        System.out.println("搜索要下移的题目的id："+pro.getId());

        //通过id和questionnaire_id
        Problem_info upProblem = new Problem_info();
        upProblem.setId(problem.getId());
        upProblem.setPos(pos);
        this.problemService.upProblem(upProblem);
        System.out.println("更改要上移的题目的位置成功");

        Problem_info downProblem = new Problem_info();
        downProblem.setId(pro.getId());
        downProblem.setPos(pos+1);
        this.problemService.upProblem(downProblem);
        System.out.println("更改因上移要下移的题目的位置成功");
        System.out.println("上移成功");
    }

    @ResponseBody
    @RequestMapping(value = "/down",method = RequestMethod.POST,  produces = {"application/json;charset=UTF-8"})
    public void downProblem(Integer questionnaire_id, Integer pos) {
        System.out.println("questionnaire_id: " + questionnaire_id);
        System.out.println("更改之后的位置为：" + pos);
        System.out.println("更改之前的位置为：" + (pos-1));

        //上移的找到更改位置之前的位置
        Problem_info problem = new Problem_info();
        problem.setQuestionnaire_id(questionnaire_id);
        problem.setPos(pos-1);
        problem = this.problemService.findProblem(problem);
        System.out.println("搜索要下移的题目的id："+problem.getId());

        //下移的找到更改位置之前的位置
        Problem_info pro = new Problem_info();
        pro.setQuestionnaire_id(questionnaire_id);
        pro.setPos(pos);
        pro = this.problemService.findProblem(pro);
        System.out.println("搜索要上移的题目的id："+pro.getId());

        //通过id和questionnaire_id
        Problem_info upProblem = new Problem_info();
        upProblem.setId(problem.getId());
        upProblem.setPos(pos);
        this.problemService.upProblem(upProblem);
        System.out.println("更改要下移的题目的位置成功");

        Problem_info downProblem = new Problem_info();
        downProblem.setId(pro.getId());
        downProblem.setPos(pos-1);
        this.problemService.upProblem(downProblem);
        System.out.println("更改因下移要上移的题目的位置成功");
        System.out.println("下移成功");
    }

    @ResponseBody
    @RequestMapping(value = "/top",method = RequestMethod.POST,  produces = {"application/json;charset=UTF-8"})
    public void topProblem(Integer questionnaire_id, Integer pos) {
        System.out.println("questionnaire_id: " + questionnaire_id);
        System.out.println("目前所在位置为：" + pos);

        Problem_info problem = new Problem_info();
        problem.setQuestionnaire_id(questionnaire_id);
        problem.setPos(pos);
        problem = this.problemService.findProblem(problem);
        System.out.println("顶部的题目id为："+problem.getId());

        List<Problem_info> list = new ArrayList<Problem_info>();
        list = this.problemService.findAllProblem();

        for(int i=0;i<list.size();i++){
            if((list.get(i).getQuestionnaire_id() == questionnaire_id)&&(list.get(i).getPos()<problem.getPos())){
                Problem_info temp = new Problem_info();
                temp.setId(list.get(i).getId());
                temp.setPos(list.get(i).getPos()+1);
                this.problemService.upProblem(temp);
            }
        }

        problem.setPos(1);
        this.problemService.upProblem(problem);
        System.out.println("置顶成功");
    }

    @ResponseBody
    @RequestMapping(value = "/bottom",method = RequestMethod.POST,  produces = {"application/json;charset=UTF-8"})
    public void bottomProblem(Integer questionnaire_id, Integer pos, Integer length) {
        System.out.println("questionnaire_id: " + questionnaire_id);
        System.out.println("目前所在位置为：" + pos);
        System.out.println("len：" + length);

        Problem_info problem = new Problem_info();
        problem.setQuestionnaire_id(questionnaire_id);
        problem.setPos(pos);
        problem = this.problemService.findProblem(problem);
        System.out.println("当前题目id为："+problem.getId());

        List<Problem_info> list_btm = new ArrayList<Problem_info>();
        list_btm = this.problemService.findAllProblem();

        for(int i=0;i<list_btm.size();i++){
            if((list_btm.get(i).getQuestionnaire_id() == questionnaire_id)&&(list_btm.get(i).getPos()>problem.getPos())){
                Problem_info temp = new Problem_info();
                temp.setId(list_btm.get(i).getId());
                temp.setPos(list_btm.get(i).getPos()-1);
                this.problemService.upProblem(temp);
            }
        }

        problem.setPos(length);
        this.problemService.upProblem(problem);
        System.out.println("置底成功");
    }

    @ResponseBody
    @RequestMapping(value = "/del",method = RequestMethod.POST,  produces = {"application/json;charset=UTF-8"})
    public void delProblem(Integer questionnaire_id, Integer pos) {
        System.out.println("questionnaire_id: " + questionnaire_id);
        System.out.println("目前所在位置为：" + pos);

        Problem_info problem = new Problem_info();
        problem.setQuestionnaire_id(questionnaire_id);
        problem.setPos(pos);
        problem = this.problemService.findProblem(problem);
        System.out.println("当前题目id为："+problem.getId());

        List<Problem_info> list_btm = new ArrayList<Problem_info>();
        list_btm = this.problemService.findAllProblem();

        for(int i=0;i<list_btm.size();i++){
            if((list_btm.get(i).getQuestionnaire_id() == questionnaire_id)&&(list_btm.get(i).getPos()>problem.getPos())){
                Problem_info temp = new Problem_info();
                temp.setId(list_btm.get(i).getId());
                temp.setPos(list_btm.get(i).getPos()-1);
                this.problemService.upProblem(temp);
            }
        }
        this.problemService.delProblem(problem);
        System.out.println("删除成功");
    }
}
