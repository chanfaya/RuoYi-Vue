package org.dromara.mall.oms.service.impl;

import org.dromara.common.core.utils.MapstructUtils;
import org.dromara.common.core.utils.StringUtils;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.dromara.mall.oms.domain.bo.PaymentInfoBo;
import org.dromara.mall.oms.domain.vo.PaymentInfoVo;
import org.dromara.mall.oms.domain.PaymentInfo;
import org.dromara.mall.oms.mapper.PaymentInfoMapper;
import org.dromara.mall.oms.service.IPaymentInfoService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 支付信息Service业务层处理
 *
 * @author chan fa
 * @date 2024-06-08
 */
@RequiredArgsConstructor
@Service
public class PaymentInfoServiceImpl implements IPaymentInfoService {

    private final PaymentInfoMapper baseMapper;

    /**
     * 查询支付信息
     *
     * @param id 主键
     * @return 支付信息
     */
    @Override
    public PaymentInfoVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询支付信息列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 支付信息分页列表
     */
    @Override
    public TableDataInfo<PaymentInfoVo> queryPageList(PaymentInfoBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<PaymentInfo> lqw = buildQueryWrapper(bo);
        Page<PaymentInfoVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的支付信息列表
     *
     * @param bo 查询条件
     * @return 支付信息列表
     */
    @Override
    public List<PaymentInfoVo> queryList(PaymentInfoBo bo) {
        LambdaQueryWrapper<PaymentInfo> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<PaymentInfo> buildQueryWrapper(PaymentInfoBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<PaymentInfo> lqw = Wrappers.lambdaQuery();
        lqw.eq(StringUtils.isNotBlank(bo.getOrderSn()), PaymentInfo::getOrderSn, bo.getOrderSn());
        lqw.eq(bo.getOrderId() != null, PaymentInfo::getOrderId, bo.getOrderId());
        lqw.eq(StringUtils.isNotBlank(bo.getAlipayTradeNo()), PaymentInfo::getAlipayTradeNo, bo.getAlipayTradeNo());
        lqw.eq(bo.getTotalAmount() != null, PaymentInfo::getTotalAmount, bo.getTotalAmount());
        lqw.eq(StringUtils.isNotBlank(bo.getSubject()), PaymentInfo::getSubject, bo.getSubject());
        lqw.eq(StringUtils.isNotBlank(bo.getPaymentStatus()), PaymentInfo::getPaymentStatus, bo.getPaymentStatus());
        lqw.eq(bo.getConfirmTime() != null, PaymentInfo::getConfirmTime, bo.getConfirmTime());
        lqw.eq(StringUtils.isNotBlank(bo.getCallbackContent()), PaymentInfo::getCallbackContent, bo.getCallbackContent());
        lqw.eq(bo.getCallbackTime() != null, PaymentInfo::getCallbackTime, bo.getCallbackTime());
        return lqw;
    }

    /**
     * 新增支付信息
     *
     * @param bo 支付信息
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(PaymentInfoBo bo) {
        PaymentInfo add = MapstructUtils.convert(bo, PaymentInfo.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改支付信息
     *
     * @param bo 支付信息
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(PaymentInfoBo bo) {
        PaymentInfo update = MapstructUtils.convert(bo, PaymentInfo.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(PaymentInfo entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除支付信息信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteBatchIds(ids) > 0;
    }
}
