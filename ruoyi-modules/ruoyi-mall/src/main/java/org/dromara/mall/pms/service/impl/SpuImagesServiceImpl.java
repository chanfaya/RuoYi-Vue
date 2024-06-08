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
import org.dromara.mall.pms.domain.bo.SpuImagesBo;
import org.dromara.mall.pms.domain.vo.SpuImagesVo;
import org.dromara.mall.pms.domain.SpuImages;
import org.dromara.mall.pms.mapper.SpuImagesMapper;
import org.dromara.mall.pms.service.ISpuImagesService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * spu图片Service业务层处理
 *
 * @author chan fa
 * @date 2024-06-08
 */
@RequiredArgsConstructor
@Service
public class SpuImagesServiceImpl implements ISpuImagesService {

    private final SpuImagesMapper baseMapper;

    /**
     * 查询spu图片
     *
     * @param id 主键
     * @return spu图片
     */
    @Override
    public SpuImagesVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询spu图片列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return spu图片分页列表
     */
    @Override
    public TableDataInfo<SpuImagesVo> queryPageList(SpuImagesBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<SpuImages> lqw = buildQueryWrapper(bo);
        Page<SpuImagesVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的spu图片列表
     *
     * @param bo 查询条件
     * @return spu图片列表
     */
    @Override
    public List<SpuImagesVo> queryList(SpuImagesBo bo) {
        LambdaQueryWrapper<SpuImages> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<SpuImages> buildQueryWrapper(SpuImagesBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<SpuImages> lqw = Wrappers.lambdaQuery();
        lqw.eq(bo.getSpuId() != null, SpuImages::getSpuId, bo.getSpuId());
        lqw.like(StringUtils.isNotBlank(bo.getImgName()), SpuImages::getImgName, bo.getImgName());
        lqw.eq(StringUtils.isNotBlank(bo.getImgUrl()), SpuImages::getImgUrl, bo.getImgUrl());
        lqw.eq(bo.getImgSort() != null, SpuImages::getImgSort, bo.getImgSort());
        lqw.eq(bo.getDefaultImg() != null, SpuImages::getDefaultImg, bo.getDefaultImg());
        return lqw;
    }

    /**
     * 新增spu图片
     *
     * @param bo spu图片
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(SpuImagesBo bo) {
        SpuImages add = MapstructUtils.convert(bo, SpuImages.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改spu图片
     *
     * @param bo spu图片
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(SpuImagesBo bo) {
        SpuImages update = MapstructUtils.convert(bo, SpuImages.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(SpuImages entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除spu图片信息
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
