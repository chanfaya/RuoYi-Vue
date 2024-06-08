package org.dromara.mall.oms.domain.bo;

import org.dromara.mall.oms.domain.OrderSetting;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 订单配置信息业务对象 oms_order_setting
 *
 * @author chan fa
 * @date 2024-06-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = OrderSetting.class, reverseConvertGenerate = false)
public class OrderSettingBo extends BaseEntity {

    /**
     * 
     */
    @NotNull(message = "不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 秒杀订单超时关闭时间(分)
     */
    @NotNull(message = "秒杀订单超时关闭时间(分)不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long flashOrderOvertime;

    /**
     * 正常订单超时时间(分)
     */
    @NotNull(message = "正常订单超时时间(分)不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long normalOrderOvertime;

    /**
     * 发货后自动确认收货时间（天）
     */
    @NotNull(message = "发货后自动确认收货时间（天）不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long confirmOvertime;

    /**
     * 自动完成交易时间，不能申请退货（天）
     */
    @NotNull(message = "自动完成交易时间，不能申请退货（天）不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long finishOvertime;

    /**
     * 订单完成后自动好评时间（天）
     */
    @NotNull(message = "订单完成后自动好评时间（天）不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long commentOvertime;

    /**
     * 会员等级【0-不限会员等级，全部通用；其他-对应的其他会员等级】
     */
    @NotNull(message = "会员等级【0-不限会员等级，全部通用；其他-对应的其他会员等级】不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long memberLevel;


}
