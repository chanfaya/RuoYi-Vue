package org.dromara.mall.oms.service;

import org.dromara.mall.oms.domain.vo.OrderVo;
import org.dromara.mall.oms.domain.bo.OrderBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 订单Service接口
 *
 * @author chan fa
 * @date 2024-06-08
 */
public interface IOrderService {

    /**
     * 查询订单
     *
     * @param id 主键
     * @return 订单
     */
    OrderVo queryById(Long id);

    /**
     * 分页查询订单列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 订单分页列表
     */
    TableDataInfo<OrderVo> queryPageList(OrderBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的订单列表
     *
     * @param bo 查询条件
     * @return 订单列表
     */
    List<OrderVo> queryList(OrderBo bo);

    /**
     * 新增订单
     *
     * @param bo 订单
     * @return 是否新增成功
     */
    Boolean insertByBo(OrderBo bo);

    /**
     * 修改订单
     *
     * @param bo 订单
     * @return 是否修改成功
     */
    Boolean updateByBo(OrderBo bo);

    /**
     * 校验并批量删除订单信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
