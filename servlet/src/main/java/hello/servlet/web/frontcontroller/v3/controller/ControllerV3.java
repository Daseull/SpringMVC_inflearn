package hello.servlet.web.frontcontroller.v3.controller;

import java.util.Map;

public interface ControllerV3 {
    /**
     * @param paramMap : request에서 가져온 데이터
     * @param model    : view에 전달할 데이터 (FrontController에서 빈 객체를 대신 생성해준다. 컨트롤러에서는 생성 과정 없이 필요한 데이터를 보관하기만 하면 된다.)
     * @return viewName
     */
    String process(Map<String, String> paramMap, Map<String, Object> model);
}
