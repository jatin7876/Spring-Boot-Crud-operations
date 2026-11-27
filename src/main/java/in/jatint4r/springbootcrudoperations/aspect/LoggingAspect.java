package in.jatint4r.springbootcrudoperations.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

//    @Before("execution(String in.jatint4r.springbootcrudoperations.service.StudentService.dummyMethod())")
//    public void logBeforeMethod(){
//        System.out.println("Hello students");
//    }
//
//    @AfterReturning(value = "execution(String in.jatint4r.springbootcrudoperations.service.StudentService.dummyMethod())",
//         returning = "result")
//    public void logAfterReturnMethod(String result){
//        System.out.println("Return Students with result " + result);
//    }
//
//    @AfterThrowing(value = "execution(String in.jatint4r.springbootcrudoperations.service.StudentService.dummyMethod())",
//                  throwing = "exception")
//    public void logAfterReturnThrowMethod(Throwable exception){
//        System.out.println(exception.getMessage() + exception.getClass().getName());
//    }
//
//    @After("execution(String in.jatint4r.springbootcrudoperations.service.StudentService.dummyMethod())")
//    public void logAfterMethod(){
//        System.out.println("Hello students After");
//    }

    @Around("execution(* in.jatint4r.springbootcrudoperations.service.StudentService.dummyMethod(..))")
    public String logAroundMethod(ProceedingJoinPoint joinPoint) throws  Throwable{
//        System.out.println("Before");
//        String str= (String) joinPoint.proceed();
//        System.out.println("After");


//        try{
//            String str= (String) joinPoint.proceed();
//            return str;
//        }
//        catch(Exception e){
//            System.out.println("Exception is " + e.getMessage());
//            throw  e;
//        }
//        finally{
//            System.out.println("Execution Completed");
//        }

        //Calling multiple times
        Object return1 = joinPoint.proceed();
        System.out.println("Calling again");
        Object return2 = joinPoint.proceed();
        return (String) return2;

    }

}
