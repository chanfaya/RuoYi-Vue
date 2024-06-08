package org.dromara.mall.oms.controller;

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
import org.dromara.mall.oms.domain.vo.OrderOperateHistoryVo;
import org.dromara.mall.oms.domain.bo.OrderOperateHistoryBo;
import org.dromara.mall.oms.service.IOrderOperateHistoryService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 订单操作历史记录
 *
 * @author chan fa
 * @date 2024-06-08
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/oms/orderOperateHistory")
public class OrderOperateHistoryController extends BaseController {

    private final IOrderOperateHistoryService orderOperateHistoryService;

    /**
     * 查询订单操作历史记录列表
     */
    @SaCheckPermission("oms:orderOperateHistory:list")
    @GetMapping("/list")
    public TableDataInfo<OrderOperateHistoryVo> list(OrderOperateHistoryBo bo, PageQuery pageQuery) {
        return orderOperateHistoryService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出订单操作历史记录列表
     */
    @SaCheckPermission("oms:orderOperateHistory:export")
    @Log(title = "订单操作历史记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(OrderOperateHistoryBo bo, HttpServletResponse response) {
        List<OrderOperateHistoryVo> list = orderOperateHistoryService.queryList(bo);
        ExcelUtil.exportExcel(list, "订单操作历史记录", OrderOperateHistoryVo.class, response);
    }

    /**
     * 获取订单操作历史记录详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("oms:orderOperateHistory:query")
    @GetMapping("/{id}")
    public R<OrderOperateHistoryVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(orderOperateHistoryService.queryById(id));
    }

    /**
     * 新增订单操作历史记录
     */
    @SaCheckPermission("oms:orderOperateHistory:add")
    @Log(title = "订单操作历史记录", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody OrderOperateHistoryBo bo) {
        return toAjax(orderOperateHistoryService.insertByBo(bo));
    }

    /**
     * 修改订单操作历史记录
     */
    @SaCheckPermission("oms:orderOperateHistory:edit")
    @Log(title = "订单操作历史记录", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody OrderOperateHistoryBo bo) {
        return toAjax(orderOperateHistoryService.updateByBo(bo));
    }

    /**
     * 删除订单操作历史记录
     *
     * @param ids 主键串
     */
    @SaCheckPermission("oms:orderOperateHistory:remove")
    @Log(title = "订单操作历史记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(orderOperateHistoryService.deleteWithValidByIds(List.of(ids), true));
    }
}
