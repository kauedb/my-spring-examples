package kauedb.spring.examples.profiling;

import org.perf4j.aop.Profiled;

/**
 * User: kauedb
 * Date: 12/9/13
 * Time: 12:03 AM
 */
public class HelloWorld {


    @Profiled
    public String say(){
        return "Hello World!!!";
    }

}
