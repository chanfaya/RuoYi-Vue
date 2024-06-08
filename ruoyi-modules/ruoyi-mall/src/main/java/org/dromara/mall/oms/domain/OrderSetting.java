package org.dromara.mall.oms.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 订单配置信息对象 oms_order_setting
 *
 * @author chan fa
 * @date 2024-06-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("oms_order_setting")
public class OrderSetting extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 秒杀订单超时关闭时间(分)
     */
    private Long flashOrderOvertime;

    /**
     * 正常订单超时时间(分)
     */
    private Long normalOrderOvertime;

    /**
     * 发货后自动确认收货时间（天）
     */
    private Long confirmOvertime;

    /**
     * 自动完成交易时间，不能申请退货（天）
     */
    private Long finishOvertime;

    /**
     * 订单完成后自动好评时间（天）
     */
    private Long commentOvertime;

    /**
     * 会员等级【0-不限会员等级，全部通用；其他-对应的其他会员等级】
     */
    private Long memberLevel;


}
