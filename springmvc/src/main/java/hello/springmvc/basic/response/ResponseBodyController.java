package hello.springmvc.basic.response;

import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@Controller
public class ResponseBodyController {

    // 문자열 응답 1 : ResponseEntity 사용 (Status 를 지정할 수 있다.)
    @GetMapping("/response-body-string-v1")
    public ResponseEntity<String> responseBodyV1() {
        return new ResponseEntity<>("ok", HttpStatus.CREATED);
    }

    // 문자열 응답 2 : @ResponseBody 사용
    // @ResponseStatus 로 Status 지정 (동적으로 사용불가 / 동적 사용 시에는 ResponseEntity 를 사용할 것)
    @ResponseBody
    @GetMapping("/response-body-string-v2")
    public String responseBodyV2() {
        return "ok";
    }

    // Json 응답 1 : ResponseEntity 사용
    @GetMapping("/response-body-json-v1")
    public ResponseEntity<HelloData> responseBodyJsonV1() {
        return new ResponseEntity<>(new HelloData("hello", 20), HttpStatus.CREATED);
    }

    // JSON 응답 2 : @ResponseBody 사용
    // @ResponseStatus 로 Status 지정
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    @GetMapping("/response-body-json-v2")
    public HelloData responseBodyJsonV2() {
        return new HelloData("hello", 20);
    }


}
