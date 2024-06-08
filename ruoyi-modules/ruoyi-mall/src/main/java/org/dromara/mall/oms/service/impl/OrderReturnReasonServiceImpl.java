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
import org.dromara.mall.oms.domain.bo.OrderReturnReasonBo;
import org.dromara.mall.oms.domain.vo.OrderReturnReasonVo;
import org.dromara.mall.oms.domain.OrderReturnReason;
import org.dromara.mall.oms.mapper.OrderReturnReasonMapper;
import org.dromara.mall.oms.service.IOrderReturnReasonService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 退货原因Service业务层处理
 *
 * @author chan fa
 * @date 2024-06-08
 */
@RequiredArgsConstructor
@Service
public class OrderReturnReasonServiceImpl implements IOrderReturnReasonService {

    private final OrderReturnReasonMapper baseMapper;

    /**
     * 查询退货原因
     *
     * @param id 主键
     * @return 退货原因
     */
    @Override
    public OrderReturnReasonVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询退货原因列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 退货原因分页列表
     */
    @Override
    public TableDataInfo<OrderReturnReasonVo> queryPageList(OrderReturnReasonBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<OrderReturnReason> lqw = buildQueryWrapper(bo);
        Page<OrderReturnReasonVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的退货原因列表
     *
     * @param bo 查询条件
     * @return 退货原因列表
     */
    @Override
    public List<OrderReturnReasonVo> queryList(OrderReturnReasonBo bo) {
        LambdaQueryWrapper<OrderReturnReason> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<OrderReturnReason> buildQueryWrapper(OrderReturnReasonBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<OrderReturnReason> lqw = Wrappers.lambdaQuery();
        lqw.like(StringUtils.isNotBlank(bo.getName()), OrderReturnReason::getName, bo.getName());
        lqw.eq(bo.getSort() != null, OrderReturnReason::getSort, bo.getSort());
        lqw.eq(bo.getStatus() != null, OrderReturnReason::getStatus, bo.getStatus());
        return lqw;
    }

    /**
     * 新增退货原因
     *
     * @param bo 退货原因
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(OrderReturnReasonBo bo) {
        OrderReturnReason add = MapstructUtils.convert(bo, OrderReturnReason.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改退货原因
     *
     * @param bo 退货原因
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(OrderReturnReasonBo bo) {
        OrderReturnReason update = MapstructUtils.convert(bo, OrderReturnReason.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(OrderReturnReason entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除退货原因信息
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
