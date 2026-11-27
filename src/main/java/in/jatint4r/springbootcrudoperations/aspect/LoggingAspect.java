package in.jatint4r.springbootcrudoperations.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Before("execution(String in.jatint4r.springbootcrudoperations.service.StudentService.dummyMethod())")
    public void logBeforeMethod(){
        System.out.println("Hello students");
    }

    @AfterReturning(value = "execution(String in.jatint4r.springbootcrudoperations.service.StudentService.dummyMethod())",
         returning = "result")
    public void logAfterReturnMethod(String result){
        System.out.println("Return Students with result " + result);
    }

    @AfterThrowing(value = "execution(String in.jatint4r.springbootcrudoperations.service.StudentService.dummyMethod())",
                  throwing = "exception")
    public void logAfterReturnThrowMethod(Throwable exception){
        System.out.println(exception.getMessage() + exception.getClass().getName());
    }

    @After("execution(String in.jatint4r.springbootcrudoperations.service.StudentService.dummyMethod())")
    public void logAfterMethod(){
        System.out.println("Hello students After");
    }


}
