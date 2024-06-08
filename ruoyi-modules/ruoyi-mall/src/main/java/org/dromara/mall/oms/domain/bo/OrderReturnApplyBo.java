package org.dromara.mall.oms.domain.bo;

import org.dromara.mall.oms.domain.OrderReturnApply;
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
 * 订单退货申请业务对象 oms_order_return_apply
 *
 * @author chan fa
 * @date 2024-06-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = OrderReturnApply.class, reverseConvertGenerate = false)
public class OrderReturnApplyBo extends BaseEntity {

    /**
     * 
     */
    @NotNull(message = "不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * order_id
     */
    @NotNull(message = "order_id不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long orderId;

    /**
     * 退货商品id
     */
    @NotNull(message = "退货商品id不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long skuId;

    /**
     * 订单编号
     */
    @NotBlank(message = "订单编号不能为空", groups = { AddGroup.class, EditGroup.class })
    private String orderSn;

    /**
     * 会员用户名
     */
    @NotBlank(message = "会员用户名不能为空", groups = { AddGroup.class, EditGroup.class })
    private String memberUsername;

    /**
     * 退款金额
     */
    @NotNull(message = "退款金额不能为空", groups = { AddGroup.class, EditGroup.class })
    private BigDecimal returnAmount;

    /**
     * 退货人姓名
     */
    @NotBlank(message = "退货人姓名不能为空", groups = { AddGroup.class, EditGroup.class })
    private String returnName;

    /**
     * 退货人电话
     */
    @NotBlank(message = "退货人电话不能为空", groups = { AddGroup.class, EditGroup.class })
    private String returnPhone;

    /**
     * 申请状态[0->待处理；1->退货中；2->已完成；3->已拒绝]
     */
    @NotNull(message = "申请状态[0->待处理；1->退货中；2->已完成；3->已拒绝]不能为空", groups = { AddGroup.class, EditGroup.class })
    private Integer status;

    /**
     * 处理时间
     */
    @NotNull(message = "处理时间不能为空", groups = { AddGroup.class, EditGroup.class })
    private Date handleTime;

    /**
     * 商品图片
     */
    @NotBlank(message = "商品图片不能为空", groups = { AddGroup.class, EditGroup.class })
    private String skuImg;

    /**
     * 商品名称
     */
    @NotBlank(message = "商品名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String skuName;

    /**
     * 商品品牌
     */
    @NotBlank(message = "商品品牌不能为空", groups = { AddGroup.class, EditGroup.class })
    private String skuBrand;

    /**
     * 商品销售属性(JSON)
     */
    @NotBlank(message = "商品销售属性(JSON)不能为空", groups = { AddGroup.class, EditGroup.class })
    private String skuAttrsVals;

    /**
     * 退货数量
     */
    @NotNull(message = "退货数量不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long skuCount;

    /**
     * 商品单价
     */
    @NotNull(message = "商品单价不能为空", groups = { AddGroup.class, EditGroup.class })
    private BigDecimal skuPrice;

    /**
     * 商品实际支付单价
     */
    @NotNull(message = "商品实际支付单价不能为空", groups = { AddGroup.class, EditGroup.class })
    private BigDecimal skuRealPrice;

    /**
     * 原因
     */
    @NotBlank(message = "原因不能为空", groups = { AddGroup.class, EditGroup.class })
    private String reason;

    /**
     * 描述
     */
    @NotBlank(message = "描述不能为空", groups = { AddGroup.class, EditGroup.class })
    private String description述;

    /**
     * 凭证图片，以逗号隔开
     */
    @NotBlank(message = "凭证图片，以逗号隔开不能为空", groups = { AddGroup.class, EditGroup.class })
    private String descPics;

    /**
     * 处理备注
     */
    @NotBlank(message = "处理备注不能为空", groups = { AddGroup.class, EditGroup.class })
    private String handleNote;

    /**
     * 处理人员
     */
    @NotBlank(message = "处理人员不能为空", groups = { AddGroup.class, EditGroup.class })
    private String handleMan;

    /**
     * 收货人
     */
    @NotBlank(message = "收货人不能为空", groups = { AddGroup.class, EditGroup.class })
    private String receiveMan;

    /**
     * 收货时间
     */
    @NotNull(message = "收货时间不能为空", groups = { AddGroup.class, EditGroup.class })
    private Date receiveTime;

    /**
     * 收货备注
     */
    @NotBlank(message = "收货备注不能为空", groups = { AddGroup.class, EditGroup.class })
    private String receiveNote;

    /**
     * 收货电话
     */
    @NotBlank(message = "收货电话不能为空", groups = { AddGroup.class, EditGroup.class })
    private String receivePhone;

    /**
     * 公司收货地址
     */
    @NotBlank(message = "公司收货地址不能为空", groups = { AddGroup.class, EditGroup.class })
    private String companyAddress;


}
