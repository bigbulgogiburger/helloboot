package tobyspring.helloboot;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class HelloController {

    private final HelloService helloService;


    public HelloController(HelloService helloService) {
        this.helloService = helloService;

    }


    @GetMapping("/hello")
    public String hello(String name){

        System.out.println("is true ?  : " +(name ==null || name.trim().length() == 0));
        if(name ==null || name.trim().length() == 0) {
            System.out.println("name = " + name);
            throw new IllegalArgumentException();
        };

        return helloService.sayHello(name);
    }
}
