package DependencyInjection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

/**
 * Below two things we need to use if we are using JUnit
 * @RunWith(SpringJUnit4ClassRunner.class)
 * @ContextConfiguration(locations = {"/TestContext.xml"})
 *
 * =======================
 *
 * If we are using TestNG
 * we need to use
 * @ContextConfiguration(locations = {"classpath:TestContext.xml"})
 * and the class should extend AbstractTestNGSpringContextTests class
 * */


@ContextConfiguration(locations = {"classpath:TestContext.xml"})
public class DependencyInjectionExample extends AbstractTestNGSpringContextTests {

    /**1st way*/
//    @Autowired
//    GoodMorningService service;

    @Autowired
    HiService service;


    @Test
    public void test1(){
        System.out.println(service.sayHi());
    }
}

/**1st way */
//@Component
//class GoodMorningService {
//    public String sayHi(){
//        return "GoodMorning";
//    }
//}

/**@nd Way*/

@Component
class GoodMorningService implements HiService{
    @Override
    public String sayHi(){
        return "GoodMorning";
    }
}

interface HiService{
    public String sayHi();
}

@Component
class GoodNightService implements HiService{
    @Override
    public String sayHi(){
        return "GoodNight";
    }
}
