﻿import java.util.HashMap;
import java.util.Map;

public class Request {
    // 请求方法
    private String method;
    // 请求路径
    private String url;
    // http版本号
    private String version;
    // 请求头
    private Map<String, String> headers = new HashMap<>();
    // 请求参数
    private Map<String, String> parameters = new HashMap<>();
    // 添加请求头
    public void addHeader(String key, String value){
        headers.put(key, value);
    }
    // 获取某个请求头
    

}
