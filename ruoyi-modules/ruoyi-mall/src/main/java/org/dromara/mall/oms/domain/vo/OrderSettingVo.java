package org.dromara.mall.oms.domain.vo;

import org.dromara.mall.oms.domain.OrderSetting;
import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import org.dromara.common.excel.annotation.ExcelDictFormat;
import org.dromara.common.excel.convert.ExcelDictConvert;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;



/**
 * 订单配置信息视图对象 oms_order_setting
 *
 * @author chan fa
 * @date 2024-06-08
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = OrderSetting.class)
public class OrderSettingVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    @ExcelProperty(value = "")
    private Long id;

    /**
     * 秒杀订单超时关闭时间(分)
     */
    @ExcelProperty(value = "秒杀订单超时关闭时间(分)")
    private Long flashOrderOvertime;

    /**
     * 正常订单超时时间(分)
     */
    @ExcelProperty(value = "正常订单超时时间(分)")
    private Long normalOrderOvertime;

    /**
     * 发货后自动确认收货时间（天）
     */
    @ExcelProperty(value = "发货后自动确认收货时间", converter = ExcelDictConvert.class)
    @ExcelDictFormat(readConverterExp = "天=")
    private Long confirmOvertime;

    /**
     * 自动完成交易时间，不能申请退货（天）
     */
    @ExcelProperty(value = "自动完成交易时间，不能申请退货", converter = ExcelDictConvert.class)
    @ExcelDictFormat(readConverterExp = "天=")
    private Long finishOvertime;

    /**
     * 订单完成后自动好评时间（天）
     */
    @ExcelProperty(value = "订单完成后自动好评时间", converter = ExcelDictConvert.class)
    @ExcelDictFormat(readConverterExp = "天=")
    private Long commentOvertime;

    /**
     * 会员等级【0-不限会员等级，全部通用；其他-对应的其他会员等级】
     */
    @ExcelProperty(value = "会员等级【0-不限会员等级，全部通用；其他-对应的其他会员等级】")
    private Long memberLevel;


}
