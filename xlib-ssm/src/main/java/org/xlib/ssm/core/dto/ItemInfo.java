package org.xlib.ssm.core.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: dengshengwu
 * @DateTime: 2019/11/18 16:26
 * @description:
 **/
@Data
public class ItemInfo implements Serializable {
    private Integer itemId;
    /**
     * 物料编码
     */
    private String itemCode;
    /**
     * 物料名称
     */
    private String itemName;
    /**
     * 物料描述
     */
    private String itemDesc;
    /**
     * 价格
     */
    private Double prices;
    /**
     * 申请日期
     */
    private Date applyDate;
    /**
     * 记录状态
     */
    private String recordStatus;
    /**
     * 开启时间
     */
    private Date startDate;
    /**
     * 失效时间
     */
    private Date endDate;
    /**
     * 排序
     */
    private Integer sortNo;

}
