package com.github;


import com.github.collector.LogCollector;
import com.github.collector.NothingCollector;
import org.springframework.http.HttpHeaders;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author EalenXie Created on 2020/1/2 17:49.
 * AopLog Annotation
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface AopLog {

    /**
     * 仅当发生异常时才记录
     */
    boolean logOnErr() default false;

    /**
     * 操作类型(操作分类)
     */
    String type() default "undefined";

    /**
     * 记录的headers ,默认记录 content-type user-agent
     */
    String[] headers() default {HttpHeaders.USER_AGENT, HttpHeaders.CONTENT_TYPE};

    /**
     * 切面是否记录 请求参数
     */
    boolean args() default true;

    /**
     * 切面是否记录 响应参数
     */
    boolean respBody() default true;

    /**
     * 当发生异常时,切面是否记录异常堆栈信息到content
     */
    boolean stackTraceOnErr() default false;

    /**
     * 异步模式 收集日志
     */
    boolean asyncMode() default true;

    /**
     * 收集器
     */
    Class<? extends LogCollector> collector() default NothingCollector.class;
}
