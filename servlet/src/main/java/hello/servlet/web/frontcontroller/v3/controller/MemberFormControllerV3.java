package hello.servlet.web.frontcontroller.v3.controller;

import java.util.Map;

public class MemberFormControllerV3 implements ControllerV3 {
    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        return "new-form";
    }
}
