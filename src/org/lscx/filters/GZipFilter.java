package org.lscx.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

@WebFilter(
        description = "GZip Filter",
        filterName = "gzipFilter",
        urlPatterns = {"/*"}
)
public class GZipFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse res,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        String acceptEncoding = request.getHeader("Accept-Encoding");
        //支持的编码方式

        if (acceptEncoding != null && acceptEncoding.toLowerCase().indexOf("gzip") != -1) {
            //如果客户浏览器支持GZIP格式，则使用GZIP压缩数据
            GZipResponseWrapper gzipRes = new GZipResponseWrapper(response);

            chain.doFilter(request, gzipRes);//doFilter,使用自定义的response
            gzipRes.finishResponse();//输出压缩数据

        } else {
            chain.doFilter(request, response);//否则不压缩
        }

    }

    public void init(FilterConfig config) throws ServletException {
    }

}


class GZipResponseWrapper extends HttpServletResponseWrapper {

    // 默认的 response
    private HttpServletResponse response;

    // 自定义的 outputStream, 执行close()的时候对数据压缩，并输出
    private GZipOutputStream gzipOutputStream;

    // 自定义 printWriter，将内容输出到 GZipOutputStream 中
    private PrintWriter writer;

    public GZipResponseWrapper(HttpServletResponse response) throws IOException {
        super(response);
        this.response = response;
    }

    public ServletOutputStream getOutputStream() throws IOException {
        if (gzipOutputStream == null)
            gzipOutputStream = new GZipOutputStream(response);
        return gzipOutputStream;
    }

    public PrintWriter getWriter() throws IOException {
        if (writer == null)
            writer = new PrintWriter(new OutputStreamWriter(
                    new GZipOutputStream(response), "UTF-8"));
        return writer;
    }

    // 压缩后数据长度会发生变化 因此将该方法内容置空
    public void setContentLength(int contentLength) {
    }

    public void flushBuffer() throws IOException {
        gzipOutputStream.flush();
    }

    public void finishResponse() throws IOException {
        if (gzipOutputStream != null)
            gzipOutputStream.close();
        if (writer != null)
            writer.close();
    }
}


class GZipOutputStream extends ServletOutputStream {

    private HttpServletResponse response;


    private GZIPOutputStream gzipOutputStream;


    private ByteArrayOutputStream byteArrayOutputStream;

    public GZipOutputStream(HttpServletResponse response) throws IOException {
        this.response = response;
        byteArrayOutputStream = new ByteArrayOutputStream();
        gzipOutputStream = new GZIPOutputStream(byteArrayOutputStream);
    }

    public void write(int b) throws IOException {
        gzipOutputStream.write(b);
    }

    public void close() throws IOException {


        gzipOutputStream.finish();


        byte[] content = byteArrayOutputStream.toByteArray();


        response.addHeader("Content-Encoding", "gzip");
        response.addHeader("Content-Length", Integer.toString(content.length));


        ServletOutputStream out = response.getOutputStream();
        out.write(content);
        out.close();
    }

    public void flush() throws IOException {
        gzipOutputStream.flush();
    }

    public void write(byte[] b, int off, int len) throws IOException {
        gzipOutputStream.write(b, off, len);
    }

    public void write(byte[] b) throws IOException {
        gzipOutputStream.write(b);
    }

    @Override
    public boolean isReady() {
        return false;
    }

    @Override
    public void setWriteListener(WriteListener writeListener) {

    }
}