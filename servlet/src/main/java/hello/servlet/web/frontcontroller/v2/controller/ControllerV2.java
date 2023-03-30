package hello.servlet.web.frontcontroller.v2.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ControllerV2 {
    /**
     * @param request
     * @param response
     * @return viewName
     */
    String process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
