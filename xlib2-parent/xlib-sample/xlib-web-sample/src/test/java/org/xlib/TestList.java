package org.xlib;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: dengshengwu
 * @DateTime: 2019/11/16 11:06
 * @description:
 **/
@Data
@EqualsAndHashCode
class TestItem {
    private int id;
    private String code;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class TestList {
    public List<TestItem> init() {
        List<TestItem> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            TestItem item = new TestItem();
            item.setId(i);
            item.setCode("code" + i);
            item.setName("name" + i);
            list.add(item);
        }
        return list;
    }

    @Test
    public void filter() {
        List<TestItem> list = init();
        List<TestItem> list2 = list.stream().filter(t -> t.getId() >= 1).sorted(Comparator.comparing(TestItem::getId).reversed()).limit(2).collect(Collectors.toList());
        for (TestItem item : list2) {
            System.out.println(item.toString());
        }


    }

}
