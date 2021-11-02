package com.mosh.edu.entity.vo.subject;

import com.mosh.edu.entity.Subject;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.List;

/**
 * Description
 *
 * @author mosh
 * @date 2021/10/18 14:52
 */
public class NestedSubjectVo extends SubjectVo {

    private List<SubjectVo> children = new ArrayList<>();

    public NestedSubjectVo(){
        super();
    }

    public NestedSubjectVo(Subject subject) {
        super(subject);
    }

    public List<SubjectVo> getChildren() {
        return children;
    }

    public void setChildren(List<SubjectVo> children) {
        this.children = children;
    }

    @Override
    public void addChildren(SubjectVo vo) throws OperationNotSupportedException {
        children.add(vo);
    }

    @Override
    public void deleteChildren(SubjectVo vo) throws OperationNotSupportedException {
        children.remove(vo);
    }
}
