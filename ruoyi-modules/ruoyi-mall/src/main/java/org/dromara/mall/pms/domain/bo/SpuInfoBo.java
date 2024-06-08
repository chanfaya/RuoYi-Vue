package org.dromara.mall.pms.domain.bo;

import org.dromara.mall.pms.domain.SpuInfo;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;

/**
 * spu信息业务对象 pms_spu_info
 *
 * @author chan fa
 * @date 2024-06-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = SpuInfo.class, reverseConvertGenerate = false)
public class SpuInfoBo extends BaseEntity {

    /**
     * 商品id
     */
    @NotNull(message = "商品id不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 商品名称
     */
    @NotBlank(message = "商品名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String spuName;

    /**
     * 商品描述
     */
    @NotBlank(message = "商品描述不能为空", groups = { AddGroup.class, EditGroup.class })
    private String spuDescription;

    /**
     * 所属分类id
     */
    @NotNull(message = "所属分类id不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long catalogId;

    /**
     * 品牌id
     */
    @NotNull(message = "品牌id不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long brandId;

    /**
     * 
     */
    @NotNull(message = "不能为空", groups = { AddGroup.class, EditGroup.class })
    private BigDecimal weight;

    /**
     * 上架状态[0 - 下架，1 - 上架]
     */
    @NotNull(message = "上架状态[0 - 下架，1 - 上架]不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long publishStatus;


}
