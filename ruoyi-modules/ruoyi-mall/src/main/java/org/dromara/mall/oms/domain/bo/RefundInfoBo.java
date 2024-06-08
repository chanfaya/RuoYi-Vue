package org.dromara.mall.oms.domain.bo;

import org.dromara.mall.oms.domain.RefundInfo;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;

/**
 * 退款信息业务对象 oms_refund_info
 *
 * @author chan fa
 * @date 2024-06-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = RefundInfo.class, reverseConvertGenerate = false)
public class RefundInfoBo extends BaseEntity {

    /**
     * 
     */
    @NotNull(message = "不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 退款的订单
     */
    @NotNull(message = "退款的订单不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long orderReturnId;

    /**
     * 退款金额
     */
    @NotNull(message = "退款金额不能为空", groups = { AddGroup.class, EditGroup.class })
    private BigDecimal refund;

    /**
     * 退款交易流水号
     */
    @NotBlank(message = "退款交易流水号不能为空", groups = { AddGroup.class, EditGroup.class })
    private String refundSn;

    /**
     * 退款状态
     */
    @NotNull(message = "退款状态不能为空", groups = { AddGroup.class, EditGroup.class })
    private Integer refundStatus;

    /**
     * 退款渠道[1-支付宝，2-微信，3-银联，4-汇款]
     */
    @NotNull(message = "退款渠道[1-支付宝，2-微信，3-银联，4-汇款]不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long refundChannel;

    /**
     * 
     */
    @NotBlank(message = "不能为空", groups = { AddGroup.class, EditGroup.class })
    private String refundContent;


}
