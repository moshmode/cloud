package com.mosh.edu.entity.vo.subject;

import com.mosh.edu.entity.Subject;

import javax.naming.OperationNotSupportedException;

/**
 * Description
 *
 * @author mosh
 * @date 2021/10/18 14:51
 */
public class FinalSubjectVo extends SubjectVo {
    public FinalSubjectVo(){
        super();
    }

    public FinalSubjectVo(Subject subject) {
        super(subject);
    }

    @Override
    public void addChildren(SubjectVo vo) throws OperationNotSupportedException {
        throw new OperationNotSupportedException();
    }

    @Override
    public void deleteChildren(SubjectVo vo) throws OperationNotSupportedException {
        throw new OperationNotSupportedException();
    }
}
