package org.dromara.mall.pms.domain.bo;

import org.dromara.mall.pms.domain.SpuComment;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 商品评价业务对象 pms_spu_comment
 *
 * @author chan fa
 * @date 2024-06-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = SpuComment.class, reverseConvertGenerate = false)
public class SpuCommentBo extends BaseEntity {

    /**
     * 
     */
    @NotNull(message = "不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * sku_id
     */
    @NotNull(message = "sku_id不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long skuId;

    /**
     * spu_id
     */
    @NotNull(message = "spu_id不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long spuId;

    /**
     * 商品名字
     */
    @NotBlank(message = "商品名字不能为空", groups = { AddGroup.class, EditGroup.class })
    private String spuName;

    /**
     * 会员昵称
     */
    @NotBlank(message = "会员昵称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String memberNickName;

    /**
     * 星级
     */
    @NotNull(message = "星级不能为空", groups = { AddGroup.class, EditGroup.class })
    private Integer star;

    /**
     * 会员ip
     */
    @NotBlank(message = "会员ip不能为空", groups = { AddGroup.class, EditGroup.class })
    private String memberIp;

    /**
     * 显示状态[0-不显示，1-显示]
     */
    @NotNull(message = "显示状态[0-不显示，1-显示]不能为空", groups = { AddGroup.class, EditGroup.class })
    private Integer showStatus;

    /**
     * 购买时属性组合
     */
    @NotBlank(message = "购买时属性组合不能为空", groups = { AddGroup.class, EditGroup.class })
    private String spuAttributes;

    /**
     * 点赞数
     */
    @NotNull(message = "点赞数不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long likesCount;

    /**
     * 回复数
     */
    @NotNull(message = "回复数不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long replyCount;

    /**
     * 评论图片/视频[json数据；[{type:文件类型,url:资源路径}]]
     */
    @NotBlank(message = "评论图片/视频[json数据；[{type:文件类型,url:资源路径}]]不能为空", groups = { AddGroup.class, EditGroup.class })
    private String resources;

    /**
     * 内容
     */
    @NotBlank(message = "内容不能为空", groups = { AddGroup.class, EditGroup.class })
    private String content;

    /**
     * 用户头像
     */
    @NotBlank(message = "用户头像不能为空", groups = { AddGroup.class, EditGroup.class })
    private String memberIcon;

    /**
     * 评论类型[0 - 对商品的直接评论，1 - 对评论的回复]
     */
    @NotNull(message = "评论类型[0 - 对商品的直接评论，1 - 对评论的回复]不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long commentType;


}
