package com.mosh.edu.entity.vo.subject;

import com.mosh.edu.entity.Subject;
import lombok.Data;

import javax.naming.OperationNotSupportedException;

/**
 * Description
 *
 * @author mosh
 * @date 2021/10/18 15:15
 */
@Data
public abstract class SubjectVo {
    private String id;
    private String title;

    public SubjectVo(){
    }

    public SubjectVo(Subject subject) {
        id = subject.getId();
        title = subject.getTitle();
    }
    public abstract void addChildren(SubjectVo vo) throws OperationNotSupportedException;
    public abstract void deleteChildren(SubjectVo vo) throws OperationNotSupportedException;
}
