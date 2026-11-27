package in.jatint4r.springbootcrudoperations.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Before("execution(String in.jatint4r.springbootcrudoperations.service.StudentService.dummyMethod())")
    public void logBeforeMethod(){
        System.out.println("Getting All students");
    }
}
