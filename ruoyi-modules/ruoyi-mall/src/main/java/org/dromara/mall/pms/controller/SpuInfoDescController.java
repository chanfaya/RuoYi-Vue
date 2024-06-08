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
import org.dromara.mall.pms.domain.vo.SpuInfoDescVo;
import org.dromara.mall.pms.domain.bo.SpuInfoDescBo;
import org.dromara.mall.pms.service.ISpuInfoDescService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * spu信息介绍
 *
 * @author chan fa
 * @date 2024-06-08
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/pms/spuInfoDesc")
public class SpuInfoDescController extends BaseController {

    private final ISpuInfoDescService spuInfoDescService;

    /**
     * 查询spu信息介绍列表
     */
    @SaCheckPermission("pms:spuInfoDesc:list")
    @GetMapping("/list")
    public TableDataInfo<SpuInfoDescVo> list(SpuInfoDescBo bo, PageQuery pageQuery) {
        return spuInfoDescService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出spu信息介绍列表
     */
    @SaCheckPermission("pms:spuInfoDesc:export")
    @Log(title = "spu信息介绍", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(SpuInfoDescBo bo, HttpServletResponse response) {
        List<SpuInfoDescVo> list = spuInfoDescService.queryList(bo);
        ExcelUtil.exportExcel(list, "spu信息介绍", SpuInfoDescVo.class, response);
    }

    /**
     * 获取spu信息介绍详细信息
     *
     * @param spuId 主键
     */
    @SaCheckPermission("pms:spuInfoDesc:query")
    @GetMapping("/{spuId}")
    public R<SpuInfoDescVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long spuId) {
        return R.ok(spuInfoDescService.queryById(spuId));
    }

    /**
     * 新增spu信息介绍
     */
    @SaCheckPermission("pms:spuInfoDesc:add")
    @Log(title = "spu信息介绍", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody SpuInfoDescBo bo) {
        return toAjax(spuInfoDescService.insertByBo(bo));
    }

    /**
     * 修改spu信息介绍
     */
    @SaCheckPermission("pms:spuInfoDesc:edit")
    @Log(title = "spu信息介绍", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody SpuInfoDescBo bo) {
        return toAjax(spuInfoDescService.updateByBo(bo));
    }

    /**
     * 删除spu信息介绍
     *
     * @param spuIds 主键串
     */
    @SaCheckPermission("pms:spuInfoDesc:remove")
    @Log(title = "spu信息介绍", businessType = BusinessType.DELETE)
    @DeleteMapping("/{spuIds}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] spuIds) {
        return toAjax(spuInfoDescService.deleteWithValidByIds(List.of(spuIds), true));
    }
}
