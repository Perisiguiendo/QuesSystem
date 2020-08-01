package com.winter.service.impl;

import com.winter.beans.ResultResponse;
import com.winter.mapper.ProblemMapper;
import com.winter.model.Problem_info;
import com.winter.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "problemService")
public class ProblemServiceImpl implements ProblemService {
    @Autowired
    private ProblemMapper problemMapper;

    @Override
    public ResultResponse addProblem(Problem_info problem) {
        System.out.println("addProblem");
        int f=problemMapper.insert(problem);
        System.out.println("add ok");
        return null;
    }

    @Override
    public ResultResponse modifyProblem(Problem_info problem){
        System.out.println("modifyProblem");
        int f=problemMapper.modify(problem);
        System.out.println("modify ok");
        return null;
    }

    @Override
    public Problem_info findProblem(Problem_info problem){
        System.out.println("findProblem");
        Problem_info pro = problemMapper.findProblem(problem.getQuestionnaire_id(), problem.getPos());
        return pro;
    }


    public List<Problem_info> findAllProblem() {
        System.out.println("findAllProblem");
        return problemMapper.findAllProblem();
    }

    @Override
    public ResultResponse upProblem(Problem_info problem) {
        System.out.println("upProblem");
        int f=problemMapper.update(problem);
        System.out.println("up ok");
        return null;
    }

    @Override
    public ResultResponse delProblem(Problem_info problem) {
        System.out.println("delProblem");
        int f=problemMapper.delete(problem.getId());
        System.out.println("del ok");
        return null;
    }

}
