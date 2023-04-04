package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 클라이언트에서 서버로 요청 데이터를
 * 'GET - 쿼리 파라미터' 나 'POST - HTML Form' 으로 전달하는 경우
 * @RequestParam (단순타입바인딩) 또는
 * @ModelAttribute (단순타입과 argument resolver 제외 한 나머지 바인딩) 를 이용한다
 */

@Slf4j
@RestController
public class RequestParamController {

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
    public String requestParamRequired(@RequestParam String username, //필수
                                       @RequestParam(required = false) Integer age  // int 는 null 허용 X
    ) {
        log.info("username = {}, age = {}", username, age);
        return "ok";
    }

    // 요청 파라미터의 기본값 지정
    // 문자열의 경우 null 과 빈문자 모두 default value 로 대체된다.
    @RequestMapping("/request-param-default")
    public String requestParamDefault(@RequestParam(defaultValue = "guest") String username,
                                      @RequestParam(defaultValue = "0") int age) {
        log.info("username = {}, age = {}", username, age);
        return "ok";
    }

    // Map 을 이용해 모든 파라미터를 가져올 수도 있다.
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String, Object> paramMap) {
        log.info("username = {}, age = {}", paramMap.get("username"), paramMap.get("age"));
        return "ok";
    }

    // @ModelAttribute 를 이용해 객체에 파라미터 값을 바인딩할 수 있다.
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData data) {
        log.info("username = {}, age = {}", data.getUsername(), data.getAge());
        return "ok";
    }

    // @ModelAttribute 생략 가능
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2(HelloData data) {
        log.info("username = {}, age = {}", data.getUsername(), data.getAge());
        return "ok";
    }

}
