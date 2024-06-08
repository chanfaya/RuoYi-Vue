package org.dromara.mall.oms.domain.bo;

import org.dromara.mall.oms.domain.OrderItem;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;

/**
 * 订单项信息业务对象 oms_order_item
 *
 * @author chan fa
 * @date 2024-06-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = OrderItem.class, reverseConvertGenerate = false)
public class OrderItemBo extends BaseEntity {

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
     * order_sn
     */
    @NotBlank(message = "order_sn不能为空", groups = { AddGroup.class, EditGroup.class })
    private String orderSn;

    /**
     * spu_id
     */
    @NotNull(message = "spu_id不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long spuId;

    /**
     * spu_name
     */
    @NotBlank(message = "spu_name不能为空", groups = { AddGroup.class, EditGroup.class })
    private String spuName;

    /**
     * spu_pic
     */
    @NotBlank(message = "spu_pic不能为空", groups = { AddGroup.class, EditGroup.class })
    private String spuPic;

    /**
     * 品牌
     */
    @NotBlank(message = "品牌不能为空", groups = { AddGroup.class, EditGroup.class })
    private String spuBrand;

    /**
     * 商品分类id
     */
    @NotNull(message = "商品分类id不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long categoryId;

    /**
     * 商品sku编号
     */
    @NotNull(message = "商品sku编号不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long skuId;

    /**
     * 商品sku名字
     */
    @NotBlank(message = "商品sku名字不能为空", groups = { AddGroup.class, EditGroup.class })
    private String skuName;

    /**
     * 商品sku图片
     */
    @NotBlank(message = "商品sku图片不能为空", groups = { AddGroup.class, EditGroup.class })
    private String skuPic;

    /**
     * 商品sku价格
     */
    @NotNull(message = "商品sku价格不能为空", groups = { AddGroup.class, EditGroup.class })
    private BigDecimal skuPrice;

    /**
     * 商品购买的数量
     */
    @NotNull(message = "商品购买的数量不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long skuQuantity;

    /**
     * 商品销售属性组合（JSON）
     */
    @NotBlank(message = "商品销售属性组合（JSON）不能为空", groups = { AddGroup.class, EditGroup.class })
    private String skuAttrsVals;

    /**
     * 商品促销分解金额
     */
    @NotNull(message = "商品促销分解金额不能为空", groups = { AddGroup.class, EditGroup.class })
    private BigDecimal promotionAmount;

    /**
     * 优惠券优惠分解金额
     */
    @NotNull(message = "优惠券优惠分解金额不能为空", groups = { AddGroup.class, EditGroup.class })
    private BigDecimal couponAmount;

    /**
     * 积分优惠分解金额
     */
    @NotNull(message = "积分优惠分解金额不能为空", groups = { AddGroup.class, EditGroup.class })
    private BigDecimal integrationAmount;

    /**
     * 该商品经过优惠后的分解金额
     */
    @NotNull(message = "该商品经过优惠后的分解金额不能为空", groups = { AddGroup.class, EditGroup.class })
    private BigDecimal realAmount;

    /**
     * 赠送积分
     */
    @NotNull(message = "赠送积分不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long giftIntegration;

    /**
     * 赠送成长值
     */
    @NotNull(message = "赠送成长值不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long giftGrowth;


}
