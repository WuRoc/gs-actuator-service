package com.example.actuatorservice;

/**
 * @ClassName Greeting
 * @Description TODO
 * @Author XiaoShuMu
 * @Version 1.0
 * @Create 2021-11-01 15:33
 * @Blog https://www.cnblogs.com/WLCYSYS/
 **/
public class Greeting {

    private final long id;

    private final String content;

    public Greeting(long id, String content){
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return this.id;
    }

    public String getContent() {
        return this.content;
    }
}
