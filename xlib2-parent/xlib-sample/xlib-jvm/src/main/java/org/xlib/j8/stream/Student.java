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
    private Integer sid;
    private String stuName;
    private Integer score;
    private String className;

    public Student(Integer sid, String stuName, Integer score, String className) {
        this.sid = sid;
        this.stuName = stuName;
        this.score = score;
        this.className = className;
    }
}
