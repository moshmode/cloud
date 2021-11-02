package com.mosh.edu.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;

import com.mosh.edu.entity.vo.subject.FinalSubjectVo;
import com.mosh.edu.entity.vo.subject.NestedSubjectVo;
import com.mosh.edu.entity.vo.subject.SubjectVo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 课程科目
 * </p>
 *
 * @author mosh
 * @since 2021-10-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("edu_subject")
public class Subject implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    private String title;

    private String parentId;

    private Integer sort;

    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;

    public SubjectVo simplify(){
        return "0".equals(parentId) ? new NestedSubjectVo(this) : new FinalSubjectVo(this);
    }

}
