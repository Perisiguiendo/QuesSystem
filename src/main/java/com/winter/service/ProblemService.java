package com.winter.service;
import com.winter.beans.ResultResponse;
import com.winter.model.Problem_info;

import java.util.List;
public interface ProblemService {
    ResultResponse addProblem(Problem_info problem);//保存 pro信息
    ResultResponse modifyProblem(Problem_info problem);//保存 pro信息
    Problem_info findProblem(Problem_info problem);
    public List<Problem_info> findAllProblem(); //
    ResultResponse upProblem(Problem_info problem);//保存 pro信息
    ResultResponse delProblem(Problem_info problem);
}
