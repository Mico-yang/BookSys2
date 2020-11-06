package com.kgc.entity;

public class bookType {
    private Integer type_id;
    private String type_name;

    public bookType() {
    }

    public bookType(String type_name) {
        this.type_name = type_name;
    }

    public bookType(Integer type_id, String type_name) {
        this.type_id = type_id;
        this.type_name = type_name;
    }

    public Integer getType_id() {
        return type_id;
    }

    public void setType_id(Integer type_id) {
        this.type_id = type_id;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    @Override
    public String toString() {
        return "bookType{" +
                "type_id=" + type_id +
                ", type_name='" + type_name + '\'' +
                '}';
    }
}
