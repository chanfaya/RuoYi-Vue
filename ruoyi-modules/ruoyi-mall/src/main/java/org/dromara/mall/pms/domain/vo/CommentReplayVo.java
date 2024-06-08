package org.dromara.mall.pms.domain.vo;

import org.dromara.mall.pms.domain.CommentReplay;
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
 * 商品评价回复关系视图对象 pms_comment_replay
 *
 * @author chan fa
 * @date 2024-06-08
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = CommentReplay.class)
public class CommentReplayVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    @ExcelProperty(value = "")
    private Long id;

    /**
     * 评论id
     */
    @ExcelProperty(value = "评论id")
    private Long commentId;

    /**
     * 回复id
     */
    @ExcelProperty(value = "回复id")
    private Long replyId;


}
