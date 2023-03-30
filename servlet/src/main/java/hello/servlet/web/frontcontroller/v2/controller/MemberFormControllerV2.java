package hello.servlet.web.frontcontroller.v2.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberFormControllerV2 implements ControllerV2 {

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return "new-form";
    }

}
