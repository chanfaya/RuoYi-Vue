package org.dromara.mall.oms.service;

import org.dromara.mall.oms.domain.vo.OrderReturnApplyVo;
import org.dromara.mall.oms.domain.bo.OrderReturnApplyBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 订单退货申请Service接口
 *
 * @author chan fa
 * @date 2024-06-08
 */
public interface IOrderReturnApplyService {

    /**
     * 查询订单退货申请
     *
     * @param id 主键
     * @return 订单退货申请
     */
    OrderReturnApplyVo queryById(Long id);

    /**
     * 分页查询订单退货申请列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 订单退货申请分页列表
     */
    TableDataInfo<OrderReturnApplyVo> queryPageList(OrderReturnApplyBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的订单退货申请列表
     *
     * @param bo 查询条件
     * @return 订单退货申请列表
     */
    List<OrderReturnApplyVo> queryList(OrderReturnApplyBo bo);

    /**
     * 新增订单退货申请
     *
     * @param bo 订单退货申请
     * @return 是否新增成功
     */
    Boolean insertByBo(OrderReturnApplyBo bo);

    /**
     * 修改订单退货申请
     *
     * @param bo 订单退货申请
     * @return 是否修改成功
     */
    Boolean updateByBo(OrderReturnApplyBo bo);

    /**
     * 校验并批量删除订单退货申请信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
