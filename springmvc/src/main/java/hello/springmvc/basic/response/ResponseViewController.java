package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

// 동적 html 응답
// Model 사용

@Controller
public class ResponseViewController {

    // Spring 의 ModelAndView 사용
    @GetMapping("/response-view-v1")
    public ModelAndView responseViewV1() {
        return new ModelAndView("hello")
                .addObject("data", "hello");
    }

    // Model 사용
    @GetMapping("/response-view-v2")
    public String responseViewV2(Model model) {
        model.addAttribute("data", "hello");
        return "hello"; // ViewName 반환
    }

}
