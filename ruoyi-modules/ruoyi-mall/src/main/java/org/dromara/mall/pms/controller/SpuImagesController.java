package org.dromara.mall.pms.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.*;
import cn.dev33.satoken.annotation.SaCheckPermission;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import org.dromara.common.idempotent.annotation.RepeatSubmit;
import org.dromara.common.log.annotation.Log;
import org.dromara.common.web.core.BaseController;
import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.core.domain.R;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import org.dromara.common.log.enums.BusinessType;
import org.dromara.common.excel.utils.ExcelUtil;
import org.dromara.mall.pms.domain.vo.SpuImagesVo;
import org.dromara.mall.pms.domain.bo.SpuImagesBo;
import org.dromara.mall.pms.service.ISpuImagesService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * spu图片
 *
 * @author chan fa
 * @date 2024-06-08
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/pms/spuImages")
public class SpuImagesController extends BaseController {

    private final ISpuImagesService spuImagesService;

    /**
     * 查询spu图片列表
     */
    @SaCheckPermission("pms:spuImages:list")
    @GetMapping("/list")
    public TableDataInfo<SpuImagesVo> list(SpuImagesBo bo, PageQuery pageQuery) {
        return spuImagesService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出spu图片列表
     */
    @SaCheckPermission("pms:spuImages:export")
    @Log(title = "spu图片", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(SpuImagesBo bo, HttpServletResponse response) {
        List<SpuImagesVo> list = spuImagesService.queryList(bo);
        ExcelUtil.exportExcel(list, "spu图片", SpuImagesVo.class, response);
    }

    /**
     * 获取spu图片详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("pms:spuImages:query")
    @GetMapping("/{id}")
    public R<SpuImagesVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(spuImagesService.queryById(id));
    }

    /**
     * 新增spu图片
     */
    @SaCheckPermission("pms:spuImages:add")
    @Log(title = "spu图片", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody SpuImagesBo bo) {
        return toAjax(spuImagesService.insertByBo(bo));
    }

    /**
     * 修改spu图片
     */
    @SaCheckPermission("pms:spuImages:edit")
    @Log(title = "spu图片", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody SpuImagesBo bo) {
        return toAjax(spuImagesService.updateByBo(bo));
    }

    /**
     * 删除spu图片
     *
     * @param ids 主键串
     */
    @SaCheckPermission("pms:spuImages:remove")
    @Log(title = "spu图片", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(spuImagesService.deleteWithValidByIds(List.of(ids), true));
    }
}
