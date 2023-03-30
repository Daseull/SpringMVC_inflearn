package hello.servlet.web.frontcontroller.v1.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// FrontController를 제외한 나머지 컨트롤러들을 더이상 서블릿을 사용할 필요가 없다.
// 인터페이스를 사용하여 컨트롤러는 로직의 일관성을 가질 수 있다.
public interface ControllerV1 {
    void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}
