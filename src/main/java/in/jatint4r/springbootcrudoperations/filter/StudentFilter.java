package in.jatint4r.springbootcrudoperations.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class StudentFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Request filter");
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        String header = httpServletRequest.getHeader("token");
        if(header==null || !header.equals("12345")) {
            httpServletResponse.setStatus(401);
            return;
        }
        System.out.println("Request is "+httpServletRequest.getMethod() + " " + httpServletRequest.getRequestURI());
        chain.doFilter(request,response);
        System.out.println("Response Filter");
        System.out.println("Response is "+ httpServletResponse.getStatus());
    }
}
