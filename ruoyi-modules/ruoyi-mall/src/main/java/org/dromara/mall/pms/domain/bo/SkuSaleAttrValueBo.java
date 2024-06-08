package org.dromara.mall.pms.domain.bo;

import org.dromara.mall.pms.domain.SkuSaleAttrValue;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * sku销售属性&值业务对象 pms_sku_sale_attr_value
 *
 * @author chan fa
 * @date 2024-06-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = SkuSaleAttrValue.class, reverseConvertGenerate = false)
public class SkuSaleAttrValueBo extends BaseEntity {

    /**
     * 
     */
    @NotNull(message = "不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * sku_id
     */
    @NotNull(message = "sku_id不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long skuId;

    /**
     * attr_id
     */
    @NotNull(message = "attr_id不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long attrId;

    /**
     * 销售属性名
     */
    @NotBlank(message = "销售属性名不能为空", groups = { AddGroup.class, EditGroup.class })
    private String attrName;

    /**
     * 销售属性值
     */
    @NotBlank(message = "销售属性值不能为空", groups = { AddGroup.class, EditGroup.class })
    private String attrValue;

    /**
     * 顺序
     */
    @NotNull(message = "顺序不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long attrSort;


}
