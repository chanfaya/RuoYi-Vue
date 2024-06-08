package org.dromara.mall.oms.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 订单操作历史记录对象 oms_order_operate_history
 *
 * @author chan fa
 * @date 2024-06-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("oms_order_operate_history")
public class OrderOperateHistory extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 订单id
     */
    private Long orderId;

    /**
     * 操作人[用户；系统；后台管理员]
     */
    private String operateMan;

    /**
     * 订单状态【0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单】
     */
    private Long orderStatus;

    /**
     * 备注
     */
    private String note;


}
