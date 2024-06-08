package org.dromara.mall.oms.service;

import org.dromara.mall.oms.domain.vo.OrderItemVo;
import org.dromara.mall.oms.domain.bo.OrderItemBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 订单项信息Service接口
 *
 * @author chan fa
 * @date 2024-06-08
 */
public interface IOrderItemService {

    /**
     * 查询订单项信息
     *
     * @param id 主键
     * @return 订单项信息
     */
    OrderItemVo queryById(Long id);

    /**
     * 分页查询订单项信息列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 订单项信息分页列表
     */
    TableDataInfo<OrderItemVo> queryPageList(OrderItemBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的订单项信息列表
     *
     * @param bo 查询条件
     * @return 订单项信息列表
     */
    List<OrderItemVo> queryList(OrderItemBo bo);

    /**
     * 新增订单项信息
     *
     * @param bo 订单项信息
     * @return 是否新增成功
     */
    Boolean insertByBo(OrderItemBo bo);

    /**
     * 修改订单项信息
     *
     * @param bo 订单项信息
     * @return 是否修改成功
     */
    Boolean updateByBo(OrderItemBo bo);

    /**
     * 校验并批量删除订单项信息信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
