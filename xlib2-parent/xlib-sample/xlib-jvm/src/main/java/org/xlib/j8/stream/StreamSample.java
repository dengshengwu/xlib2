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


    public void sort() {
        List<ItemInfo> list = init(9);
        List<ItemInfo> listSort = list.stream()
                .sorted(Comparator.comparing(ItemInfo::getItemCode))
                .sorted(Comparator.comparing(ItemInfo::getItemId).reversed())
                .sorted(Comparator.comparing(ItemInfo::getPrices))
                .collect(Collectors.toList());
        System.out.println(JSON.toJSONString(listSort));
    }

    public void filter(){
        List<ItemInfo> list = init(9);
        List<ItemInfo> listSort = list.stream()
                .filter(item -> {
                    return item.getRecordStatus() == RecordStatus.N;
                })
                .collect(Collectors.toList());
        System.out.println(JSON.toJSONString(listSort));
    }





}
