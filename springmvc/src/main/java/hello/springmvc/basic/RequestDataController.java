package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class RequestDataController {

    // 클라이언트에서 서버로 요청 데이터를
    // 'GET - 쿼리 파라미터' 나 'POST - HTML Form' 으로 전달하는 경우
    // @RequestParam 을 이용해 데이터를 가져올 수 있다.
    @RequestMapping(value = {"/get-query-parameter-v1", "/post-html-form"})
    public String requestParamV1(@RequestParam("username") String memberName,
                               @RequestParam("age") int memberAge) {
        log.info("username = {}, age = {}", memberName, memberAge);
        return "ok";
    }

    // HTTP 요청 파라미터 이름이 변수 이름과 같으면 @RequestParam 에서 value 생략 가능하다
    // String, int, Integer 등의 단순 타입이면 @RequestParam 도 생략 가능하다.
    @RequestMapping("/get-query-parameter-v2")
    public String requestParamV2(@RequestParam String username,
                                 @RequestParam int age) {
        log.info("username = {}, age = {}", username, age);
        return "ok";
    }

    // 요청 파라미터의 필수 여부 지정 (기본값 : true)
    @RequestMapping("/request-param-required")
    public String requestParamV3(@RequestParam String username, //필수
                                 @RequestParam(required = false) Integer age  // int 는 null 허용 X
    ) {
        log.info("username = {}, age = {}", username, age);
        return "ok";
    }

}
