package com.niejinkun.springcloud.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

/**
 * Created by niejinping on 2016/11/1.
 */
public class ResponseFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 1000;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();

        InputStream inputStream  =  ctx.getResponseDataStream();

        try {
            String data = IOUtils.toString(inputStream, "UTF-8");

            MessageVo vo = new MessageVo("test","200",data);

            ObjectMapper objectMapper = new ObjectMapper();

            ctx.setResponseBody(objectMapper.writeValueAsString(vo));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}

class MessageVo implements Serializable{
    String message;
    String code;

    Object data;

    public MessageVo() {
    }

    public MessageVo(String message, String code, Object object) {
        this.message = message;
        this.code = code;
        this.data = object;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}