
/**
 * Author: 4150
 * Date: 25/10/11 13:35
 */
class DelegatingMyInterface implements MyInterface{
    @Delegate
    MyInterface delegate
}
