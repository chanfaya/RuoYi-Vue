package org.dromara.mall.pms.domain.bo;

import org.dromara.mall.pms.domain.SpuImages;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * spu图片业务对象 pms_spu_images
 *
 * @author chan fa
 * @date 2024-06-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = SpuImages.class, reverseConvertGenerate = false)
public class SpuImagesBo extends BaseEntity {

    /**
     * 
     */
    @NotNull(message = "不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * spu_id
     */
    @NotNull(message = "spu_id不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long spuId;

    /**
     * 图片名
     */
    @NotBlank(message = "图片名不能为空", groups = { AddGroup.class, EditGroup.class })
    private String imgName;

    /**
     * 图片地址
     */
    @NotBlank(message = "图片地址不能为空", groups = { AddGroup.class, EditGroup.class })
    private String imgUrl;

    /**
     * 顺序
     */
    @NotNull(message = "顺序不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long imgSort;

    /**
     * 是否默认图
     */
    @NotNull(message = "是否默认图不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long defaultImg;


}
