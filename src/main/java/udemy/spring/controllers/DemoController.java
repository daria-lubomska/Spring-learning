package udemy.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@Controller
public class DemoController {

  @GetMapping("/hello")
  public String hello(){
    return "hello";
  }

  //ViewResolver prepare path : prefix + welcome (line 19) + suffix = /WEB-INF/view/welcome.jsp
  @GetMapping("welcome")
  public String welcome(){
    return "welcome";
  }

}
