package org.dromara.mall.oms.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 退货原因对象 oms_order_return_reason
 *
 * @author chan fa
 * @date 2024-06-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("oms_order_return_reason")
public class OrderReturnReason extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 退货原因名
     */
    private String name;

    /**
     * 排序
     */
    private Long sort;

    /**
     * 启用状态
     */
    private Integer status;


}
