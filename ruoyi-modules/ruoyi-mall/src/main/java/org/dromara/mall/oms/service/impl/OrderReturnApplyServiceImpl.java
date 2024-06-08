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
import org.dromara.mall.oms.domain.bo.OrderReturnApplyBo;
import org.dromara.mall.oms.domain.vo.OrderReturnApplyVo;
import org.dromara.mall.oms.domain.OrderReturnApply;
import org.dromara.mall.oms.mapper.OrderReturnApplyMapper;
import org.dromara.mall.oms.service.IOrderReturnApplyService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 订单退货申请Service业务层处理
 *
 * @author chan fa
 * @date 2024-06-08
 */
@RequiredArgsConstructor
@Service
public class OrderReturnApplyServiceImpl implements IOrderReturnApplyService {

    private final OrderReturnApplyMapper baseMapper;

    /**
     * 查询订单退货申请
     *
     * @param id 主键
     * @return 订单退货申请
     */
    @Override
    public OrderReturnApplyVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询订单退货申请列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 订单退货申请分页列表
     */
    @Override
    public TableDataInfo<OrderReturnApplyVo> queryPageList(OrderReturnApplyBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<OrderReturnApply> lqw = buildQueryWrapper(bo);
        Page<OrderReturnApplyVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的订单退货申请列表
     *
     * @param bo 查询条件
     * @return 订单退货申请列表
     */
    @Override
    public List<OrderReturnApplyVo> queryList(OrderReturnApplyBo bo) {
        LambdaQueryWrapper<OrderReturnApply> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<OrderReturnApply> buildQueryWrapper(OrderReturnApplyBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<OrderReturnApply> lqw = Wrappers.lambdaQuery();
        lqw.eq(bo.getOrderId() != null, OrderReturnApply::getOrderId, bo.getOrderId());
        lqw.eq(bo.getSkuId() != null, OrderReturnApply::getSkuId, bo.getSkuId());
        lqw.eq(StringUtils.isNotBlank(bo.getOrderSn()), OrderReturnApply::getOrderSn, bo.getOrderSn());
        lqw.like(StringUtils.isNotBlank(bo.getMemberUsername()), OrderReturnApply::getMemberUsername, bo.getMemberUsername());
        lqw.eq(bo.getReturnAmount() != null, OrderReturnApply::getReturnAmount, bo.getReturnAmount());
        lqw.like(StringUtils.isNotBlank(bo.getReturnName()), OrderReturnApply::getReturnName, bo.getReturnName());
        lqw.eq(StringUtils.isNotBlank(bo.getReturnPhone()), OrderReturnApply::getReturnPhone, bo.getReturnPhone());
        lqw.eq(bo.getStatus() != null, OrderReturnApply::getStatus, bo.getStatus());
        lqw.eq(bo.getHandleTime() != null, OrderReturnApply::getHandleTime, bo.getHandleTime());
        lqw.eq(StringUtils.isNotBlank(bo.getSkuImg()), OrderReturnApply::getSkuImg, bo.getSkuImg());
        lqw.like(StringUtils.isNotBlank(bo.getSkuName()), OrderReturnApply::getSkuName, bo.getSkuName());
        lqw.eq(StringUtils.isNotBlank(bo.getSkuBrand()), OrderReturnApply::getSkuBrand, bo.getSkuBrand());
        lqw.eq(StringUtils.isNotBlank(bo.getSkuAttrsVals()), OrderReturnApply::getSkuAttrsVals, bo.getSkuAttrsVals());
        lqw.eq(bo.getSkuCount() != null, OrderReturnApply::getSkuCount, bo.getSkuCount());
        lqw.eq(bo.getSkuPrice() != null, OrderReturnApply::getSkuPrice, bo.getSkuPrice());
        lqw.eq(bo.getSkuRealPrice() != null, OrderReturnApply::getSkuRealPrice, bo.getSkuRealPrice());
        lqw.eq(StringUtils.isNotBlank(bo.getReason()), OrderReturnApply::getReason, bo.getReason());
        lqw.eq(StringUtils.isNotBlank(bo.getDescription述()), OrderReturnApply::getDescription述, bo.getDescription述());
        lqw.eq(StringUtils.isNotBlank(bo.getDescPics()), OrderReturnApply::getDescPics, bo.getDescPics());
        lqw.eq(StringUtils.isNotBlank(bo.getHandleNote()), OrderReturnApply::getHandleNote, bo.getHandleNote());
        lqw.eq(StringUtils.isNotBlank(bo.getHandleMan()), OrderReturnApply::getHandleMan, bo.getHandleMan());
        lqw.eq(StringUtils.isNotBlank(bo.getReceiveMan()), OrderReturnApply::getReceiveMan, bo.getReceiveMan());
        lqw.eq(bo.getReceiveTime() != null, OrderReturnApply::getReceiveTime, bo.getReceiveTime());
        lqw.eq(StringUtils.isNotBlank(bo.getReceiveNote()), OrderReturnApply::getReceiveNote, bo.getReceiveNote());
        lqw.eq(StringUtils.isNotBlank(bo.getReceivePhone()), OrderReturnApply::getReceivePhone, bo.getReceivePhone());
        lqw.eq(StringUtils.isNotBlank(bo.getCompanyAddress()), OrderReturnApply::getCompanyAddress, bo.getCompanyAddress());
        return lqw;
    }

    /**
     * 新增订单退货申请
     *
     * @param bo 订单退货申请
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(OrderReturnApplyBo bo) {
        OrderReturnApply add = MapstructUtils.convert(bo, OrderReturnApply.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改订单退货申请
     *
     * @param bo 订单退货申请
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(OrderReturnApplyBo bo) {
        OrderReturnApply update = MapstructUtils.convert(bo, OrderReturnApply.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(OrderReturnApply entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除订单退货申请信息
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
