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
import org.dromara.mall.oms.domain.bo.RefundInfoBo;
import org.dromara.mall.oms.domain.vo.RefundInfoVo;
import org.dromara.mall.oms.domain.RefundInfo;
import org.dromara.mall.oms.mapper.RefundInfoMapper;
import org.dromara.mall.oms.service.IRefundInfoService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 退款信息Service业务层处理
 *
 * @author chan fa
 * @date 2024-06-08
 */
@RequiredArgsConstructor
@Service
public class RefundInfoServiceImpl implements IRefundInfoService {

    private final RefundInfoMapper baseMapper;

    /**
     * 查询退款信息
     *
     * @param id 主键
     * @return 退款信息
     */
    @Override
    public RefundInfoVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询退款信息列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 退款信息分页列表
     */
    @Override
    public TableDataInfo<RefundInfoVo> queryPageList(RefundInfoBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<RefundInfo> lqw = buildQueryWrapper(bo);
        Page<RefundInfoVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的退款信息列表
     *
     * @param bo 查询条件
     * @return 退款信息列表
     */
    @Override
    public List<RefundInfoVo> queryList(RefundInfoBo bo) {
        LambdaQueryWrapper<RefundInfo> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<RefundInfo> buildQueryWrapper(RefundInfoBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<RefundInfo> lqw = Wrappers.lambdaQuery();
        lqw.eq(bo.getOrderReturnId() != null, RefundInfo::getOrderReturnId, bo.getOrderReturnId());
        lqw.eq(bo.getRefund() != null, RefundInfo::getRefund, bo.getRefund());
        lqw.eq(StringUtils.isNotBlank(bo.getRefundSn()), RefundInfo::getRefundSn, bo.getRefundSn());
        lqw.eq(bo.getRefundStatus() != null, RefundInfo::getRefundStatus, bo.getRefundStatus());
        lqw.eq(bo.getRefundChannel() != null, RefundInfo::getRefundChannel, bo.getRefundChannel());
        lqw.eq(StringUtils.isNotBlank(bo.getRefundContent()), RefundInfo::getRefundContent, bo.getRefundContent());
        return lqw;
    }

    /**
     * 新增退款信息
     *
     * @param bo 退款信息
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(RefundInfoBo bo) {
        RefundInfo add = MapstructUtils.convert(bo, RefundInfo.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改退款信息
     *
     * @param bo 退款信息
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(RefundInfoBo bo) {
        RefundInfo update = MapstructUtils.convert(bo, RefundInfo.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(RefundInfo entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除退款信息信息
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
