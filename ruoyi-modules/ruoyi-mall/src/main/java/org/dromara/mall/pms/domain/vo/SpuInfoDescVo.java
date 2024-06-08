package org.dromara.mall.pms.domain.vo;

import org.dromara.mall.pms.domain.SpuInfoDesc;
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
 * spu信息介绍视图对象 pms_spu_info_desc
 *
 * @author chan fa
 * @date 2024-06-08
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = SpuInfoDesc.class)
public class SpuInfoDescVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 商品id
     */
    @ExcelProperty(value = "商品id")
    private Long spuId;

    /**
     * 商品介绍
     */
    @ExcelProperty(value = "商品介绍")
    private String decript;


}
