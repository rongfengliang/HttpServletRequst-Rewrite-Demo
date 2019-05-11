package com.example.demo;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

final class MutableHttpServletRequest extends HttpServletRequestWrapper {
    private final Map<String, String> customHeaders;

    public MutableHttpServletRequest(HttpServletRequest request){
        super(request);
        this.customHeaders = new HashMap<String, String>();
    }

    public void putHeader(String name, String value){
        this.customHeaders.put(name, value);
    }

    @Override
    public String getHeader(String name) {

        String userid = customHeaders.get(name);
        if (null!=userid) {
            return userid;

        }
        return super.getHeader(name);
    }

    public Map<String, String> getCustomHeaders() {
        return customHeaders;
    }

    @Override
    public Enumeration<String> getHeaders(String name) {
        if (null != name && name.equals("userid")) {
            return new Enumeration<String>() {
                private boolean hasGetted = false;

                @Override
                public boolean hasMoreElements() {
                    return !hasGetted;
                }

                @Override
                public String nextElement() {
                    if (hasGetted) {
                        throw new NoSuchElementException();
                    } else {
                        hasGetted = true;
                        return customHeaders.get(name);
                    }
                }
            };
        }
        return super.getHeaders(name);

    }
}