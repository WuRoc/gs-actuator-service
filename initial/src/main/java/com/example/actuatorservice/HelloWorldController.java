package com.example.actuatorservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @ClassName HelloWorldController
 * @Description TODO
 * @Author XiaoShuMu
 * @Version 1.0
 * @Create 2021-11-01 15:50
 * @Blog https://www.cnblogs.com/WLCYSYS/
 **/
@Slf4j
@Controller
public class HelloWorldController {
    public static final String TEMPLATE = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    /**
     * The @ResponseBody annotation tells Spring MVC not to render a model into a view but,
     * rather, to write the returned object into the response body.
     * It does so by using one of Spring’s message converters. Because Jackson 2 is in the classpath,
     * MappingJackson2HttpMessageConverter will handle the conversion of a
     * Greeting object to JSON if the request’s Accept header specifies that JSON should be returned.
     * @param name
     * @return
     */
    @GetMapping("/hello-world")
    @ResponseBody
    public Greeting sayHello(@RequestParam(name = "name", required = false, defaultValue = "stranger") String name) { //@RequestParam(name = "name" ,这个双引号内的是uri，可以返回为null
        log.info(name);
        return new Greeting(counter.incrementAndGet(), String.format(TEMPLATE, name));
    }
}
