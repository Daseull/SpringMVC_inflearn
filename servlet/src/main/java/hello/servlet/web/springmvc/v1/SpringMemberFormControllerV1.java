package hello.servlet.web.springmvc.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SpringMemberFormControllerV1 {

    @RequestMapping("/spring-mvc/v1/members/new-form")
    public ModelAndView process() {
        return new ModelAndView("new-form");
    }

    // 해당 URL이 호출 되면, 이 메서드가 호출된다.
    // 따라서 더이상 메서드 명이 process 일 필요 없으며 임의대로 지어도 된다.
    @RequestMapping("/spring-mvc/v1/members/daseull-new-form")
    public String hello() {
        return "new-form";
    }

}
