package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello") //hello 로 요청이 오면 HelloServlet 호출
public class HelloServlet extends HttpServlet {
    //HelloServlet 이 호출되면 service 메서드가 자동으로 호출된다.
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HelloServlet.service");

        System.out.println("request = " + request);
        System.out.println("request.getParameter(\"username\") = " + request.getParameter("username"));

        System.out.println("response = " + response);
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("hello " + request.getParameter("username")); //http 메세지 바디에 쓰기
    }
}
