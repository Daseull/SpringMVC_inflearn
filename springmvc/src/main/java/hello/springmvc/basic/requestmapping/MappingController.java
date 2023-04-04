package hello.springmvc.basic.requestmapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController // 리턴값을 HTTP 메세지 바디에 바로 입력
public class MappingController {

    // @RequestMapping 을 이용한 기본 매핑
    @RequestMapping("/hello-basic")
    public String helloBasic() {
        log.info("helloBasic");
        return "ok";
    }

    // 여러개의 URI 매핑도 가능하다
    @RequestMapping({"/hello-basic-1", "/hello-basic-2"})
    public String helloBasics() {
        log.info("helloBasics");
        return "ok";
    }

    // @RequeustMapping 에 메서드를 지정하지 않으면 모든 메서드를 허용한다.
    // 특정 메서드에만 호출되기 위해서는 메서드를 지정해준다.
    // 허용되지 않은 메서드로 접근 시 스프링이 405 Method Not Allowed를 반환한다.
    @RequestMapping(value = "/mapping-get-v1", method = RequestMethod.GET)
    public String mappingGetV1() {
        log.info("mappingGetV1");
        return "ok";
    }

    // @RequestMapping(method = RequestMethod.XXX) 대신
    // 축약 애노테이션인 @GetMapping, @PostMapping 등을 사용할 수 있다.
    @GetMapping("/mapping-get-v2")
    public String mappingGetV2() {
        log.info("mappingGetV2");
        return "ok";
    }

    // @PathVariable(strName) 을 이용하여 특정 이름의 경로 변수를 가져올 수 있다.
    // 패스의 변수명과 파라미터 변수명을 동일하게 지정하면 @PathVariable 에 이름을 지정하지 않아도 된다.
    @GetMapping("/mapping/{username}")
    public String mappingPath(@PathVariable String username) {
        log.info("mappingPath username = {}", username);
        return "ok";
    }

    // 여러개의 PathVariable 도 사용할 수 있다.
    @GetMapping("/mapping/users/{username}/orders/{orderId}")
    public String mappingPath(@PathVariable String username,
                              @PathVariable Long orderId) {
        log.info("mappingPath username = {}, orderId = {}", username, orderId);
        return "ok";
    }

    // 특정 파라미터 조건 매핑
    // 해당 파라미터를 가진 요청들을 처리한다.
    @GetMapping(value = "/mapping-param", params = "mode=debug")
    public String mappingParam() {
        log.info("conditionMappingParam");
        return "ok";
    }

    // 특정 헤더 조건 매핑
    // 해당 헤더값을 가진 요청들을 처리한다.
    @GetMapping(value = "/mapping-header", headers = "mode=debug")
    public String mappingHeader() {
        log.info("conditionMappingHeader");
        return "ok";
    }

}
