package org.xlib.j8.stream.d2;

import lombok.Data;

/**
 * @Author: dengshengwu
 * @DateTime: 2019/12/17 10:55
 * @description:
 **/
@Data
public class Student {
    private String name;
    private int score;

    public Student() {

    }

    public Student(String name, int score) {
        super();
        this.name = name;
        this.score = score;
    }


    @Override
    public String toString() {
        return "[姓名=" + name + ", 分数=" + score + "]";
    }

}
