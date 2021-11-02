package com.mosh.edu.entity.vo.course.chapter;

import com.mosh.edu.entity.vo.course.video.VideoVo;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Description
 *
 * @author mosh
 * @date 2021/10/26 19:14
 */
@Data
public class ChapterVo {
    private String id;

    private String courseId;

    private String title;

    private List<VideoVo> children = new ArrayList<>();
}
