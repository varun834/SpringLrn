package AspectOrientedProgramming;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.Test;

@Configuration
@ComponentScan(basePackages = "AspectOrientedProgramming")
class JavaContextForAOP{
}

@Aspect
@Component
class MyAspect{
    //@Before is used to do something which I want to do before running the method
//    @Before()
}

@ContextConfiguration(classes = JavaContextForAOP.class)
public class AOPExample {


    @Autowired
    HiByeService service;

    @Test
    public void testSomething(){
        service.sayHi();
        service.sayBye();
    }


}

@Component
class HiByeService{

    public void sayHi(){
        System.out.println("Hi");
    }
    public void sayBye(){
        System.out.println("Bye");
    }
    public void returnSomething(){
        System.out.println("Hi Bye");
    }
}
