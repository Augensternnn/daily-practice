@javax.servlet.annotation.WebFilter("/*")
public class FilterDispatcher implements javax.servlet.Filter {
    public void doFilter(javax.servlet.ServletRequest req, javax.servlet.ServletResponse resp, javax.servlet.FilterChain chain) throws javax.servlet.ServletException, java.io.IOException {
        chain.doFilter(req, resp);
    }

    public void init(javax.servlet.FilterConfig config) throws javax.servlet.ServletException {

    }

    public void destroy() {
    }

}
