package com.mosh.db.annotation;

import com.mosh.db.menu.QueryType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Description
 *
 * @author mosh
 * @date 2021/11/22 10:41
 */
@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface QueryField {
    String column() default "";

    QueryType type() default QueryType.EQ;
}
