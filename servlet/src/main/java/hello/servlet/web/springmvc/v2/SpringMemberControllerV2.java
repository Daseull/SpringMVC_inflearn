package hello.servlet.web.springmvc.v2;

import hello.servlet.domain.Member;
import hello.servlet.domain.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * v2
 * @RequestMapping을 메서드 레벨로 사용하므로, 컨트롤러를 통합할 수 있다.
 * @RequestMapping을 클래스 레벨로 사용하여, 중복 URI를 제거한다.
 */

@Controller
@RequestMapping("/spring-mvc/v2/members")
public class SpringMemberControllerV2 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @RequestMapping("/new-form")
    public ModelAndView memberForm() {
        return new ModelAndView("new-form");
    }

    @RequestMapping
    public ModelAndView members() {
        List<Member> members = memberRepository.findAll();

        ModelAndView mv = new ModelAndView("members");
        mv.addObject("members", members);
        return mv;
    }

    @RequestMapping("/save")
    public ModelAndView save(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        Member member = memberRepository.save(new Member(username, age));

        ModelAndView mv = new ModelAndView("save-result");
        mv.addObject("member", member);
        return mv;
    }


}
