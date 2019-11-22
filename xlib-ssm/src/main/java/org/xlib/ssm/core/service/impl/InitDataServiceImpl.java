package org.xlib.ssm.core.service.impl;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.xlib.boot.BootApp;
import org.xlib.ssm.core.dto.ItemInfo;
import org.xlib.ssm.core.service.InitDataService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Author: dengshengwu
 * @DateTime: 2019/11/20 10:38
 * @description:
 **/
@Service
@Slf4j
public class InitDataServiceImpl implements InitDataService {
    public InitDataServiceImpl() {
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(BootApp.sleepSeconds * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                init();
            }
        }).start();
    }

    @Override
    public void init() {
        log.warn("开始构造大对象");
        List<ItemInfo> dataList = new ArrayList<>();
        for (int i = 1; i < BootApp.initSize; i++) {
            ItemInfo itemInfo = new ItemInfo();
            itemInfo.setItemId(new Integer(i));
            itemInfo.setItemCode(i + "：" + UUID.randomUUID().toString());
            itemInfo.setItemName("ItemName：" + i + UUID.randomUUID().toString());
            itemInfo.setItemDesc("ItemDesc：" + i + UUID.randomUUID().toString());
            itemInfo.setPrices(Double.valueOf(i));
            itemInfo.setApplyDate(new Date());
            itemInfo.setRecordStatus(UUID.randomUUID().toString());
            itemInfo.setStartDate(new Date());
            itemInfo.setEndDate(new Date());
            itemInfo.setSortNo(i);
            dataList.add(itemInfo);
            try {
                if (i % 10000 == 0) {
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        log.warn("构造完毕：" + dataList.size() + "条记录！");
        String dataStr = JSON.toJSONString(dataList);
        log.warn(dataStr.substring(0, 200));
        log.warn(dataStr.substring(dataStr.length() - 200));
        log.warn("打印完毕！");
    }
}
