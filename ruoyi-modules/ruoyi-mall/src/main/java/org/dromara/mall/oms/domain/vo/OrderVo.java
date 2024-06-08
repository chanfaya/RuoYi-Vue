package org.dromara.mall.oms.domain.vo;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.mall.oms.domain.Order;
import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import org.dromara.common.excel.annotation.ExcelDictFormat;
import org.dromara.common.excel.convert.ExcelDictConvert;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;



/**
 * 订单视图对象 oms_order
 *
 * @author chan fa
 * @date 2024-06-08
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = Order.class)
public class OrderVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    @ExcelProperty(value = "")
    private Long id;

    /**
     * member_id
     */
    @ExcelProperty(value = "member_id")
    private Long memberId;

    /**
     * 订单号
     */
    @ExcelProperty(value = "订单号")
    private String orderSn;

    /**
     * 使用的优惠券
     */
    @ExcelProperty(value = "使用的优惠券")
    private Long couponId;

    /**
     * 用户名
     */
    @ExcelProperty(value = "用户名")
    private String memberUsername;

    /**
     * 订单总额
     */
    @ExcelProperty(value = "订单总额")
    private BigDecimal totalAmount;

    /**
     * 应付总额
     */
    @ExcelProperty(value = "应付总额")
    private BigDecimal payAmount;

    /**
     * 运费金额
     */
    @ExcelProperty(value = "运费金额")
    private BigDecimal freightAmount;

    /**
     * 促销优化金额（促销价、满减、阶梯价）
     */
    @ExcelProperty(value = "促销优化金额", converter = ExcelDictConvert.class)
    @ExcelDictFormat(readConverterExp = "促=销价、满减、阶梯价")
    private BigDecimal promotionAmount;

    /**
     * 积分抵扣金额
     */
    @ExcelProperty(value = "积分抵扣金额")
    private BigDecimal integrationAmount;

    /**
     * 优惠券抵扣金额
     */
    @ExcelProperty(value = "优惠券抵扣金额")
    private BigDecimal couponAmount;

    /**
     * 后台调整订单使用的折扣金额
     */
    @ExcelProperty(value = "后台调整订单使用的折扣金额")
    private BigDecimal discountAmount;

    /**
     * 支付方式【1->支付宝；2->微信；3->银联； 4->货到付款；】
     */
    @ExcelProperty(value = "支付方式【1->支付宝；2->微信；3->银联； 4->货到付款；】")
    private Long payType;

    /**
     * 订单来源[0->PC订单；1->app订单]
     */
    @ExcelProperty(value = "订单来源[0->PC订单；1->app订单]")
    private Long sourceType;

    /**
     * 订单状态【0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单】
     */
    @ExcelProperty(value = "订单状态【0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单】")
    private Long status;

    /**
     * 物流公司(配送方式)
     */
    @ExcelProperty(value = "物流公司(配送方式)")
    private String deliveryCompany;

    /**
     * 物流单号
     */
    @ExcelProperty(value = "物流单号")
    private String deliverySn;

    /**
     * 自动确认时间（天）
     */
    @ExcelProperty(value = "自动确认时间", converter = ExcelDictConvert.class)
    @ExcelDictFormat(readConverterExp = "天=")
    private Long autoConfirmDay;

    /**
     * 可以获得的积分
     */
    @ExcelProperty(value = "可以获得的积分")
    private Long integration;

    /**
     * 可以获得的成长值
     */
    @ExcelProperty(value = "可以获得的成长值")
    private Long growth;

    /**
     * 发票类型[0->不开发票；1->电子发票；2->纸质发票]
     */
    @ExcelProperty(value = "发票类型[0->不开发票；1->电子发票；2->纸质发票]")
    private Long billType;

    /**
     * 发票抬头
     */
    @ExcelProperty(value = "发票抬头")
    private String billHeader;

    /**
     * 发票内容
     */
    @ExcelProperty(value = "发票内容")
    private String billContent;

    /**
     * 收票人电话
     */
    @ExcelProperty(value = "收票人电话")
    private String billReceiverPhone;

    /**
     * 收票人邮箱
     */
    @ExcelProperty(value = "收票人邮箱")
    private String billReceiverEmail;

    /**
     * 收货人姓名
     */
    @ExcelProperty(value = "收货人姓名")
    private String receiverName;

    /**
     * 收货人电话
     */
    @ExcelProperty(value = "收货人电话")
    private String receiverPhone;

    /**
     * 收货人邮编
     */
    @ExcelProperty(value = "收货人邮编")
    private String receiverPostCode;

    /**
     * 省份/直辖市
     */
    @ExcelProperty(value = "省份/直辖市")
    private String receiverProvince;

    /**
     * 城市
     */
    @ExcelProperty(value = "城市")
    private String receiverCity;

    /**
     * 区
     */
    @ExcelProperty(value = "区")
    private String receiverRegion;

    /**
     * 详细地址
     */
    @ExcelProperty(value = "详细地址")
    private String receiverDetailAddress;

    /**
     * 订单备注
     */
    @ExcelProperty(value = "订单备注")
    private String note;

    /**
     * 确认收货状态[0->未确认；1->已确认]
     */
    @ExcelProperty(value = "确认收货状态[0->未确认；1->已确认]")
    private Long confirmStatus;

    /**
     * 删除状态【0->未删除；1->已删除】
     */
    @ExcelProperty(value = "删除状态【0->未删除；1->已删除】")
    private Long deleteStatus;

    /**
     * 下单时使用的积分
     */
    @ExcelProperty(value = "下单时使用的积分")
    private Long useIntegration;

    /**
     * 支付时间
     */
    @ExcelProperty(value = "支付时间")
    private Date paymentTime;

    /**
     * 发货时间
     */
    @ExcelProperty(value = "发货时间")
    private Date deliveryTime;

    /**
     * 确认收货时间
     */
    @ExcelProperty(value = "确认收货时间")
    private Date receiveTime;

    /**
     * 评价时间
     */
    @ExcelProperty(value = "评价时间")
    private Date commentTime;

    /**
     * 修改时间
     */
    @ExcelProperty(value = "修改时间")
    private Date modifyTime;


}
