package in.jatint4r.springbootcrudoperations.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

//@Component
@Order(1)
public class AuthenticationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        String header = httpServletRequest.getHeader("token");
        String api_key = httpServletRequest.getHeader("x-api-key");
        if(header==null || !header.equals("12345")) {
            httpServletResponse.setStatus(401);
            return;
        }
        if(api_key ==null || !api_key.equals("secret123"))
        {
           httpServletResponse.setContentType("application/json");
           httpServletResponse.getWriter().write( "{\n" +
                   "    \"message\" : \"Invalid or missing Api key\"\n" +
                   "}");
           return;
        }
        chain.doFilter(request,response);

    }
}
