package hello.servlet.web.frontcontroller.v4.adapter;

import hello.servlet.web.frontcontroller.v2.controller.ControllerV2;
import hello.servlet.web.frontcontroller.v4.ModelView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ControllerV2HandlerAdapter implements MyHandlerAdapter {
    @Override
    public boolean support(Object handler) {
        return (handler instanceof ControllerV2);
    }

    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        ControllerV2 controller = (ControllerV2) handler;
        String viewName = controller.process(request, response);
        return new ModelView(viewName);
    }
}
