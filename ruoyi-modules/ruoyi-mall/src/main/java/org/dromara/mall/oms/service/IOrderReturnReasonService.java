package org.dromara.mall.oms.service;

import org.dromara.mall.oms.domain.vo.OrderReturnReasonVo;
import org.dromara.mall.oms.domain.bo.OrderReturnReasonBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 退货原因Service接口
 *
 * @author chan fa
 * @date 2024-06-08
 */
public interface IOrderReturnReasonService {

    /**
     * 查询退货原因
     *
     * @param id 主键
     * @return 退货原因
     */
    OrderReturnReasonVo queryById(Long id);

    /**
     * 分页查询退货原因列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 退货原因分页列表
     */
    TableDataInfo<OrderReturnReasonVo> queryPageList(OrderReturnReasonBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的退货原因列表
     *
     * @param bo 查询条件
     * @return 退货原因列表
     */
    List<OrderReturnReasonVo> queryList(OrderReturnReasonBo bo);

    /**
     * 新增退货原因
     *
     * @param bo 退货原因
     * @return 是否新增成功
     */
    Boolean insertByBo(OrderReturnReasonBo bo);

    /**
     * 修改退货原因
     *
     * @param bo 退货原因
     * @return 是否修改成功
     */
    Boolean updateByBo(OrderReturnReasonBo bo);

    /**
     * 校验并批量删除退货原因信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
