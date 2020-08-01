package com.winter.service.impl;

import com.winter.beans.ResultResponse;
import com.winter.mapper.AnswerMapper;
import com.winter.model.Answer;
import com.winter.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "answerService")
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    private AnswerMapper answerMapper;

    @Override
    public ResultResponse addAnswer(Answer answer) {
        System.out.println("addAnswer");
        int f=answerMapper.insert(answer);
        System.out.println("add ok");
        return null;
    }

    @Override
    public ResultResponse delAnswer(Answer answer) {
        System.out.println("delAnswer");
        int f=answerMapper.delete(answer.getPro_id());
        System.out.println("del ok");
        return null;
    }

    public List<Answer> findAnswer() {
        System.out.println("findAnswer");
        return answerMapper.findAnswer();
    }
}
