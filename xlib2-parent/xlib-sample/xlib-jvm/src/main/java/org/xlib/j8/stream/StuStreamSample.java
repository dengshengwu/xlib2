package org.xlib.j8.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

/**
 * @Author: dengshengwu
 * @DateTime: 2019/11/18 16:21
 * @description:
 **/
public class StuStreamSample {
    private List<Student> init() {
        List<Student> stuList = new ArrayList<>(10);
        stuList.add(new Student(1001,"刘一", 85, "一"));
        stuList.add(new Student(1002,"陈二", 90, "二"));
        stuList.add(new Student(1003,"张三", 98, "一"));
        stuList.add(new Student(1004,"李四", 88, "二"));
        stuList.add(new Student(1005,"王五", 83, "一"));
        stuList.add(new Student(1006,"赵六", 95, "二"));
        stuList.add(new Student(1007,"孙七", 87, "一"));
        stuList.add(new Student(1008,"周八", 84, "二"));
        stuList.add(new Student(1009,"吴九", 100, "一"));
        stuList.add(new Student(1010,"郑十", 95, "二"));
        stuList.add(new Student(1010,"郑十", 95, "二"));
        return stuList;
    }

    /**
     * （1）条件过滤
     */
    public void filter() {
        List<Student> stuList = init();
        List<Student> subStuList = stuList.stream()
                .filter((Student s) -> s.getScore() >= 90)
                .filter((Student s) -> "一".equals(s.getClassName()))
                .collect(Collectors.toList());
        System.err.println("数据过滤>>>>>>>");
        subStuList.forEach(student -> System.out.println(student));

        System.err.println("distinct去掉重复>>>>>>>");
        subStuList = stuList.stream().distinct().collect(Collectors.toList());
        subStuList.forEach(student -> System.out.println(student));
    }


    /**
     * （2）排序
     */
    public void sort() {
        List<Student> stuList = init();
        List<Student> subStuList = stuList.stream()
                .distinct()
                .sorted(Comparator.comparing(Student::getScore).reversed())
                .sorted(Comparator.comparing(Student::getClassName))
                .collect(Collectors.toList());
        System.err.println("sorted后的值是>>>>>");
        subStuList.forEach(student -> System.out.println(student));
    }


    /**
     * limitSkip
     */
    public void limitSkip(){
        List<Student> stuList = init();
        List<Student> subStuList = stuList.stream()
                .distinct()
                .sorted(Comparator.comparing(Student::getSid))
                .skip(2)  // 跳过前面的2条数据
                .limit(3) // 返回3条记录数据
                .collect(Collectors.toList());
        System.err.println("limitSkip1后的值是>>>>>");
        subStuList.forEach(student -> System.out.println(student));

        subStuList = stuList.stream()
                .distinct()
                .sorted(Comparator.comparing(Student::getSid))
                .limit(5) // 返回3条记录数据
                .skip(2)  // 跳过前面的2条数据
                .collect(Collectors.toList());
        System.err.println("limitSkip2后的值是>>>>>");
        subStuList.forEach(student -> System.out.println(student));

    }

    /**
     * map映射数据
     */
    public void map(){
        List<Student> stuList = init();
        List<Integer> subStuList = stuList.stream()
                .map((Student::getSid))
                .collect(Collectors.toList());

        System.err.println("map后的值是>>>>>");
        subStuList.forEach(student -> System.out.println(student));
    }

    /**
     * map映射数据
     */
    public void mapToInt(){
        List<Student> stuList = init();
        int sumValue = stuList.stream()
                .distinct()
                .mapToInt(Student::getScore)
                .sum();
        System.err.println("sum的值是：" + sumValue);

        double average = stuList.stream()
                .distinct()
                .mapToInt(Student::getScore)
                .average().getAsDouble();

        System.err.println("average：" + average);

    }







}
