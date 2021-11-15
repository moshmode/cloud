package com.mosh.ucenter.mapper;

import com.mosh.ucenter.entity.Member;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 会员表 Mapper 接口
 * </p>
 *
 * @author mosh
 * @since 2021-11-06
 */
@Mapper
public interface MemberMapper extends BaseMapper<Member> {
    Integer countRegister(String day);
}
