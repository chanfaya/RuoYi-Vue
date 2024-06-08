package org.dromara.mall.oms.service;

import org.dromara.mall.oms.domain.vo.OrderSettingVo;
import org.dromara.mall.oms.domain.bo.OrderSettingBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 订单配置信息Service接口
 *
 * @author chan fa
 * @date 2024-06-08
 */
public interface IOrderSettingService {

    /**
     * 查询订单配置信息
     *
     * @param id 主键
     * @return 订单配置信息
     */
    OrderSettingVo queryById(Long id);

    /**
     * 分页查询订单配置信息列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 订单配置信息分页列表
     */
    TableDataInfo<OrderSettingVo> queryPageList(OrderSettingBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的订单配置信息列表
     *
     * @param bo 查询条件
     * @return 订单配置信息列表
     */
    List<OrderSettingVo> queryList(OrderSettingBo bo);

    /**
     * 新增订单配置信息
     *
     * @param bo 订单配置信息
     * @return 是否新增成功
     */
    Boolean insertByBo(OrderSettingBo bo);

    /**
     * 修改订单配置信息
     *
     * @param bo 订单配置信息
     * @return 是否修改成功
     */
    Boolean updateByBo(OrderSettingBo bo);

    /**
     * 校验并批量删除订单配置信息信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
