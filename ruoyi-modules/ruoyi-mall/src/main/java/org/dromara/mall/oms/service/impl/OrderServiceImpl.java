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
import org.dromara.mall.oms.domain.bo.OrderBo;
import org.dromara.mall.oms.domain.vo.OrderVo;
import org.dromara.mall.oms.domain.Order;
import org.dromara.mall.oms.mapper.OrderMapper;
import org.dromara.mall.oms.service.IOrderService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 订单Service业务层处理
 *
 * @author chan fa
 * @date 2024-06-08
 */
@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements IOrderService {

    private final OrderMapper baseMapper;

    /**
     * 查询订单
     *
     * @param id 主键
     * @return 订单
     */
    @Override
    public OrderVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询订单列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 订单分页列表
     */
    @Override
    public TableDataInfo<OrderVo> queryPageList(OrderBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<Order> lqw = buildQueryWrapper(bo);
        Page<OrderVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的订单列表
     *
     * @param bo 查询条件
     * @return 订单列表
     */
    @Override
    public List<OrderVo> queryList(OrderBo bo) {
        LambdaQueryWrapper<Order> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<Order> buildQueryWrapper(OrderBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<Order> lqw = Wrappers.lambdaQuery();
        lqw.eq(bo.getMemberId() != null, Order::getMemberId, bo.getMemberId());
        lqw.eq(StringUtils.isNotBlank(bo.getOrderSn()), Order::getOrderSn, bo.getOrderSn());
        lqw.eq(bo.getCouponId() != null, Order::getCouponId, bo.getCouponId());
        lqw.like(StringUtils.isNotBlank(bo.getMemberUsername()), Order::getMemberUsername, bo.getMemberUsername());
        lqw.eq(bo.getTotalAmount() != null, Order::getTotalAmount, bo.getTotalAmount());
        lqw.eq(bo.getPayAmount() != null, Order::getPayAmount, bo.getPayAmount());
        lqw.eq(bo.getFreightAmount() != null, Order::getFreightAmount, bo.getFreightAmount());
        lqw.eq(bo.getPromotionAmount() != null, Order::getPromotionAmount, bo.getPromotionAmount());
        lqw.eq(bo.getIntegrationAmount() != null, Order::getIntegrationAmount, bo.getIntegrationAmount());
        lqw.eq(bo.getCouponAmount() != null, Order::getCouponAmount, bo.getCouponAmount());
        lqw.eq(bo.getDiscountAmount() != null, Order::getDiscountAmount, bo.getDiscountAmount());
        lqw.eq(bo.getPayType() != null, Order::getPayType, bo.getPayType());
        lqw.eq(bo.getSourceType() != null, Order::getSourceType, bo.getSourceType());
        lqw.eq(bo.getStatus() != null, Order::getStatus, bo.getStatus());
        lqw.eq(StringUtils.isNotBlank(bo.getDeliveryCompany()), Order::getDeliveryCompany, bo.getDeliveryCompany());
        lqw.eq(StringUtils.isNotBlank(bo.getDeliverySn()), Order::getDeliverySn, bo.getDeliverySn());
        lqw.eq(bo.getAutoConfirmDay() != null, Order::getAutoConfirmDay, bo.getAutoConfirmDay());
        lqw.eq(bo.getIntegration() != null, Order::getIntegration, bo.getIntegration());
        lqw.eq(bo.getGrowth() != null, Order::getGrowth, bo.getGrowth());
        lqw.eq(bo.getBillType() != null, Order::getBillType, bo.getBillType());
        lqw.eq(StringUtils.isNotBlank(bo.getBillHeader()), Order::getBillHeader, bo.getBillHeader());
        lqw.eq(StringUtils.isNotBlank(bo.getBillContent()), Order::getBillContent, bo.getBillContent());
        lqw.eq(StringUtils.isNotBlank(bo.getBillReceiverPhone()), Order::getBillReceiverPhone, bo.getBillReceiverPhone());
        lqw.eq(StringUtils.isNotBlank(bo.getBillReceiverEmail()), Order::getBillReceiverEmail, bo.getBillReceiverEmail());
        lqw.like(StringUtils.isNotBlank(bo.getReceiverName()), Order::getReceiverName, bo.getReceiverName());
        lqw.eq(StringUtils.isNotBlank(bo.getReceiverPhone()), Order::getReceiverPhone, bo.getReceiverPhone());
        lqw.eq(StringUtils.isNotBlank(bo.getReceiverPostCode()), Order::getReceiverPostCode, bo.getReceiverPostCode());
        lqw.eq(StringUtils.isNotBlank(bo.getReceiverProvince()), Order::getReceiverProvince, bo.getReceiverProvince());
        lqw.eq(StringUtils.isNotBlank(bo.getReceiverCity()), Order::getReceiverCity, bo.getReceiverCity());
        lqw.eq(StringUtils.isNotBlank(bo.getReceiverRegion()), Order::getReceiverRegion, bo.getReceiverRegion());
        lqw.eq(StringUtils.isNotBlank(bo.getReceiverDetailAddress()), Order::getReceiverDetailAddress, bo.getReceiverDetailAddress());
        lqw.eq(StringUtils.isNotBlank(bo.getNote()), Order::getNote, bo.getNote());
        lqw.eq(bo.getConfirmStatus() != null, Order::getConfirmStatus, bo.getConfirmStatus());
        lqw.eq(bo.getDeleteStatus() != null, Order::getDeleteStatus, bo.getDeleteStatus());
        lqw.eq(bo.getUseIntegration() != null, Order::getUseIntegration, bo.getUseIntegration());
        lqw.eq(bo.getPaymentTime() != null, Order::getPaymentTime, bo.getPaymentTime());
        lqw.eq(bo.getDeliveryTime() != null, Order::getDeliveryTime, bo.getDeliveryTime());
        lqw.eq(bo.getReceiveTime() != null, Order::getReceiveTime, bo.getReceiveTime());
        lqw.eq(bo.getCommentTime() != null, Order::getCommentTime, bo.getCommentTime());
        lqw.eq(bo.getModifyTime() != null, Order::getModifyTime, bo.getModifyTime());
        return lqw;
    }

    /**
     * 新增订单
     *
     * @param bo 订单
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(OrderBo bo) {
        Order add = MapstructUtils.convert(bo, Order.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改订单
     *
     * @param bo 订单
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(OrderBo bo) {
        Order update = MapstructUtils.convert(bo, Order.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(Order entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除订单信息
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
