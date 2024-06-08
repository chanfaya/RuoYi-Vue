package org.dromara.mall.oms.domain.vo;

import java.math.BigDecimal;
import org.dromara.mall.oms.domain.RefundInfo;
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
 * 退款信息视图对象 oms_refund_info
 *
 * @author chan fa
 * @date 2024-06-08
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = RefundInfo.class)
public class RefundInfoVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    @ExcelProperty(value = "")
    private Long id;

    /**
     * 退款的订单
     */
    @ExcelProperty(value = "退款的订单")
    private Long orderReturnId;

    /**
     * 退款金额
     */
    @ExcelProperty(value = "退款金额")
    private BigDecimal refund;

    /**
     * 退款交易流水号
     */
    @ExcelProperty(value = "退款交易流水号")
    private String refundSn;

    /**
     * 退款状态
     */
    @ExcelProperty(value = "退款状态")
    private Integer refundStatus;

    /**
     * 退款渠道[1-支付宝，2-微信，3-银联，4-汇款]
     */
    @ExcelProperty(value = "退款渠道[1-支付宝，2-微信，3-银联，4-汇款]")
    private Long refundChannel;

    /**
     * 
     */
    @ExcelProperty(value = "")
    private String refundContent;


}
