package com.mosh.edu.entity.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * Description
 *
 * @author mosh
 * @date 2021/10/15 19:01
 */
@Data
public class ExcelSubject {

    @ExcelProperty(index = 0)
    private String oneSubjectName;

    @ExcelProperty(index = 1)
    private String twoSubjectName;
}
