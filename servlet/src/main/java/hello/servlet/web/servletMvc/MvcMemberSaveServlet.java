package hello.servlet.web.servletMvc;

import hello.servlet.domain.Member;
import hello.servlet.domain.MemberRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/servlet-mvc/members/save")
public class MvcMemberSaveServlet extends HttpServlet {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //로직
        String username = req.getParameter("username");
        int age = Integer.parseInt(req.getParameter("age"));
        Member member = new Member(username, age);
        memberRepository.save(member);

        //모델에 데이터 저장
        req.setAttribute("member", member);

        //뷰 페이지 이동
        String viewPath = "/WEB-INF/views/save-result.jsp";
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(viewPath);
        requestDispatcher.forward(req, resp);

    }
}
