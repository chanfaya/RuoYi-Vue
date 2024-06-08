package org.dromara.mall.pms.service.impl;

import org.dromara.common.core.utils.MapstructUtils;
import org.dromara.common.core.utils.StringUtils;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.dromara.mall.pms.domain.bo.SpuCommentBo;
import org.dromara.mall.pms.domain.vo.SpuCommentVo;
import org.dromara.mall.pms.domain.SpuComment;
import org.dromara.mall.pms.mapper.SpuCommentMapper;
import org.dromara.mall.pms.service.ISpuCommentService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 商品评价Service业务层处理
 *
 * @author chan fa
 * @date 2024-06-08
 */
@RequiredArgsConstructor
@Service
public class SpuCommentServiceImpl implements ISpuCommentService {

    private final SpuCommentMapper baseMapper;

    /**
     * 查询商品评价
     *
     * @param id 主键
     * @return 商品评价
     */
    @Override
    public SpuCommentVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询商品评价列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 商品评价分页列表
     */
    @Override
    public TableDataInfo<SpuCommentVo> queryPageList(SpuCommentBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<SpuComment> lqw = buildQueryWrapper(bo);
        Page<SpuCommentVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的商品评价列表
     *
     * @param bo 查询条件
     * @return 商品评价列表
     */
    @Override
    public List<SpuCommentVo> queryList(SpuCommentBo bo) {
        LambdaQueryWrapper<SpuComment> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<SpuComment> buildQueryWrapper(SpuCommentBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<SpuComment> lqw = Wrappers.lambdaQuery();
        lqw.eq(bo.getSkuId() != null, SpuComment::getSkuId, bo.getSkuId());
        lqw.eq(bo.getSpuId() != null, SpuComment::getSpuId, bo.getSpuId());
        lqw.like(StringUtils.isNotBlank(bo.getSpuName()), SpuComment::getSpuName, bo.getSpuName());
        lqw.like(StringUtils.isNotBlank(bo.getMemberNickName()), SpuComment::getMemberNickName, bo.getMemberNickName());
        lqw.eq(bo.getStar() != null, SpuComment::getStar, bo.getStar());
        lqw.eq(StringUtils.isNotBlank(bo.getMemberIp()), SpuComment::getMemberIp, bo.getMemberIp());
        lqw.eq(bo.getShowStatus() != null, SpuComment::getShowStatus, bo.getShowStatus());
        lqw.eq(StringUtils.isNotBlank(bo.getSpuAttributes()), SpuComment::getSpuAttributes, bo.getSpuAttributes());
        lqw.eq(bo.getLikesCount() != null, SpuComment::getLikesCount, bo.getLikesCount());
        lqw.eq(bo.getReplyCount() != null, SpuComment::getReplyCount, bo.getReplyCount());
        lqw.eq(StringUtils.isNotBlank(bo.getResources()), SpuComment::getResources, bo.getResources());
        lqw.eq(StringUtils.isNotBlank(bo.getContent()), SpuComment::getContent, bo.getContent());
        lqw.eq(StringUtils.isNotBlank(bo.getMemberIcon()), SpuComment::getMemberIcon, bo.getMemberIcon());
        lqw.eq(bo.getCommentType() != null, SpuComment::getCommentType, bo.getCommentType());
        return lqw;
    }

    /**
     * 新增商品评价
     *
     * @param bo 商品评价
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(SpuCommentBo bo) {
        SpuComment add = MapstructUtils.convert(bo, SpuComment.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改商品评价
     *
     * @param bo 商品评价
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(SpuCommentBo bo) {
        SpuComment update = MapstructUtils.convert(bo, SpuComment.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(SpuComment entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除商品评价信息
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
