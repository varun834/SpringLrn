package DependencyInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

/**
 * Here what we are doing is , we are implementing the HiInterface in 2 classes and we are using the
 * interface itself to tell Spring to find its implementation(bean) and return the instance with a twist.
 * We will name the obhect of HiService with a proper name like we will do it while creating the object of
 * that class.
 * For ex. we have a class called GoodMorningService for which we want to find the bean for.
 * So we will name it as goodMorningService.
 *
 */
@ContextConfiguration(locations = {"classpath:TestContextDependencyInjectWithInterface.xml"})
public class DependencyInjectionWithInterface extends AbstractTestNGSpringContextTests {

    /**Here we have mentioned a valid or meaningfull object name for the class of which
     * we want the instance of*/
//    @Autowired
//    HiService2 goodNightService2;

//    @Test
//    public void testDependencyInjection(){
//        System.out.println(goodNightService2.sayHi());
//    }

    /**Below we are using Qualifier annotation and in value we have provided the meaningfull
     * object name of the class for which we want to look for the bean*/
    @Autowired
    @Qualifier(value = "goodNightService2")
    HiService2 hiService2;

    @Test
    public void testDependencyInjection(){
        System.out.println(hiService2.sayHi());
    }

}

interface HiService2{
    public String sayHi();
}

@Component
class GoodMorningService2 implements HiService2{
    public String sayHi(){
        return "GoodMorning";
    }
}
@Component
class GoodNightService2 implements HiService2{
    public String sayHi(){
        return "GoodNight";
    }
}