package org.dromara.mall.pms.domain.vo;

import java.math.BigDecimal;
import org.dromara.mall.pms.domain.SpuInfo;
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
 * spu信息视图对象 pms_spu_info
 *
 * @author chan fa
 * @date 2024-06-08
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = SpuInfo.class)
public class SpuInfoVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 商品id
     */
    @ExcelProperty(value = "商品id")
    private Long id;

    /**
     * 商品名称
     */
    @ExcelProperty(value = "商品名称")
    private String spuName;

    /**
     * 商品描述
     */
    @ExcelProperty(value = "商品描述")
    private String spuDescription;

    /**
     * 所属分类id
     */
    @ExcelProperty(value = "所属分类id")
    private Long catalogId;

    /**
     * 品牌id
     */
    @ExcelProperty(value = "品牌id")
    private Long brandId;

    /**
     * 
     */
    @ExcelProperty(value = "")
    private BigDecimal weight;

    /**
     * 上架状态[0 - 下架，1 - 上架]
     */
    @ExcelProperty(value = "上架状态[0 - 下架，1 - 上架]")
    private Long publishStatus;


}
