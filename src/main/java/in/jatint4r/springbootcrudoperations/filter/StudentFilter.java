package in.jatint4r.springbootcrudoperations.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

//@Component
@Order(2)
public class StudentFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Request filter");
        long start = System.currentTimeMillis();
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        System.out.println("Request is "+httpServletRequest.getMethod() + " " + httpServletRequest.getRequestURI());
        chain.doFilter(request,response);
        long duration = System.currentTimeMillis() - start;
        System.out.println( "Api Response time is " + duration );
        System.out.println("Response Filter");
        System.out.println("Response is "+ httpServletResponse.getStatus());
    }
}
