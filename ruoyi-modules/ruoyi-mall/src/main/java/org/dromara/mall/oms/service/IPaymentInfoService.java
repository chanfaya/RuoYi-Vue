package org.dromara.mall.oms.service;

import org.dromara.mall.oms.domain.vo.PaymentInfoVo;
import org.dromara.mall.oms.domain.bo.PaymentInfoBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 支付信息Service接口
 *
 * @author chan fa
 * @date 2024-06-08
 */
public interface IPaymentInfoService {

    /**
     * 查询支付信息
     *
     * @param id 主键
     * @return 支付信息
     */
    PaymentInfoVo queryById(Long id);

    /**
     * 分页查询支付信息列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 支付信息分页列表
     */
    TableDataInfo<PaymentInfoVo> queryPageList(PaymentInfoBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的支付信息列表
     *
     * @param bo 查询条件
     * @return 支付信息列表
     */
    List<PaymentInfoVo> queryList(PaymentInfoBo bo);

    /**
     * 新增支付信息
     *
     * @param bo 支付信息
     * @return 是否新增成功
     */
    Boolean insertByBo(PaymentInfoBo bo);

    /**
     * 修改支付信息
     *
     * @param bo 支付信息
     * @return 是否修改成功
     */
    Boolean updateByBo(PaymentInfoBo bo);

    /**
     * 校验并批量删除支付信息信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
