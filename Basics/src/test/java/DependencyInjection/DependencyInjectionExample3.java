package DependencyInjection;

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
@ComponentScan(basePackages = "DependencyInjection")
class JavaTestContext2{

}

@ContextConfiguration(classes = JavaTestContext2.class)
public class DependencyInjectionExample3 extends AbstractTestNGSpringContextTests {

    /** SETTER INJECTION
     * Here we will use setter for Autowiring
     * */
    private HiService4 hiService4;

//    @Autowired
//    @Qualifier(value = "goodNightService4")
//    public void setService(HiService4 hiService4){
//        this.hiService4 = hiService4;
//    }

    /**
     * Constructor Injection
     * We can also use Constructor and Autowire it
     * */
//    @Autowired
//    public DependencyInjectionExample3(HiService4 hiService4){
//        this.hiService4 = hiService4;
//    }


    @Test
    public void testDependencyInjection(){
        Assert.assertEquals(hiService4.sayHi(), "GoodNight", "Invalid message returned");
        System.out.println(hiService4.sayHi());
    }


}
interface HiService4{
    public String sayHi();
}

@Component
class GoodMorningService4 implements HiService4 {
    public String sayHi(){
        return "GoodMorning";
    }
}
@Component
class GoodNightService4 implements HiService4 {
    public String sayHi(){
        return "GoodNight";
    }
}