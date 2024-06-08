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
import org.dromara.mall.oms.domain.bo.OrderSettingBo;
import org.dromara.mall.oms.domain.vo.OrderSettingVo;
import org.dromara.mall.oms.domain.OrderSetting;
import org.dromara.mall.oms.mapper.OrderSettingMapper;
import org.dromara.mall.oms.service.IOrderSettingService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 订单配置信息Service业务层处理
 *
 * @author chan fa
 * @date 2024-06-08
 */
@RequiredArgsConstructor
@Service
public class OrderSettingServiceImpl implements IOrderSettingService {

    private final OrderSettingMapper baseMapper;

    /**
     * 查询订单配置信息
     *
     * @param id 主键
     * @return 订单配置信息
     */
    @Override
    public OrderSettingVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询订单配置信息列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 订单配置信息分页列表
     */
    @Override
    public TableDataInfo<OrderSettingVo> queryPageList(OrderSettingBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<OrderSetting> lqw = buildQueryWrapper(bo);
        Page<OrderSettingVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的订单配置信息列表
     *
     * @param bo 查询条件
     * @return 订单配置信息列表
     */
    @Override
    public List<OrderSettingVo> queryList(OrderSettingBo bo) {
        LambdaQueryWrapper<OrderSetting> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<OrderSetting> buildQueryWrapper(OrderSettingBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<OrderSetting> lqw = Wrappers.lambdaQuery();
        lqw.eq(bo.getFlashOrderOvertime() != null, OrderSetting::getFlashOrderOvertime, bo.getFlashOrderOvertime());
        lqw.eq(bo.getNormalOrderOvertime() != null, OrderSetting::getNormalOrderOvertime, bo.getNormalOrderOvertime());
        lqw.eq(bo.getConfirmOvertime() != null, OrderSetting::getConfirmOvertime, bo.getConfirmOvertime());
        lqw.eq(bo.getFinishOvertime() != null, OrderSetting::getFinishOvertime, bo.getFinishOvertime());
        lqw.eq(bo.getCommentOvertime() != null, OrderSetting::getCommentOvertime, bo.getCommentOvertime());
        lqw.eq(bo.getMemberLevel() != null, OrderSetting::getMemberLevel, bo.getMemberLevel());
        return lqw;
    }

    /**
     * 新增订单配置信息
     *
     * @param bo 订单配置信息
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(OrderSettingBo bo) {
        OrderSetting add = MapstructUtils.convert(bo, OrderSetting.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改订单配置信息
     *
     * @param bo 订单配置信息
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(OrderSettingBo bo) {
        OrderSetting update = MapstructUtils.convert(bo, OrderSetting.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(OrderSetting entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除订单配置信息信息
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
