package org.dromara.mall.oms.service;

import org.dromara.mall.oms.domain.vo.OrderOperateHistoryVo;
import org.dromara.mall.oms.domain.bo.OrderOperateHistoryBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 订单操作历史记录Service接口
 *
 * @author chan fa
 * @date 2024-06-08
 */
public interface IOrderOperateHistoryService {

    /**
     * 查询订单操作历史记录
     *
     * @param id 主键
     * @return 订单操作历史记录
     */
    OrderOperateHistoryVo queryById(Long id);

    /**
     * 分页查询订单操作历史记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 订单操作历史记录分页列表
     */
    TableDataInfo<OrderOperateHistoryVo> queryPageList(OrderOperateHistoryBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的订单操作历史记录列表
     *
     * @param bo 查询条件
     * @return 订单操作历史记录列表
     */
    List<OrderOperateHistoryVo> queryList(OrderOperateHistoryBo bo);

    /**
     * 新增订单操作历史记录
     *
     * @param bo 订单操作历史记录
     * @return 是否新增成功
     */
    Boolean insertByBo(OrderOperateHistoryBo bo);

    /**
     * 修改订单操作历史记录
     *
     * @param bo 订单操作历史记录
     * @return 是否修改成功
     */
    Boolean updateByBo(OrderOperateHistoryBo bo);

    /**
     * 校验并批量删除订单操作历史记录信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
