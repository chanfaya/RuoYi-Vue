package org.dromara.mall.oms.service;

import org.dromara.mall.oms.domain.vo.RefundInfoVo;
import org.dromara.mall.oms.domain.bo.RefundInfoBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 退款信息Service接口
 *
 * @author chan fa
 * @date 2024-06-08
 */
public interface IRefundInfoService {

    /**
     * 查询退款信息
     *
     * @param id 主键
     * @return 退款信息
     */
    RefundInfoVo queryById(Long id);

    /**
     * 分页查询退款信息列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 退款信息分页列表
     */
    TableDataInfo<RefundInfoVo> queryPageList(RefundInfoBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的退款信息列表
     *
     * @param bo 查询条件
     * @return 退款信息列表
     */
    List<RefundInfoVo> queryList(RefundInfoBo bo);

    /**
     * 新增退款信息
     *
     * @param bo 退款信息
     * @return 是否新增成功
     */
    Boolean insertByBo(RefundInfoBo bo);

    /**
     * 修改退款信息
     *
     * @param bo 退款信息
     * @return 是否修改成功
     */
    Boolean updateByBo(RefundInfoBo bo);

    /**
     * 校验并批量删除退款信息信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
