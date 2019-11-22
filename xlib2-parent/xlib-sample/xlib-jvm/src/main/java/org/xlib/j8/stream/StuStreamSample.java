package org.xlib.j8.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: dengshengwu
 * @DateTime: 2019/11/18 16:21
 * @description:
 **/
public class StuStreamSample {
    private List<Student> init() {
        List<Student> stuList = new ArrayList<>(10);
        stuList.add(new Student("刘一", 85, "一"));
        stuList.add(new Student("陈二", 90, "二"));
        stuList.add(new Student("张三", 98, "一"));
        stuList.add(new Student("李四", 88, "二"));
        stuList.add(new Student("王五", 83, "一"));
        stuList.add(new Student("赵六", 95, "二"));
        stuList.add(new Student("孙七", 87, "一"));
        stuList.add(new Student("周八", 84, "二"));
        stuList.add(new Student("吴九", 100, "一"));
        stuList.add(new Student("郑十", 95, "二"));
        return stuList;
    }


    public void sort() {
        List<Student> stuList = init();
        List<Student> subStuList = stuList.stream()
                .sorted(Comparator.comparing(Student::getStuName))
                .sorted(Comparator.comparing(Student::getClassName))
                .collect(Collectors.toList());
        subStuList.forEach(student -> System.out.println(student));
    }

    public void filter() {
        List<Student> stuList = init();
        List<Student> subStuList = stuList.stream()
                .filter((student) ->
                        student.getScore() >= 90
                                || "刘一".equals(student.getStuName())
                )
                .collect(Collectors.toList());
        subStuList.forEach(student -> System.out.println(student));
    }


}
