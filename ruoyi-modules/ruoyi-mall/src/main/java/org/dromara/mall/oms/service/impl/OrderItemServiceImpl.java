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
import org.dromara.mall.oms.domain.bo.OrderItemBo;
import org.dromara.mall.oms.domain.vo.OrderItemVo;
import org.dromara.mall.oms.domain.OrderItem;
import org.dromara.mall.oms.mapper.OrderItemMapper;
import org.dromara.mall.oms.service.IOrderItemService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 订单项信息Service业务层处理
 *
 * @author chan fa
 * @date 2024-06-08
 */
@RequiredArgsConstructor
@Service
public class OrderItemServiceImpl implements IOrderItemService {

    private final OrderItemMapper baseMapper;

    /**
     * 查询订单项信息
     *
     * @param id 主键
     * @return 订单项信息
     */
    @Override
    public OrderItemVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询订单项信息列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 订单项信息分页列表
     */
    @Override
    public TableDataInfo<OrderItemVo> queryPageList(OrderItemBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<OrderItem> lqw = buildQueryWrapper(bo);
        Page<OrderItemVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的订单项信息列表
     *
     * @param bo 查询条件
     * @return 订单项信息列表
     */
    @Override
    public List<OrderItemVo> queryList(OrderItemBo bo) {
        LambdaQueryWrapper<OrderItem> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<OrderItem> buildQueryWrapper(OrderItemBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<OrderItem> lqw = Wrappers.lambdaQuery();
        lqw.eq(bo.getOrderId() != null, OrderItem::getOrderId, bo.getOrderId());
        lqw.eq(StringUtils.isNotBlank(bo.getOrderSn()), OrderItem::getOrderSn, bo.getOrderSn());
        lqw.eq(bo.getSpuId() != null, OrderItem::getSpuId, bo.getSpuId());
        lqw.like(StringUtils.isNotBlank(bo.getSpuName()), OrderItem::getSpuName, bo.getSpuName());
        lqw.eq(StringUtils.isNotBlank(bo.getSpuPic()), OrderItem::getSpuPic, bo.getSpuPic());
        lqw.eq(StringUtils.isNotBlank(bo.getSpuBrand()), OrderItem::getSpuBrand, bo.getSpuBrand());
        lqw.eq(bo.getCategoryId() != null, OrderItem::getCategoryId, bo.getCategoryId());
        lqw.eq(bo.getSkuId() != null, OrderItem::getSkuId, bo.getSkuId());
        lqw.like(StringUtils.isNotBlank(bo.getSkuName()), OrderItem::getSkuName, bo.getSkuName());
        lqw.eq(StringUtils.isNotBlank(bo.getSkuPic()), OrderItem::getSkuPic, bo.getSkuPic());
        lqw.eq(bo.getSkuPrice() != null, OrderItem::getSkuPrice, bo.getSkuPrice());
        lqw.eq(bo.getSkuQuantity() != null, OrderItem::getSkuQuantity, bo.getSkuQuantity());
        lqw.eq(StringUtils.isNotBlank(bo.getSkuAttrsVals()), OrderItem::getSkuAttrsVals, bo.getSkuAttrsVals());
        lqw.eq(bo.getPromotionAmount() != null, OrderItem::getPromotionAmount, bo.getPromotionAmount());
        lqw.eq(bo.getCouponAmount() != null, OrderItem::getCouponAmount, bo.getCouponAmount());
        lqw.eq(bo.getIntegrationAmount() != null, OrderItem::getIntegrationAmount, bo.getIntegrationAmount());
        lqw.eq(bo.getRealAmount() != null, OrderItem::getRealAmount, bo.getRealAmount());
        lqw.eq(bo.getGiftIntegration() != null, OrderItem::getGiftIntegration, bo.getGiftIntegration());
        lqw.eq(bo.getGiftGrowth() != null, OrderItem::getGiftGrowth, bo.getGiftGrowth());
        return lqw;
    }

    /**
     * 新增订单项信息
     *
     * @param bo 订单项信息
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(OrderItemBo bo) {
        OrderItem add = MapstructUtils.convert(bo, OrderItem.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改订单项信息
     *
     * @param bo 订单项信息
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(OrderItemBo bo) {
        OrderItem update = MapstructUtils.convert(bo, OrderItem.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(OrderItem entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除订单项信息信息
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
