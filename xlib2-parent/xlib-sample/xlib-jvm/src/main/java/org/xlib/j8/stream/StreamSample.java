package org.xlib.j8.stream;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @Author: dengshengwu
 * @DateTime: 2019/11/18 16:21
 * @description:
 **/
public class StreamSample {
    private List<ItemInfo> init(int initialCapacity) {
        List<ItemInfo> list = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            ItemInfo item = new ItemInfo();
            item.setItemId(1000 + i);
            item.setItemCode("00" + i + ".00" + i + "000000" + i);
            item.setItemName("PCB" + i + "板卡.");
            item.setItemDesc("PCB" + i + "板卡DESC.");
            item.setPrices(1.9 + i);
            item.setApplyDate(new Date());
            if (i % 2 == 0) {
                item.setRecordStatus(RecordStatus.N);
            } else {
                item.setRecordStatus(RecordStatus.F);
            }
            item.setStartDate(new Date());
            item.setEndDate(new Date());
            item.setSortNo(i);
            list.add(item);
        }
        return list;
    }


    public void forEachPrint(List<ItemInfo> list){
        list.forEach((itemInfo -> {
            System.out.println(JSON.toJSONString(itemInfo));
        }));
    }


    public void sort() {
        List<ItemInfo> list = init(9);
        List<ItemInfo> listSort = list.stream()
                .sorted(Comparator.comparing(ItemInfo::getItemCode))
                .sorted(Comparator.comparing(ItemInfo::getItemId).reversed())
                .sorted(Comparator.comparing(ItemInfo::getRecordStatus))
                .collect(Collectors.toList());
        forEachPrint(listSort);
    }

    public void filter() {
        List<ItemInfo> list = init(9);
        List<ItemInfo> listFilter = list.stream()
                .filter(item -> {
                    return item.getRecordStatus() == RecordStatus.F;
                })
                .filter(itemInfo -> itemInfo.getPrices() > 3)
                .limit(2)
                .collect(Collectors.toList());
        forEachPrint(listFilter);
    }

    public void map(){
        List<ItemInfo> list = init(9);
        List<Integer> listMap = list.stream()
                .map(ItemInfo::getItemCode)
                .map(String::length)
                .collect(Collectors.toList());
        listMap.forEach((s) -> System.out.println(s));
    }

}
