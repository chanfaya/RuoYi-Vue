package org.dromara.mall.pms.domain.vo;

import org.dromara.mall.pms.domain.SkuSaleAttrValue;
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
 * sku销售属性&值视图对象 pms_sku_sale_attr_value
 *
 * @author chan fa
 * @date 2024-06-08
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = SkuSaleAttrValue.class)
public class SkuSaleAttrValueVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    @ExcelProperty(value = "")
    private Long id;

    /**
     * sku_id
     */
    @ExcelProperty(value = "sku_id")
    private Long skuId;

    /**
     * attr_id
     */
    @ExcelProperty(value = "attr_id")
    private Long attrId;

    /**
     * 销售属性名
     */
    @ExcelProperty(value = "销售属性名")
    private String attrName;

    /**
     * 销售属性值
     */
    @ExcelProperty(value = "销售属性值")
    private String attrValue;

    /**
     * 顺序
     */
    @ExcelProperty(value = "顺序")
    private Long attrSort;


}
