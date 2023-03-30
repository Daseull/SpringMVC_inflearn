package hello.servlet.web.frontcontroller.v4;

import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v2.controller.MemberFormControllerV2;
import hello.servlet.web.frontcontroller.v2.controller.MemberListControllerV2;
import hello.servlet.web.frontcontroller.v2.controller.MemberSaveControllerV2;
import hello.servlet.web.frontcontroller.v3.controller.MemberFormControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberListControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberSaveControllerV3;
import hello.servlet.web.frontcontroller.v4.adapter.ControllerV2HandlerAdapter;
import hello.servlet.web.frontcontroller.v4.adapter.ControllerV3HandlerAdapter;
import hello.servlet.web.frontcontroller.v4.adapter.MyHandlerAdapter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static javax.servlet.http.HttpServletResponse.SC_NOT_FOUND;

@WebServlet("/front-controller/v4/*")
public class FrontControllerServletV4 extends HttpServlet {

    private Map<String, Object> handlerMap = new HashMap<>();
    private List<MyHandlerAdapter> handlerAdapters = new ArrayList<>();

    public FrontControllerServletV4() {
        initHandlerMap();
        initHandlerAdapters();
    }

    private void initHandlerMap() {
        handlerMap.put("/front-controller/v4/v2/members/new-form", new MemberFormControllerV2());
        handlerMap.put("/front-controller/v4/v2/members", new MemberListControllerV2());
        handlerMap.put("/front-controller/v4/v2/members/save", new MemberSaveControllerV2());
        handlerMap.put("/front-controller/v4/v3/members/new-form", new MemberFormControllerV3());
        handlerMap.put("/front-controller/v4/v3/members", new MemberListControllerV3());
        handlerMap.put("/front-controller/v4/v3/members/save", new MemberSaveControllerV3());
    }

    private void initHandlerAdapters() {
        handlerAdapters.add(new ControllerV2HandlerAdapter());
        handlerAdapters.add(new ControllerV3HandlerAdapter());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object handler = getHandler(request);
        if (handler == null) {
            response.setStatus(SC_NOT_FOUND);
            return;
        }

        MyHandlerAdapter adapter = getHandlerAdapter(handler);
        ModelView mv = adapter.handle(request, response, handler);

        MyView view = viewResolver(mv.getViewName());
        view.render(mv.getModel(), request, response);
    }

    private Object getHandler(HttpServletRequest request) {
        return handlerMap.get(request.getRequestURI());
    }

    private MyHandlerAdapter getHandlerAdapter(Object handler) {
        for (MyHandlerAdapter handlerAdapter : handlerAdapters) {
            if (handlerAdapter.support(handler)) {
                return handlerAdapter;
            }
        }
        throw new IllegalArgumentException("No Such Handler" + handler);
    }

    private MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }
}
