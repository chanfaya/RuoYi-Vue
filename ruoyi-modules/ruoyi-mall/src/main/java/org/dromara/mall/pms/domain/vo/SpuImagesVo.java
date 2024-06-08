package org.dromara.mall.pms.domain.vo;

import org.dromara.mall.pms.domain.SpuImages;
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
 * spu图片视图对象 pms_spu_images
 *
 * @author chan fa
 * @date 2024-06-08
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = SpuImages.class)
public class SpuImagesVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    @ExcelProperty(value = "")
    private Long id;

    /**
     * spu_id
     */
    @ExcelProperty(value = "spu_id")
    private Long spuId;

    /**
     * 图片名
     */
    @ExcelProperty(value = "图片名")
    private String imgName;

    /**
     * 图片地址
     */
    @ExcelProperty(value = "图片地址")
    private String imgUrl;

    /**
     * 顺序
     */
    @ExcelProperty(value = "顺序")
    private Long imgSort;

    /**
     * 是否默认图
     */
    @ExcelProperty(value = "是否默认图")
    private Long defaultImg;


}
