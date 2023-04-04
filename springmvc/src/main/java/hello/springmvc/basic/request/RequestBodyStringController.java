package hello.springmvc.basic.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

/**
 * 클라이언트에서 HTTP 메세지 바디에 데이터를 담아 요청하는 경우
 * HttpEntity(<- RequestEntity, ResponseEntity) 나
 * @RequestBody(실무에서 가장 많이 사용) 를 이용해여 데이터를 가져올 수 있다.
 */

@Slf4j
@Controller
public class RequestBodyStringController {

    @PostMapping("/request-body-string-v1")
    public void requestBodyStringV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletInputStream inputStream = request.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        log.info("messageBody = {}", messageBody);

        response.getWriter().write("ok");
    }

    // 서블릿에서 필요한 부분인 inputStream 과 Writer 만 가져올 수 있다.
    @PostMapping("/request-body-string-v2")
    public void requestBodyStringV2(InputStream inputStream, Writer responseWriter) throws IOException {
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        log.info("messageBody = {}", messageBody);

        responseWriter.write("ok");
    }

    // HttpEntity 를 이용하여 요청의 http header 와 body 정보를 편리하게 조회할 수 있다.
    // 응답도 HttpEntity 에 body 정보를 직접 반환할 수 있다.
    @PostMapping("/request-body-string-v3")
    public HttpEntity<String> requestBodyStringV3(HttpEntity<String> httpEntity) {
        log.info("messageBody = {}", httpEntity.getBody());
        return new HttpEntity<>("ok");
    }

    // HttpEntity 를 상속받은 RequestEntity 나 ResponseEntity 를 사용할 수도 있다.
    @PostMapping("/request-body-string-v4")
    public ResponseEntity<String> requestBodyStringV4(RequestEntity<String> request) {
        log.info("messageBody = {}", request.getBody());
        return new ResponseEntity<>("쨔쟌", HttpStatus.OK);
    }

    // HttpEntity<> 대신 @RequestBody 를 이용하여 쉽게 메세지 바디를 가져올 수 있다.
    // HttpEntity<> 대신 @ResponseBody 를 이용하여 쉽게 메세지 바디에 데이터를 전달할 수 있다.
    @ResponseBody
    @PostMapping("/request-body-string-v5")
    public String requestBodyStringV5(@RequestBody String messageBody) {
        log.info("messageBody = {}", messageBody);
        return "ok!";
    }

}
