package com.kaishengit.entity;

public class Movie {
    private Integer id;

    private String name;

    private String daoyan;

    private Float pingfen;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDaoyan() {
        return daoyan;
    }

    public void setDaoyan(String daoyan) {
        this.daoyan = daoyan;
    }

    public Float getPingfen() {
        return pingfen;
    }

    public void setPingfen(Float pingfen) {
        this.pingfen = pingfen;
    }
}