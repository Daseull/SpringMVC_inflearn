package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //[status-line]
        resp.setStatus(HttpServletResponse.SC_OK);

        //[response header]
        resp.setHeader("Content-Type", "text/plain");
        resp.setHeader("Set-Cookie", "myCookie=good; Max-Age=600");
        resp.setHeader("my-header", "myCustomHeader");

        //[response 편의 메서드]
        resp.setContentType("text/plain");
        resp.addCookie(myCookie());

        //[response 바디]
        resp.getWriter().write("ok!");
    }

    private Cookie myCookie(){
        Cookie cookie = new Cookie("myCookie", "myValue");
        cookie.setMaxAge(600);
        return cookie;
    }

    private void redirect(HttpServletResponse response){
        response.setStatus(HttpServletResponse.SC_FOUND);
        response.setHeader("Location", "/hello-form.html");
    }


}
