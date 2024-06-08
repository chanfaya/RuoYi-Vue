package org.dromara.mall.pms.domain.vo;

import org.dromara.mall.pms.domain.AttrAttrgroupRelation;
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
 * 属性&属性分组关联视图对象 pms_attr_attrgroup_relation
 *
 * @author chan fa
 * @date 2024-06-08
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = AttrAttrgroupRelation.class)
public class AttrAttrgroupRelationVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    @ExcelProperty(value = "")
    private Long id;

    /**
     * 属性id
     */
    @ExcelProperty(value = "属性id")
    private Long attrId;

    /**
     * 属性分组id
     */
    @ExcelProperty(value = "属性分组id")
    private Long attrGroupId;

    /**
     * 属性组内排序
     */
    @ExcelProperty(value = "属性组内排序")
    private Long attrSort;


}
