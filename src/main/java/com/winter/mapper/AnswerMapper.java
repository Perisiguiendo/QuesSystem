package com.winter.mapper;

import com.winter.model.Answer;

import java.util.List;

public interface AnswerMapper {
    int insert(Answer answer);//save
    int delete(Integer pro_id);
    public List<Answer> findAnswer();
}
