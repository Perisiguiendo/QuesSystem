package com.winter.service;

import com.winter.beans.ResultResponse;
import com.winter.model.Answer;

import java.util.List;

public interface AnswerService {
    ResultResponse addAnswer(Answer answer);//保存 pro信息
    ResultResponse delAnswer(Answer answer);
    public List<Answer> findAnswer(); //
}
