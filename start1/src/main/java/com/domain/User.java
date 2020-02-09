package com.domain;

import java.io.Serializable;

/**
 * @outhor li
 * @create 2020-02-09 18:49
 */
public class User implements Serializable {
    private String uname;
    private String age;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "uname='" + uname + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
