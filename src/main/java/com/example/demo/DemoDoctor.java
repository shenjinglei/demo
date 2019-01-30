package com.example.demo;

/**
 * 医生对象模型，不要使用该类
 * @author SUNF
 *
 */

public class DemoDoctor{

    private Integer id;

    private String name;


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

    @Override
    public String toString() {
        return "DemoDoctor [id=" + id + ", name=" + name + "]";
    }

}