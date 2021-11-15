package com.mosh.security.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 用户实体类
 * </p>
 *
 * @author qy
 * @since 2019-11-08
 */
@Data
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private String username;

	private String password;

	private String nickName;

	private String salt;

	private String token;

}



