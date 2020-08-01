package com.winter.model;

import java.sql.Timestamp;

public class Problem_info {
    //各个键
    private Integer id;
    private Integer kind_id;
    private Integer questionnaire_id;  //所属问卷的id
    private String problem_name; //问题题目
    private Timestamp creation_date;
    private Timestamp last_update_date; //
    private Integer pos; //位置

    public Integer getId() {
        return id;
    }

    public Integer getKind_id() {
        return kind_id;
    }

    public void setKind_id(Integer kind_id) {
        this.kind_id = kind_id;
    }

    public Integer getQuestionnaire_id() {
        return questionnaire_id;
    }

    public String getProblem_name() {
        return problem_name;
    }

    public Timestamp getCreation_date() {
        return creation_date;
    }

    public Timestamp getLast_update_date() {
        return last_update_date;
    }

    public Integer getPos() {
        return pos;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setQuestionnaire_id(Integer questionnaire_id) {
        this.questionnaire_id = questionnaire_id;
    }

    public void setProblem_name(String problem_name) {
        this.problem_name = problem_name;
    }

    public void setCreation_date(Timestamp creation_date) {
        this.creation_date = creation_date;
    }

    public void setLast_update_date(Timestamp last_update_date) {
        this.last_update_date = last_update_date;
    }

    public void setPos(Integer pos) {
        this.pos = pos;
    }
}
