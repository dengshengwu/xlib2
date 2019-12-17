package org.xlib.j8.stream;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: dengshengwu
 * @DateTime: 2019/11/18 16:21
 * @description:
 **/
public class StuStreamSample {
    private List<Student> init() {
        List<Student> stuList = new ArrayList<>(10);
        stuList.add(new Student(1001, "刘一", 85, "一"));
        stuList.add(new Student(1002, "陈二", 90, "二"));
        stuList.add(new Student(1003, "张三", 98, "一"));
        stuList.add(new Student(1004, "李四", 88, "二"));
        stuList.add(new Student(1005, "王五", 83, "一"));
        stuList.add(new Student(1006, "赵六", 95, "二"));
        stuList.add(new Student(1007, "孙七", 87, "一"));
        stuList.add(new Student(1008, "周八", 84, "二"));
        stuList.add(new Student(1009, "吴九", 100, "一"));
        stuList.add(new Student(1010, "郑十", 95, "二"));
        stuList.add(new Student(1010, "郑十", 95, "二"));
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
    public void limitSkip() {
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
        subStuList.forEach(System.out::println);

    }

    /**
     * map映射数据
     */
    public void map() {
        List<Student> stuList = init();
        List<Integer> subStuList = stuList.stream()
                .map((Student::getSid))
                .collect(Collectors.toList());

        System.err.println("map后的值是>>>>>");
        subStuList.forEach(student -> System.out.println(student));
    }

    /**
     * mapToInt映射数据
     */
    public void mapToInt() {
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


        int max = stuList.stream()
                .distinct()
                .mapToInt(Student::getScore).max().getAsInt();

        int min = stuList.stream()
                .distinct()
                .mapToInt(Student::getScore).min().getAsInt();

        System.err.println("max：" + max);

        System.err.println("min：" + min);

    }


    /**
     * flatMap
     */
    public void flatMap() {
        List<String> list = new ArrayList<>();
        list.add("aaa bbb ccc");
        list.add("ddd eee fff");
        list.add("ggg hhh iii");

        List<String> result = list.stream()
                .map(s -> s.split(" "))
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
        result.forEach(System.err::println);
    }


    /**
     * anyMatch
     */
    public void anyMatch() {
        List<Student> stuList = init();
        boolean anyMatch = stuList.stream()
                .anyMatch(student -> student.getScore() == 100);
        boolean allMatch = stuList.stream()
                .allMatch(student -> student.getScore() > 90);
        boolean noneMatch = stuList.stream()
                .noneMatch(student -> "dengshengwu".equals(student.getStuName()));
        System.err.println("anyMatch:" + anyMatch);
        System.err.println("allMatch:" + allMatch);
        System.err.println("noneMatch:" + noneMatch);
    }

    /**
     * findAnyFirst
     */
    public void findAnyFirst() {
        List<Student> stuList = init();
        stuList.stream().findFirst().get();
        stuList.stream().findAny().get();
    }


    public void reduce() {
        List<Student> stuList = init();
        int reduceSum = stuList.stream()
                .distinct()
                .map(Student::getScore)
                .reduce(0, (a, b) -> a + b);
        int reduceSum2 = stuList.stream()
                .distinct()
                .mapToInt(Student::getScore)
                .reduce(0, Integer::sum);

        System.err.println("reduceSum：" + reduceSum);
        System.err.println("reduceSum2：" + reduceSum2);
    }


    public void counting(){
        List<Student> stuList = init();
        System.err.println("count：" + stuList.stream().count());
    }

    public void groupBy(){
        List<Student> stuList = init();
        Map<String, List<Student>> collect = stuList.stream()
                .collect(Collectors.groupingBy(s -> s.getClassName() + "," + s.getScore() ));

        collect.forEach((k,v) -> {
            System.err.println(k + "--->" + v);
        });
    }
}
