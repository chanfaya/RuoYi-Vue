package org.dromara.mall.oms.domain.bo;

import org.dromara.mall.oms.domain.OrderOperateHistory;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 订单操作历史记录业务对象 oms_order_operate_history
 *
 * @author chan fa
 * @date 2024-06-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = OrderOperateHistory.class, reverseConvertGenerate = false)
public class OrderOperateHistoryBo extends BaseEntity {

    /**
     * 
     */
    @NotNull(message = "不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 订单id
     */
    @NotNull(message = "订单id不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long orderId;

    /**
     * 操作人[用户；系统；后台管理员]
     */
    @NotBlank(message = "操作人[用户；系统；后台管理员]不能为空", groups = { AddGroup.class, EditGroup.class })
    private String operateMan;

    /**
     * 订单状态【0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单】
     */
    @NotNull(message = "订单状态【0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单】不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long orderStatus;

    /**
     * 备注
     */
    @NotBlank(message = "备注不能为空", groups = { AddGroup.class, EditGroup.class })
    private String note;


}
