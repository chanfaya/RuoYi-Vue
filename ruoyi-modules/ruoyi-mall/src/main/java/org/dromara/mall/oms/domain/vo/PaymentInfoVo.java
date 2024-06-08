package org.dromara.mall.oms.domain.vo;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.mall.oms.domain.PaymentInfo;
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
 * 支付信息视图对象 oms_payment_info
 *
 * @author chan fa
 * @date 2024-06-08
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = PaymentInfo.class)
public class PaymentInfoVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    @ExcelProperty(value = "")
    private Long id;

    /**
     * 订单号（对外业务号）
     */
    @ExcelProperty(value = "订单号", converter = ExcelDictConvert.class)
    @ExcelDictFormat(readConverterExp = "对=外业务号")
    private String orderSn;

    /**
     * 订单id
     */
    @ExcelProperty(value = "订单id")
    private Long orderId;

    /**
     * 支付宝交易流水号
     */
    @ExcelProperty(value = "支付宝交易流水号")
    private String alipayTradeNo;

    /**
     * 支付总金额
     */
    @ExcelProperty(value = "支付总金额")
    private BigDecimal totalAmount;

    /**
     * 交易内容
     */
    @ExcelProperty(value = "交易内容")
    private String subject;

    /**
     * 支付状态
     */
    @ExcelProperty(value = "支付状态")
    private String paymentStatus;

    /**
     * 确认时间
     */
    @ExcelProperty(value = "确认时间")
    private Date confirmTime;

    /**
     * 回调内容
     */
    @ExcelProperty(value = "回调内容")
    private String callbackContent;

    /**
     * 回调时间
     */
    @ExcelProperty(value = "回调时间")
    private Date callbackTime;


}
