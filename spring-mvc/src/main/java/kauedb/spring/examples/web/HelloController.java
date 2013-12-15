package kauedb.spring.examples.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * User: kauedb
 * Date: 11/23/13
 * Time: 8:46 AM
 */
@Controller
@RequestMapping("hello")
public class HelloController {


    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String hello(){
        return "Hello";
    }

}
