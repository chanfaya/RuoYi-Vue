package org.dromara.mall.pms.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * spu属性值对象 pms_product_attr_value
 *
 * @author chan fa
 * @date 2024-06-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("pms_product_attr_value")
public class ProductAttrValue extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 商品id
     */
    private Long spuId;

    /**
     * 属性id
     */
    private Long attrId;

    /**
     * 属性名
     */
    private String attrName;

    /**
     * 属性值
     */
    private String attrValue;

    /**
     * 顺序
     */
    private Long attrSort;

    /**
     * 快速展示【是否展示在介绍上；0-否 1-是】
     */
    private Long quickShow;


}
