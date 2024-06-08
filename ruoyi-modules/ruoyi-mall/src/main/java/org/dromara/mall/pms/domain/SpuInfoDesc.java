package org.dromara.mall.pms.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * spu信息介绍对象 pms_spu_info_desc
 *
 * @author chan fa
 * @date 2024-06-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("pms_spu_info_desc")
public class SpuInfoDesc extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 商品id
     */
    @TableId(value = "spu_id")
    private Long spuId;

    /**
     * 商品介绍
     */
    private String decript;


}
