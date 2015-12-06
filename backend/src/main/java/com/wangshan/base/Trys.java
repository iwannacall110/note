package com.wangshan.base;

/**
 * Created by Administrator on 2015/12/6.
 */
public class Trys {
    public static final Error notFound = new Error(1, "数据格式错误!!!");
}

class Error {
    private Integer status;
    private String content;
    public Error(Integer status, String content){
        this.status = status;
        this.content = content;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
