package com.mosh.edu.entity.vo.client;

import lombok.Data;

/**
 * Description
 *
 * @author mosh
 * @date 2021/11/8 15:35
 */
@Data
public class VideoClientVo {
    private String id;

    /**
     * 节点名称
     */
    private String title;

    /**
     * 云端视频资源
     */
    private String videoSourceId;


    /**
     * 排序字段
     */
    private Integer sort;

    /**
     * 播放次数
     */
    private Long playCount;

    /**
     * 是否可以试听：0收费 1免费
     */
    private Integer isFree;

    /**
     * 视频时长（秒）
     */
    private Float duration;

    /**
     * 视频源文件大小（字节）
     */
    private Long size;
}
