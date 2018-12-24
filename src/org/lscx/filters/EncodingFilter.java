package org.lscx.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
@WebFilter(
        description = "Encoding Filter",
        filterName = "encodingFilter",
        urlPatterns = {"/*"}
)
public class EncodingFilter implements Filter {
    private String charEncoding ="utf-8";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 将设置的编码与请求的编码进行比较，若不同，则将请求的编码设置为设置的编码
        if (!charEncoding.equals(servletRequest.getCharacterEncoding())) {
            servletRequest.setCharacterEncoding(charEncoding);
        }
        // 将相应的编码设置为设置的编码
        servletResponse.setCharacterEncoding(charEncoding);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
