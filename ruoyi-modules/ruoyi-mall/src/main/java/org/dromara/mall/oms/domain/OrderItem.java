package org.dromara.mall.oms.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.math.BigDecimal;

import java.io.Serial;

/**
 * 订单项信息对象 oms_order_item
 *
 * @author chan fa
 * @date 2024-06-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("oms_order_item")
public class OrderItem extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    @TableId(value = "id")
    private Long id;

    /**
     * order_id
     */
    private Long orderId;

    /**
     * order_sn
     */
    private String orderSn;

    /**
     * spu_id
     */
    private Long spuId;

    /**
     * spu_name
     */
    private String spuName;

    /**
     * spu_pic
     */
    private String spuPic;

    /**
     * 品牌
     */
    private String spuBrand;

    /**
     * 商品分类id
     */
    private Long categoryId;

    /**
     * 商品sku编号
     */
    private Long skuId;

    /**
     * 商品sku名字
     */
    private String skuName;

    /**
     * 商品sku图片
     */
    private String skuPic;

    /**
     * 商品sku价格
     */
    private BigDecimal skuPrice;

    /**
     * 商品购买的数量
     */
    private Long skuQuantity;

    /**
     * 商品销售属性组合（JSON）
     */
    private String skuAttrsVals;

    /**
     * 商品促销分解金额
     */
    private BigDecimal promotionAmount;

    /**
     * 优惠券优惠分解金额
     */
    private BigDecimal couponAmount;

    /**
     * 积分优惠分解金额
     */
    private BigDecimal integrationAmount;

    /**
     * 该商品经过优惠后的分解金额
     */
    private BigDecimal realAmount;

    /**
     * 赠送积分
     */
    private Long giftIntegration;

    /**
     * 赠送成长值
     */
    private Long giftGrowth;


}
