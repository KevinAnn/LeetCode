package com.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class Util {

    public static void print(Object o) {
        System.out.println(JSON.toJSONString(o, SerializerFeature.WriteDateUseDateFormat));
    }
}
