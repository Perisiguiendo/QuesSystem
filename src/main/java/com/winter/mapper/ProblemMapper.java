package com.winter.mapper;

import com.winter.model.Problem_info;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProblemMapper {
    int insert(Problem_info problem);//save
    Problem_info findProblem(@Param("questionnaire_id") Integer questionnaire_id,@Param("pos") Integer pos);//获取全部用户
    int modify(Problem_info problem);
    int update(Problem_info problem);
    public List<Problem_info> findAllProblem();//获取全部用户
    int delete(Integer id);

}
