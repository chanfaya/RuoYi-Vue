package org.dromara.mall.pms.domain.vo;

import org.dromara.mall.pms.domain.SpuComment;
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
 * 商品评价视图对象 pms_spu_comment
 *
 * @author chan fa
 * @date 2024-06-08
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = SpuComment.class)
public class SpuCommentVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    @ExcelProperty(value = "")
    private Long id;

    /**
     * sku_id
     */
    @ExcelProperty(value = "sku_id")
    private Long skuId;

    /**
     * spu_id
     */
    @ExcelProperty(value = "spu_id")
    private Long spuId;

    /**
     * 商品名字
     */
    @ExcelProperty(value = "商品名字")
    private String spuName;

    /**
     * 会员昵称
     */
    @ExcelProperty(value = "会员昵称")
    private String memberNickName;

    /**
     * 星级
     */
    @ExcelProperty(value = "星级")
    private Integer star;

    /**
     * 会员ip
     */
    @ExcelProperty(value = "会员ip")
    private String memberIp;

    /**
     * 显示状态[0-不显示，1-显示]
     */
    @ExcelProperty(value = "显示状态[0-不显示，1-显示]")
    private Integer showStatus;

    /**
     * 购买时属性组合
     */
    @ExcelProperty(value = "购买时属性组合")
    private String spuAttributes;

    /**
     * 点赞数
     */
    @ExcelProperty(value = "点赞数")
    private Long likesCount;

    /**
     * 回复数
     */
    @ExcelProperty(value = "回复数")
    private Long replyCount;

    /**
     * 评论图片/视频[json数据；[{type:文件类型,url:资源路径}]]
     */
    @ExcelProperty(value = "评论图片/视频[json数据；[{type:文件类型,url:资源路径}]]")
    private String resources;

    /**
     * 内容
     */
    @ExcelProperty(value = "内容")
    private String content;

    /**
     * 用户头像
     */
    @ExcelProperty(value = "用户头像")
    private String memberIcon;

    /**
     * 评论类型[0 - 对商品的直接评论，1 - 对评论的回复]
     */
    @ExcelProperty(value = "评论类型[0 - 对商品的直接评论，1 - 对评论的回复]")
    private Long commentType;


}
