package com.mosh.edu.service;

import com.mosh.edu.entity.Subject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mosh.edu.entity.vo.subject.SubjectVo;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author mosh
 * @since 2021-10-15
 */
public interface SubjectService extends IService<Subject> {

    void batchImportByExcel(MultipartFile file);

    Collection<SubjectVo> nestedList();
}
