import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

/**
 * Author: 4150
 * Date: 25/10/11 13:33
 */
@ContextConfiguration('classpath:test-context.xml')
class MyServiceTest extends Specification {
    def myInterface = Mock(MyInterface)

    @Autowired
    MyInterface myInterfaceDelegate

    @Autowired
    MyService myService

    def setup() {
        myInterfaceDelegate.delegate = myInterface
    }

    def "testing regular behaviour"() {
        when:
        def result = myService.invokeMyMethod()
        then:
        1 * myInterface.myMethod() >> 1
        result == 1
    }

    def "testing some more regular behaviour"() {
        when:
        def result = myService.invokeMyMethod()
        then:
        1 * myInterface.myMethod() >> 1
        result == 1
    }

}