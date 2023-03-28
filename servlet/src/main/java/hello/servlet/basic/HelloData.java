package hello.servlet.basic;

/*
* JSON 변환 라이브러리 jackson
* -> 직렬화에는 getter, 역직렬화에는 기본생성자와 setter 사용
 */

/*
* DTO
* 모든 속성은 private
* 기본 생성자 필요
* 직렬화가 가능해야함
* */

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HelloData {
    private String username;
    private int age;
}
