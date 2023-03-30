package hello.servlet.web.frontcontroller.v4.adapter;

import hello.servlet.web.frontcontroller.v4.ModelView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface MyHandlerAdapter {
    /**
     * @param handler : Controller
     * @return : 해당 어댑터가 지원하는 handler(Controller)인지 반환
     */
    boolean support(Object handler);

    /**
     * @param request
     * @param response
     * @param handler  : ControllerV2 - 파라미터로 request, response / ControllerV3 - 파라미터로 paramMap, model
     * @return viewName
     */
    ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException;
}
