package com.mosh.edu.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mosh.edu.entity.Subject;
import com.mosh.edu.entity.excel.ExcelSubject;
import com.mosh.edu.service.SubjectService;
import com.mosh.utils.exception.ExcelNullException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 * Description
 *
 * @author mosh
 * @date 2021/10/15 19:12
 */
public class ExcelSubjectListener extends AnalysisEventListener<ExcelSubject> {

    private SubjectService subjectService;

    public SubjectService getSubjectService() {
        return subjectService;
    }

    public void setSubjectService(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    public ExcelSubjectListener() {
    }

    public ExcelSubjectListener(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @Override
    public void invoke(ExcelSubject excelSubject, AnalysisContext analysisContext) {
        if (excelSubject == null) {
            throw new ExcelNullException();
        }
        //添加一级分类
        Subject existOneSubject = this.existOneSubject(excelSubject.getOneSubjectName());
        if (existOneSubject == null) {
            //没有相同的
            existOneSubject = new Subject();
            existOneSubject.setTitle(excelSubject.getOneSubjectName());
            existOneSubject.setParentId("0");
            subjectService.save(existOneSubject);
        }
        //获取一级分类id值
        String pid = existOneSubject.getId();
        //添加二级分类
        Subject existTwoSubject = this.existTwoSubject(excelSubject.getTwoSubjectName(), pid);
        if (existTwoSubject == null) {
            existTwoSubject = new Subject();
            existTwoSubject.setTitle(excelSubject.getTwoSubjectName());
            existTwoSubject.setParentId(pid);
            subjectService.save(existTwoSubject);
        }
    }

    //判断一级分类是否重复
    private Subject existTwoSubject(String name, String pid) {
        QueryWrapper<Subject> wrapper = new QueryWrapper<>();
        wrapper.eq("title", name);
        wrapper.eq("parent_id", pid);
        return subjectService.getOne(wrapper);
    }

    private Subject existOneSubject(String name) {
        QueryWrapper<Subject> wrapper = new QueryWrapper<>();
        wrapper.eq("title", name);
        wrapper.eq("parent_id", "0");
        return subjectService.getOne(wrapper);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
