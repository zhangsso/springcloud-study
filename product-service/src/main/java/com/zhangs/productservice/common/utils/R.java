package com.zhangs.productservice.common.utils;

import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:返回数据
 * @Author: zhangs
 * @Date: 17:29 2019/7/8
 */
public class R extends HashMap<String, Object> {

    public R(){
        put("code","200");
        put("msg","success");
    }

    public static R error(){
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
    }

    public static R error(String msg){
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR,msg);
    }

    public static R error(int code ,String msg){
        R r = new R();
        r.put("code",code);
        r.put("msg",msg);
        return r;
    }

    public static R ok(){
        return new R();
    }

    public static R ok(String msg){
        R r = new R();
        r.put("msg",msg);
        return r;
    }

    public static R ok(String code,String msg){
        R r = new R();
        r.put("code",code);
        r.put("msg",msg);
        return r;
    }

    public static R ok(Map<String,Object> map ){
        R r = new R();
        r.putAll(map);
        return r;
    }

    @Override
    public R put(String key , Object value){
        super.put(key,value);
        return this;
    }

}
