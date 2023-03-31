package hello.servlet.web.springmvc.v3;

import hello.servlet.domain.Member;
import hello.servlet.domain.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * v3
 * - @RequestMapping(method=XX) 에서 @PostMapping, @GetMapping으로 변경
 * - HttpServletRequest 대신 @RequestParam을 받아 서블릿 종속성 제거
 * - Model을 파라미터로 받고, ViewName을 반환하는 더 실용적인 방식 채택
 */

@Controller
@RequestMapping("/spring-mvc/v3/members")
public class SpringMemberControllerV3 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

//    @RequestMapping(method = RequestMethod.GET, value = "/new-form")
    @GetMapping("/new-form")
    public String memberForm() {
        return "new-form";
    }

//    @RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public String members(Model model) {

        List<Member> members = memberRepository.findAll();

        model.addAttribute("members", members);

        return "members";
    }

//    @RequestMapping(method = RequestMethod.POST, value = "/save")
    @PostMapping("/save")
    public String save(@RequestParam("username") String username,
                       @RequestParam("age") int age,
                       Model model) {

          Member member = memberRepository.save(new Member(username, age));

        model.addAttribute("member", member);

        return "save-result";
    }

}
