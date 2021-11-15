package com.mosh.edu.entity.vo.course.video;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * Description
 *
 * @author mosh
 * @date 2021/10/26 19:14
 */
@Data
public class VideoVo {
    private String id;

    private String title;

    private String videoSourceId;

}
