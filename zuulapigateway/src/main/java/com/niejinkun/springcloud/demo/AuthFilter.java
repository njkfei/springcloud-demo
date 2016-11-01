package com.niejinkun.springcloud.demo;

import com.netflix.zuul.ZuulFilter;

/**
 * Created by niejinping on 2016/11/1.
 */
public class AuthFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        // TO DO Authotority work
        return false;
    }

    @Override
    public Object run() {
        return null;
    }
}
