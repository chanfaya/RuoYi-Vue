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
import org.dromara.mall.pms.domain.vo.SpuInfoVo;
import org.dromara.mall.pms.domain.bo.SpuInfoBo;
import org.dromara.mall.pms.service.ISpuInfoService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * spu信息
 *
 * @author chan fa
 * @date 2024-06-08
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/pms/spuInfo")
public class SpuInfoController extends BaseController {

    private final ISpuInfoService spuInfoService;

    /**
     * 查询spu信息列表
     */
    @SaCheckPermission("pms:spuInfo:list")
    @GetMapping("/list")
    public TableDataInfo<SpuInfoVo> list(SpuInfoBo bo, PageQuery pageQuery) {
        return spuInfoService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出spu信息列表
     */
    @SaCheckPermission("pms:spuInfo:export")
    @Log(title = "spu信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(SpuInfoBo bo, HttpServletResponse response) {
        List<SpuInfoVo> list = spuInfoService.queryList(bo);
        ExcelUtil.exportExcel(list, "spu信息", SpuInfoVo.class, response);
    }

    /**
     * 获取spu信息详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("pms:spuInfo:query")
    @GetMapping("/{id}")
    public R<SpuInfoVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(spuInfoService.queryById(id));
    }

    /**
     * 新增spu信息
     */
    @SaCheckPermission("pms:spuInfo:add")
    @Log(title = "spu信息", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody SpuInfoBo bo) {
        return toAjax(spuInfoService.insertByBo(bo));
    }

    /**
     * 修改spu信息
     */
    @SaCheckPermission("pms:spuInfo:edit")
    @Log(title = "spu信息", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody SpuInfoBo bo) {
        return toAjax(spuInfoService.updateByBo(bo));
    }

    /**
     * 删除spu信息
     *
     * @param ids 主键串
     */
    @SaCheckPermission("pms:spuInfo:remove")
    @Log(title = "spu信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(spuInfoService.deleteWithValidByIds(List.of(ids), true));
    }
}
