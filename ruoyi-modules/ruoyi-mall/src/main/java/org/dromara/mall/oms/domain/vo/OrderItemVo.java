package org.dromara.mall.oms.domain.vo;

import java.math.BigDecimal;
import org.dromara.mall.oms.domain.OrderItem;
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
 * 订单项信息视图对象 oms_order_item
 *
 * @author chan fa
 * @date 2024-06-08
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = OrderItem.class)
public class OrderItemVo implements Serializable {

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
     * order_sn
     */
    @ExcelProperty(value = "order_sn")
    private String orderSn;

    /**
     * spu_id
     */
    @ExcelProperty(value = "spu_id")
    private Long spuId;

    /**
     * spu_name
     */
    @ExcelProperty(value = "spu_name")
    private String spuName;

    /**
     * spu_pic
     */
    @ExcelProperty(value = "spu_pic")
    private String spuPic;

    /**
     * 品牌
     */
    @ExcelProperty(value = "品牌")
    private String spuBrand;

    /**
     * 商品分类id
     */
    @ExcelProperty(value = "商品分类id")
    private Long categoryId;

    /**
     * 商品sku编号
     */
    @ExcelProperty(value = "商品sku编号")
    private Long skuId;

    /**
     * 商品sku名字
     */
    @ExcelProperty(value = "商品sku名字")
    private String skuName;

    /**
     * 商品sku图片
     */
    @ExcelProperty(value = "商品sku图片")
    private String skuPic;

    /**
     * 商品sku价格
     */
    @ExcelProperty(value = "商品sku价格")
    private BigDecimal skuPrice;

    /**
     * 商品购买的数量
     */
    @ExcelProperty(value = "商品购买的数量")
    private Long skuQuantity;

    /**
     * 商品销售属性组合（JSON）
     */
    @ExcelProperty(value = "商品销售属性组合", converter = ExcelDictConvert.class)
    @ExcelDictFormat(readConverterExp = "J=SON")
    private String skuAttrsVals;

    /**
     * 商品促销分解金额
     */
    @ExcelProperty(value = "商品促销分解金额")
    private BigDecimal promotionAmount;

    /**
     * 优惠券优惠分解金额
     */
    @ExcelProperty(value = "优惠券优惠分解金额")
    private BigDecimal couponAmount;

    /**
     * 积分优惠分解金额
     */
    @ExcelProperty(value = "积分优惠分解金额")
    private BigDecimal integrationAmount;

    /**
     * 该商品经过优惠后的分解金额
     */
    @ExcelProperty(value = "该商品经过优惠后的分解金额")
    private BigDecimal realAmount;

    /**
     * 赠送积分
     */
    @ExcelProperty(value = "赠送积分")
    private Long giftIntegration;

    /**
     * 赠送成长值
     */
    @ExcelProperty(value = "赠送成长值")
    private Long giftGrowth;


}
