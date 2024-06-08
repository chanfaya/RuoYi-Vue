package org.dromara.mall.oms.domain.vo;

import org.dromara.mall.oms.domain.OrderReturnReason;
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
 * 退货原因视图对象 oms_order_return_reason
 *
 * @author chan fa
 * @date 2024-06-08
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = OrderReturnReason.class)
public class OrderReturnReasonVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    @ExcelProperty(value = "")
    private Long id;

    /**
     * 退货原因名
     */
    @ExcelProperty(value = "退货原因名")
    private String name;

    /**
     * 排序
     */
    @ExcelProperty(value = "排序")
    private Long sort;

    /**
     * 启用状态
     */
    @ExcelProperty(value = "启用状态")
    private Integer status;


}
