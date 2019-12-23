import java.util.HashMap;
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
    public String getHeader(String key){
        return headers.get(key);
    }
    // 添加请求参数
    public void addParameter(String key, String value){
        parameters.put(key, value);
    }
    // 获取请求参数
    public String getParameter(String key){
        return parameters.get(key);
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

 
 
 
 

   
	
	
	
	
	
	
	
	
}
