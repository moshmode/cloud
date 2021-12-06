package com.mosh.interaction.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * Description
 *
 * @author mosh
 * @date 2021/12/3 18:39
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public abstract class Interaction implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 互动ID
     */
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    /**
     * 会员id
     */
    private String memberId;

    /**
     * 点赞
     */
    private Integer liked;

    /**
     * 收藏
     */
    private Integer collected;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;
}
