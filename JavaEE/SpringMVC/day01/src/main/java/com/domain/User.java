package com.domain;

import java.io.Serializable;

public class User implements Serializable {
    private String uname;
    private Integer age;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
