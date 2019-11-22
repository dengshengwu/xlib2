package org.xlib.j8.stream;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: dengshengwu
 * @DateTime: 2019/11/22 17:22
 * @description:
 **/
@Data
public class Student implements Serializable {
    private String stuName;
    private int score;
    private String className;

    public Student() {

    }

    public Student(String stuName, int score, String className) {
        this.stuName = stuName;
        this.score = score;
        this.className = className;
    }
}
