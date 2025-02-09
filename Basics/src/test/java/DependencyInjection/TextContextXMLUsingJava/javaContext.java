package DependencyInjection.TextContextXMLUsingJava;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

@Configuration
@ComponentScan(basePackages = "DependencyInjection.TextContextXMLUsingJava")
class JavaTestContext{

}

@ContextConfiguration(classes = JavaTestContext.class)
public class javaContext extends AbstractTestNGSpringContextTests {
    @Autowired
    @Qualifier(value = "goodNightService3")
    HiService3 hiService3;

    @Test
    public void testDependencyInjection(){
         Assert.assertEquals(hiService3.sayHi(), "GoodMorning", "Invalid message returned");
        System.out.println(hiService3.sayHi());
    }

}
interface HiService3{
    public String sayHi();
}

@Component
class GoodMorningService3 implements HiService3 {
    public String sayHi(){
        return "GoodMorning";
    }
}
@Component
class GoodNightService3 implements HiService3 {
    public String sayHi(){
        return "GoodNight";
    }
}