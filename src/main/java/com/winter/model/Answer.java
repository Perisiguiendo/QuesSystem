package com.winter.model;

public class Answer {
    private Integer id;
    private Integer pro_id;
    private String answer_name;

    public Integer getId() {
        return id;
    }


    public String getAnswer_name() {
        return answer_name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAnswer_name(String answer_name) {
        this.answer_name = answer_name;
    }

    public Integer getPro_id() {
        return pro_id;
    }

    public void setPro_id(Integer pro_id) {
        this.pro_id = pro_id;
    }
}
