package org.xlib.j8.stream;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: dengshengwu
 * @DateTime: 2019/11/22 11:52
 * @description:
 **/
public class ForEachDemo {
    public static void main(String[] args) {
        List<String> strings = null;
        strings.forEach((s) -> System.out.println(s));

        List<String> listA = strings.stream()
                .filter((s -> s.contains("A")))
                .collect(Collectors.toList());
        System.out.println("\n" + "listA：");
        listA.forEach((s -> System.out.println(s)));
    }
}
