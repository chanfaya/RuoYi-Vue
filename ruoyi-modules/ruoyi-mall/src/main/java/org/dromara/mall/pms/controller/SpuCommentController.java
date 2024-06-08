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
import org.dromara.mall.pms.domain.vo.SpuCommentVo;
import org.dromara.mall.pms.domain.bo.SpuCommentBo;
import org.dromara.mall.pms.service.ISpuCommentService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 商品评价
 *
 * @author chan fa
 * @date 2024-06-08
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/pms/spuComment")
public class SpuCommentController extends BaseController {

    private final ISpuCommentService spuCommentService;

    /**
     * 查询商品评价列表
     */
    @SaCheckPermission("pms:spuComment:list")
    @GetMapping("/list")
    public TableDataInfo<SpuCommentVo> list(SpuCommentBo bo, PageQuery pageQuery) {
        return spuCommentService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出商品评价列表
     */
    @SaCheckPermission("pms:spuComment:export")
    @Log(title = "商品评价", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(SpuCommentBo bo, HttpServletResponse response) {
        List<SpuCommentVo> list = spuCommentService.queryList(bo);
        ExcelUtil.exportExcel(list, "商品评价", SpuCommentVo.class, response);
    }

    /**
     * 获取商品评价详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("pms:spuComment:query")
    @GetMapping("/{id}")
    public R<SpuCommentVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(spuCommentService.queryById(id));
    }

    /**
     * 新增商品评价
     */
    @SaCheckPermission("pms:spuComment:add")
    @Log(title = "商品评价", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody SpuCommentBo bo) {
        return toAjax(spuCommentService.insertByBo(bo));
    }

    /**
     * 修改商品评价
     */
    @SaCheckPermission("pms:spuComment:edit")
    @Log(title = "商品评价", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody SpuCommentBo bo) {
        return toAjax(spuCommentService.updateByBo(bo));
    }

    /**
     * 删除商品评价
     *
     * @param ids 主键串
     */
    @SaCheckPermission("pms:spuComment:remove")
    @Log(title = "商品评价", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(spuCommentService.deleteWithValidByIds(List.of(ids), true));
    }
}
