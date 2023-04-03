package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.HttpMethodConstraintElement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Slf4j
@RestController
public class RequestHeaderController {

    // 애노테이션 기반의 스프링 컨트롤러는 다양한 파라미터를 지원한다.
    // (참고 https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc-ann-methods)
    // HTTP 헤더 정보도 파라미터를 통해 쉽게 가져올 수 있다.
    @RequestMapping("/headers")
    public String headers(HttpMethod httpMethod, //HTTP 메서드
                          Locale locale, //국가 및 언어 설정
                          @RequestHeader MultiValueMap<String, String> headerMap, //모든 헤더 가져오기
                          @RequestHeader("host") String host, // 특정 헤더 가져오기
                          @CookieValue(value = "mycookie", required = false) String cookie // required : 필수값 여부
                          ){

        log.info("httpMethod = {}", httpMethod);
        log.info("locale = {}", locale);
        log.info("headerMap = {}", headerMap);
        log.info("header host = {}", host);
        log.info("mycookie = {}", cookie);

        return "ok";
    }



}
