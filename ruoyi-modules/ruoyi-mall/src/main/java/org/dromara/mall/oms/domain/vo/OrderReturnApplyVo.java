package org.dromara.mall.oms.domain.vo;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.mall.oms.domain.OrderReturnApply;
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
 * 订单退货申请视图对象 oms_order_return_apply
 *
 * @author chan fa
 * @date 2024-06-08
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = OrderReturnApply.class)
public class OrderReturnApplyVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    @ExcelProperty(value = "")
    private Long id;

    /**
     * order_id
     */
    @ExcelProperty(value = "order_id")
    private Long orderId;

    /**
     * 退货商品id
     */
    @ExcelProperty(value = "退货商品id")
    private Long skuId;

    /**
     * 订单编号
     */
    @ExcelProperty(value = "订单编号")
    private String orderSn;

    /**
     * 会员用户名
     */
    @ExcelProperty(value = "会员用户名")
    private String memberUsername;

    /**
     * 退款金额
     */
    @ExcelProperty(value = "退款金额")
    private BigDecimal returnAmount;

    /**
     * 退货人姓名
     */
    @ExcelProperty(value = "退货人姓名")
    private String returnName;

    /**
     * 退货人电话
     */
    @ExcelProperty(value = "退货人电话")
    private String returnPhone;

    /**
     * 申请状态[0->待处理；1->退货中；2->已完成；3->已拒绝]
     */
    @ExcelProperty(value = "申请状态[0->待处理；1->退货中；2->已完成；3->已拒绝]")
    private Integer status;

    /**
     * 处理时间
     */
    @ExcelProperty(value = "处理时间")
    private Date handleTime;

    /**
     * 商品图片
     */
    @ExcelProperty(value = "商品图片")
    private String skuImg;

    /**
     * 商品名称
     */
    @ExcelProperty(value = "商品名称")
    private String skuName;

    /**
     * 商品品牌
     */
    @ExcelProperty(value = "商品品牌")
    private String skuBrand;

    /**
     * 商品销售属性(JSON)
     */
    @ExcelProperty(value = "商品销售属性(JSON)")
    private String skuAttrsVals;

    /**
     * 退货数量
     */
    @ExcelProperty(value = "退货数量")
    private Long skuCount;

    /**
     * 商品单价
     */
    @ExcelProperty(value = "商品单价")
    private BigDecimal skuPrice;

    /**
     * 商品实际支付单价
     */
    @ExcelProperty(value = "商品实际支付单价")
    private BigDecimal skuRealPrice;

    /**
     * 原因
     */
    @ExcelProperty(value = "原因")
    private String reason;

    /**
     * 描述
     */
    @ExcelProperty(value = "描述")
    private String description述;

    /**
     * 凭证图片，以逗号隔开
     */
    @ExcelProperty(value = "凭证图片，以逗号隔开")
    private String descPics;

    /**
     * 处理备注
     */
    @ExcelProperty(value = "处理备注")
    private String handleNote;

    /**
     * 处理人员
     */
    @ExcelProperty(value = "处理人员")
    private String handleMan;

    /**
     * 收货人
     */
    @ExcelProperty(value = "收货人")
    private String receiveMan;

    /**
     * 收货时间
     */
    @ExcelProperty(value = "收货时间")
    private Date receiveTime;

    /**
     * 收货备注
     */
    @ExcelProperty(value = "收货备注")
    private String receiveNote;

    /**
     * 收货电话
     */
    @ExcelProperty(value = "收货电话")
    private String receivePhone;

    /**
     * 公司收货地址
     */
    @ExcelProperty(value = "公司收货地址")
    private String companyAddress;


}
