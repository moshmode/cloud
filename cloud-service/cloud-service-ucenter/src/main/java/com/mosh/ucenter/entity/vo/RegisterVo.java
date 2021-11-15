package com.mosh.ucenter.entity.vo;

import lombok.Data;

/**
 * Description
 *
 * @author mosh
 * @date 2021/11/6 13:18
 */
@Data
public class RegisterVo {

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 密码
     */
    private String password;

    /**
     * 验证码
     */
    private String code;
}
