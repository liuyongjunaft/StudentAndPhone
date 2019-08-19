package com.lyj.entity;

public class Phone {
    private Integer id;
    private String relation;
    private String tel;
    private Integer sid;
    private Integer is_delete;

    public Phone(String relation, String tel, Integer sid) {
        this.relation = relation;
        this.tel = tel;
        this.sid = sid;
    }

    public Phone(Integer id, String relation, String tel) {
        this.id = id;
        this.relation = relation;
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", relation='" + relation + '\'' +
                ", tel='" + tel + '\'' +
                ", sid=" + sid +
                ", is_delete=" + is_delete +
                '}'+'\n';
    }

    public Phone(Integer id, String relation, String tel, Integer sid) {
        this.id = id;
        this.relation = relation;
        this.tel = tel;
        this.sid = sid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(Integer is_delete) {
        this.is_delete = is_delete;
    }

    public Phone(Integer id, String relation, String tel, Integer sid, Integer is_delete) {
        this.id = id;
        this.relation = relation;
        this.tel = tel;
        this.sid = sid;
        this.is_delete = is_delete;
    }

    public Phone() {
    }
}
