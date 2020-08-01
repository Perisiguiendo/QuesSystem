package com.winter.model;

import java.sql.Timestamp;

public class Questionnaire_info_type {
    //id和type  准备用作项目实体
    private Integer id;
    private Integer num;
    private String questionnaire_type;
    //创建信息
    private String created_by;
    private Timestamp creation_date;
    private String last_updated_by;
    private Timestamp last_update_date;
    //get and set

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestionnaire_type() {
        return questionnaire_type;
    }

    public void setQuestionnaire_type(String questionnaire_type) {
        this.questionnaire_type = questionnaire_type;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public Timestamp getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Timestamp creation_date) {
        this.creation_date = creation_date;
    }

    public String getLast_updated_by() {
        return last_updated_by;
    }

    public void setLast_updated_by(String last_updated_by) {
        this.last_updated_by = last_updated_by;
    }

    public Timestamp getLast_update_date() {
        return last_update_date;
    }

    public void setLast_update_date(Timestamp last_update_date) {
        this.last_update_date = last_update_date;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
