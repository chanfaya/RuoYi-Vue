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
import org.dromara.mall.oms.domain.vo.OrderSettingVo;
import org.dromara.mall.oms.domain.bo.OrderSettingBo;
import org.dromara.mall.oms.service.IOrderSettingService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 订单配置信息
 *
 * @author chan fa
 * @date 2024-06-08
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/oms/orderSetting")
public class OrderSettingController extends BaseController {

    private final IOrderSettingService orderSettingService;

    /**
     * 查询订单配置信息列表
     */
    @SaCheckPermission("oms:orderSetting:list")
    @GetMapping("/list")
    public TableDataInfo<OrderSettingVo> list(OrderSettingBo bo, PageQuery pageQuery) {
        return orderSettingService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出订单配置信息列表
     */
    @SaCheckPermission("oms:orderSetting:export")
    @Log(title = "订单配置信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(OrderSettingBo bo, HttpServletResponse response) {
        List<OrderSettingVo> list = orderSettingService.queryList(bo);
        ExcelUtil.exportExcel(list, "订单配置信息", OrderSettingVo.class, response);
    }

    /**
     * 获取订单配置信息详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("oms:orderSetting:query")
    @GetMapping("/{id}")
    public R<OrderSettingVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(orderSettingService.queryById(id));
    }

    /**
     * 新增订单配置信息
     */
    @SaCheckPermission("oms:orderSetting:add")
    @Log(title = "订单配置信息", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody OrderSettingBo bo) {
        return toAjax(orderSettingService.insertByBo(bo));
    }

    /**
     * 修改订单配置信息
     */
    @SaCheckPermission("oms:orderSetting:edit")
    @Log(title = "订单配置信息", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody OrderSettingBo bo) {
        return toAjax(orderSettingService.updateByBo(bo));
    }

    /**
     * 删除订单配置信息
     *
     * @param ids 主键串
     */
    @SaCheckPermission("oms:orderSetting:remove")
    @Log(title = "订单配置信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(orderSettingService.deleteWithValidByIds(List.of(ids), true));
    }
}
