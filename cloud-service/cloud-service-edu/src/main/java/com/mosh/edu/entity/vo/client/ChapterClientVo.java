package com.mosh.edu.entity.vo.client;

import com.mosh.edu.entity.vo.course.video.VideoVo;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Description
 *
 * @author mosh
 * @date 2021/11/8 15:40
 */
@Data
public class ChapterClientVo {
    private String id;

    private String courseId;

    private String title;

    private List<VideoClientVo> children = new ArrayList<>();
}
