package org.dromara.mall.pms.domain.bo;

import org.dromara.mall.pms.domain.SpuInfoDesc;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * spu信息介绍业务对象 pms_spu_info_desc
 *
 * @author chan fa
 * @date 2024-06-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = SpuInfoDesc.class, reverseConvertGenerate = false)
public class SpuInfoDescBo extends BaseEntity {

    /**
     * 商品id
     */
    @NotNull(message = "商品id不能为空", groups = { EditGroup.class })
    private Long spuId;

    /**
     * 商品介绍
     */
    @NotBlank(message = "商品介绍不能为空", groups = { AddGroup.class, EditGroup.class })
    private String decript;


}
