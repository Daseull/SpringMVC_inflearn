package hello.springmvc.basic.request;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 클라이언트에서 HTTP 메세지 바디에 JSON 객체를 담아 요청하는 경우
 * @RequestBody 를 이용해여 데이터를 가져올 수 있다.
 */

// request
// content-type : application/json
// {"username":"hello", "age":20}

@Slf4j
@Controller // @RestController 사용 시 @Controller + @ResponseBody 이므로 더 이상 @ResponseBody 를 안달아줘도 됨.
public class RequestBodyJsonController {

    // v1 에서만 사용 ( String -> HelloData )
    private ObjectMapper objectMapper = new ObjectMapper();

    @ResponseBody
    @PostMapping("/request-body-json-v1")
    public String requestBodyJsonV1(@RequestBody String messageBody) throws JsonProcessingException {
        HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);
        log.info("username = {}, age = {}", helloData.getUsername(), helloData.getAge());
        return "ok";
    }

    // @RequestBody 객체 파라미터 사용
    // HttpEntity 나 @RequestBody 를 사용하면 HTTP 메시지 컨버터가 우리가 원하는 객체 등으로 변환해준다.
    // 주의! 이 때 @RequestBody 를 생략하면 스프링이 @ModelAttribute 로 인식하므로 생략하면 안된다.
    @ResponseBody
    @PostMapping("/request-body-json-v2")
    public String requestBodyJsonV2(@RequestBody HelloData helloData) {
        log.info("username = {}, age = {}", helloData.getUsername(), helloData.getAge());
        return "ok";
    }

    // response 메시지 바디에 json 객체를 반환하는 것도 가능하다.
    @ResponseBody
    @PostMapping("/request-body-json-v3")
    public HelloData requestBodyJsonV3(@RequestBody HelloData helloData) {
        log.info("username = {}, age = {}", helloData.getUsername(), helloData.getAge());
        return helloData;
    }


}
