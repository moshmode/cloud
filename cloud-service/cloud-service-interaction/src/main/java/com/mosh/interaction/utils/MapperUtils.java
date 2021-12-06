package com.mosh.interaction.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mosh.interaction.entity.Interaction;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Description
 *
 * @author mosh
 * @date 2021/12/3 14:35
 */
public class MapperUtils {

    public static <T extends Interaction> String addInteraction(BaseMapper<T> mapper, T interaction, String column, String objectId) {
        if (!StringUtils.isEmpty(interaction.getId())) {
            mapper.updateById(interaction);
        } else {
            QueryWrapper<T> wrapper = new QueryWrapper<>();
            wrapper.eq(column, objectId).eq("member_id", interaction.getMemberId());

            T dataFromDB = mapper.selectOne(wrapper);
            if (dataFromDB == null) {
                mapper.insert(interaction);
            } else {
                dataFromDB.setCollected(interaction.getCollected());
                dataFromDB.setLiked(interaction.getLiked());
                mapper.updateById(dataFromDB);
            }
        }
        return interaction.getId();
    }

    public static <T extends Interaction> Map<String, Object> countInteraction(BaseMapper<T> mapper, String column, String objectId) {
        QueryWrapper<T> likeWrapper = new QueryWrapper<>();
        likeWrapper.eq(column, objectId).eq("liked", 1);
        Integer likeCount = mapper.selectCount(likeWrapper);
        QueryWrapper<T> collectWrapper = new QueryWrapper<>();
        collectWrapper.eq(column, objectId).eq("collected", 1);
        Integer collectCount = mapper.selectCount(collectWrapper);
        Map<String, Object> map = new HashMap<>();
        map.put("likeCount", likeCount);
        map.put("collectCount", collectCount);
        return map;
    }
}
