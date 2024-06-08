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
import org.dromara.mall.oms.domain.bo.OrderOperateHistoryBo;
import org.dromara.mall.oms.domain.vo.OrderOperateHistoryVo;
import org.dromara.mall.oms.domain.OrderOperateHistory;
import org.dromara.mall.oms.mapper.OrderOperateHistoryMapper;
import org.dromara.mall.oms.service.IOrderOperateHistoryService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 订单操作历史记录Service业务层处理
 *
 * @author chan fa
 * @date 2024-06-08
 */
@RequiredArgsConstructor
@Service
public class OrderOperateHistoryServiceImpl implements IOrderOperateHistoryService {

    private final OrderOperateHistoryMapper baseMapper;

    /**
     * 查询订单操作历史记录
     *
     * @param id 主键
     * @return 订单操作历史记录
     */
    @Override
    public OrderOperateHistoryVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询订单操作历史记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 订单操作历史记录分页列表
     */
    @Override
    public TableDataInfo<OrderOperateHistoryVo> queryPageList(OrderOperateHistoryBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<OrderOperateHistory> lqw = buildQueryWrapper(bo);
        Page<OrderOperateHistoryVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的订单操作历史记录列表
     *
     * @param bo 查询条件
     * @return 订单操作历史记录列表
     */
    @Override
    public List<OrderOperateHistoryVo> queryList(OrderOperateHistoryBo bo) {
        LambdaQueryWrapper<OrderOperateHistory> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<OrderOperateHistory> buildQueryWrapper(OrderOperateHistoryBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<OrderOperateHistory> lqw = Wrappers.lambdaQuery();
        lqw.eq(bo.getOrderId() != null, OrderOperateHistory::getOrderId, bo.getOrderId());
        lqw.eq(StringUtils.isNotBlank(bo.getOperateMan()), OrderOperateHistory::getOperateMan, bo.getOperateMan());
        lqw.eq(bo.getOrderStatus() != null, OrderOperateHistory::getOrderStatus, bo.getOrderStatus());
        lqw.eq(StringUtils.isNotBlank(bo.getNote()), OrderOperateHistory::getNote, bo.getNote());
        return lqw;
    }

    /**
     * 新增订单操作历史记录
     *
     * @param bo 订单操作历史记录
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(OrderOperateHistoryBo bo) {
        OrderOperateHistory add = MapstructUtils.convert(bo, OrderOperateHistory.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改订单操作历史记录
     *
     * @param bo 订单操作历史记录
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(OrderOperateHistoryBo bo) {
        OrderOperateHistory update = MapstructUtils.convert(bo, OrderOperateHistory.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(OrderOperateHistory entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除订单操作历史记录信息
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
