package com.winter.model;

import java.sql.Timestamp;

public class Questionnaire_info {

    private Integer id;
    private Integer questionnaire_type;//所属项目名
    private String proj_name; //项目名
    private String questionnaire_name;//问卷名称
    private String questionnaire_content;//问卷说明
    private Timestamp creation_date;
    private Timestamp last_update_date;

    public Integer getId() {
        return id;
    }

    public Integer getQuestionnaire_type() {
        return questionnaire_type;
    }

    public String getProj_name() {
        return proj_name;
    }

    public String getQuestionnaire_name() {
        return questionnaire_name;
    }

    public String getQuestionnaire_content() {
        return questionnaire_content;
    }

    public Timestamp getCreation_date() {
        return creation_date;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setQuestionnaire_type(Integer questionnaire_type) {
        this.questionnaire_type = questionnaire_type;
    }

    public void setProj_name(String proj_name) {
        this.proj_name = proj_name;
    }

    public void setQuestionnaire_name(String questionnaire_name) {
        this.questionnaire_name = questionnaire_name;
    }

    public void setQuestionnaire_content(String questionnaire_content) {
        this.questionnaire_content = questionnaire_content;
    }

    public void setCreation_date(Timestamp creation_date) {
        this.creation_date = creation_date;
    }

    public Timestamp getLast_update_date() {
        return last_update_date;
    }

    public void setLast_update_date(Timestamp last_update_date) {
        this.last_update_date = last_update_date;
    }
}
