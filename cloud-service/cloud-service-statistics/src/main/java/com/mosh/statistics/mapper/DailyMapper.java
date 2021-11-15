package com.mosh.statistics.mapper;

import com.mosh.statistics.entity.Daily;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 网站统计日数据 Mapper 接口
 * </p>
 *
 * @author mosh
 * @since 2021-11-11
 */
@Mapper
public interface DailyMapper extends BaseMapper<Daily> {

}
