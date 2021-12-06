package com.mosh.ucenter.entity.vo;

import lombok.Data;

/**
 * Description
 *
 * @author mosh
 * @date 2021/12/5 10:15
 */
@Data
public class MemberVo {


    /**
     * 用户id
     */
    private String id;
    /**
     * 昵称
     */
    private String nickname;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 性别 1 女，2 男
     */
    private Integer sex;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 用户签名
     */
    private String sign;

}
