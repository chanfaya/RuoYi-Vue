package org.dromara.mall.oms.domain.bo;

import org.dromara.mall.oms.domain.PaymentInfo;
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
 * 支付信息业务对象 oms_payment_info
 *
 * @author chan fa
 * @date 2024-06-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = PaymentInfo.class, reverseConvertGenerate = false)
public class PaymentInfoBo extends BaseEntity {

    /**
     * 
     */
    @NotNull(message = "不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 订单号（对外业务号）
     */
    @NotBlank(message = "订单号（对外业务号）不能为空", groups = { AddGroup.class, EditGroup.class })
    private String orderSn;

    /**
     * 订单id
     */
    @NotNull(message = "订单id不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long orderId;

    /**
     * 支付宝交易流水号
     */
    @NotBlank(message = "支付宝交易流水号不能为空", groups = { AddGroup.class, EditGroup.class })
    private String alipayTradeNo;

    /**
     * 支付总金额
     */
    @NotNull(message = "支付总金额不能为空", groups = { AddGroup.class, EditGroup.class })
    private BigDecimal totalAmount;

    /**
     * 交易内容
     */
    @NotBlank(message = "交易内容不能为空", groups = { AddGroup.class, EditGroup.class })
    private String subject;

    /**
     * 支付状态
     */
    @NotBlank(message = "支付状态不能为空", groups = { AddGroup.class, EditGroup.class })
    private String paymentStatus;

    /**
     * 确认时间
     */
    @NotNull(message = "确认时间不能为空", groups = { AddGroup.class, EditGroup.class })
    private Date confirmTime;

    /**
     * 回调内容
     */
    @NotBlank(message = "回调内容不能为空", groups = { AddGroup.class, EditGroup.class })
    private String callbackContent;

    /**
     * 回调时间
     */
    @NotNull(message = "回调时间不能为空", groups = { AddGroup.class, EditGroup.class })
    private Date callbackTime;


}
