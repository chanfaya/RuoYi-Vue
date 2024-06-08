package org.dromara.mall.oms.domain.bo;

import org.dromara.mall.oms.domain.Order;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 订单业务对象 oms_order
 *
 * @author chan fa
 * @date 2024-06-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = Order.class, reverseConvertGenerate = false)
public class OrderBo extends BaseEntity {

    /**
     * 
     */
    @NotNull(message = "不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * member_id
     */
    @NotNull(message = "member_id不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long memberId;

    /**
     * 订单号
     */
    @NotBlank(message = "订单号不能为空", groups = { AddGroup.class, EditGroup.class })
    private String orderSn;

    /**
     * 使用的优惠券
     */
    @NotNull(message = "使用的优惠券不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long couponId;

    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空", groups = { AddGroup.class, EditGroup.class })
    private String memberUsername;

    /**
     * 订单总额
     */
    @NotNull(message = "订单总额不能为空", groups = { AddGroup.class, EditGroup.class })
    private BigDecimal totalAmount;

    /**
     * 应付总额
     */
    @NotNull(message = "应付总额不能为空", groups = { AddGroup.class, EditGroup.class })
    private BigDecimal payAmount;

    /**
     * 运费金额
     */
    @NotNull(message = "运费金额不能为空", groups = { AddGroup.class, EditGroup.class })
    private BigDecimal freightAmount;

    /**
     * 促销优化金额（促销价、满减、阶梯价）
     */
    @NotNull(message = "促销优化金额（促销价、满减、阶梯价）不能为空", groups = { AddGroup.class, EditGroup.class })
    private BigDecimal promotionAmount;

    /**
     * 积分抵扣金额
     */
    @NotNull(message = "积分抵扣金额不能为空", groups = { AddGroup.class, EditGroup.class })
    private BigDecimal integrationAmount;

    /**
     * 优惠券抵扣金额
     */
    @NotNull(message = "优惠券抵扣金额不能为空", groups = { AddGroup.class, EditGroup.class })
    private BigDecimal couponAmount;

    /**
     * 后台调整订单使用的折扣金额
     */
    @NotNull(message = "后台调整订单使用的折扣金额不能为空", groups = { AddGroup.class, EditGroup.class })
    private BigDecimal discountAmount;

    /**
     * 支付方式【1->支付宝；2->微信；3->银联； 4->货到付款；】
     */
    @NotNull(message = "支付方式【1->支付宝；2->微信；3->银联； 4->货到付款；】不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long payType;

    /**
     * 订单来源[0->PC订单；1->app订单]
     */
    @NotNull(message = "订单来源[0->PC订单；1->app订单]不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long sourceType;

    /**
     * 订单状态【0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单】
     */
    @NotNull(message = "订单状态【0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单】不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long status;

    /**
     * 物流公司(配送方式)
     */
    @NotBlank(message = "物流公司(配送方式)不能为空", groups = { AddGroup.class, EditGroup.class })
    private String deliveryCompany;

    /**
     * 物流单号
     */
    @NotBlank(message = "物流单号不能为空", groups = { AddGroup.class, EditGroup.class })
    private String deliverySn;

    /**
     * 自动确认时间（天）
     */
    @NotNull(message = "自动确认时间（天）不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long autoConfirmDay;

    /**
     * 可以获得的积分
     */
    @NotNull(message = "可以获得的积分不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long integration;

    /**
     * 可以获得的成长值
     */
    @NotNull(message = "可以获得的成长值不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long growth;

    /**
     * 发票类型[0->不开发票；1->电子发票；2->纸质发票]
     */
    @NotNull(message = "发票类型[0->不开发票；1->电子发票；2->纸质发票]不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long billType;

    /**
     * 发票抬头
     */
    @NotBlank(message = "发票抬头不能为空", groups = { AddGroup.class, EditGroup.class })
    private String billHeader;

    /**
     * 发票内容
     */
    @NotBlank(message = "发票内容不能为空", groups = { AddGroup.class, EditGroup.class })
    private String billContent;

    /**
     * 收票人电话
     */
    @NotBlank(message = "收票人电话不能为空", groups = { AddGroup.class, EditGroup.class })
    private String billReceiverPhone;

    /**
     * 收票人邮箱
     */
    @NotBlank(message = "收票人邮箱不能为空", groups = { AddGroup.class, EditGroup.class })
    private String billReceiverEmail;

    /**
     * 收货人姓名
     */
    @NotBlank(message = "收货人姓名不能为空", groups = { AddGroup.class, EditGroup.class })
    private String receiverName;

    /**
     * 收货人电话
     */
    @NotBlank(message = "收货人电话不能为空", groups = { AddGroup.class, EditGroup.class })
    private String receiverPhone;

    /**
     * 收货人邮编
     */
    @NotBlank(message = "收货人邮编不能为空", groups = { AddGroup.class, EditGroup.class })
    private String receiverPostCode;

    /**
     * 省份/直辖市
     */
    @NotBlank(message = "省份/直辖市不能为空", groups = { AddGroup.class, EditGroup.class })
    private String receiverProvince;

    /**
     * 城市
     */
    @NotBlank(message = "城市不能为空", groups = { AddGroup.class, EditGroup.class })
    private String receiverCity;

    /**
     * 区
     */
    @NotBlank(message = "区不能为空", groups = { AddGroup.class, EditGroup.class })
    private String receiverRegion;

    /**
     * 详细地址
     */
    @NotBlank(message = "详细地址不能为空", groups = { AddGroup.class, EditGroup.class })
    private String receiverDetailAddress;

    /**
     * 订单备注
     */
    @NotBlank(message = "订单备注不能为空", groups = { AddGroup.class, EditGroup.class })
    private String note;

    /**
     * 确认收货状态[0->未确认；1->已确认]
     */
    @NotNull(message = "确认收货状态[0->未确认；1->已确认]不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long confirmStatus;

    /**
     * 删除状态【0->未删除；1->已删除】
     */
    @NotNull(message = "删除状态【0->未删除；1->已删除】不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long deleteStatus;

    /**
     * 下单时使用的积分
     */
    @NotNull(message = "下单时使用的积分不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long useIntegration;

    /**
     * 支付时间
     */
    @NotNull(message = "支付时间不能为空", groups = { AddGroup.class, EditGroup.class })
    private Date paymentTime;

    /**
     * 发货时间
     */
    @NotNull(message = "发货时间不能为空", groups = { AddGroup.class, EditGroup.class })
    private Date deliveryTime;

    /**
     * 确认收货时间
     */
    @NotNull(message = "确认收货时间不能为空", groups = { AddGroup.class, EditGroup.class })
    private Date receiveTime;

    /**
     * 评价时间
     */
    @NotNull(message = "评价时间不能为空", groups = { AddGroup.class, EditGroup.class })
    private Date commentTime;

    /**
     * 修改时间
     */
    @NotNull(message = "修改时间不能为空", groups = { AddGroup.class, EditGroup.class })
    private Date modifyTime;


}
