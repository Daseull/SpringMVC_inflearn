package hello.servlet.web.frontcontroller.v3.controller;

import hello.servlet.domain.Member;
import hello.servlet.domain.MemberRepository;

import java.util.Map;

public class MemberSaveControllerV3 implements ControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        String username = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));
        Member member = memberRepository.save(new Member(username, age));

        model.put("member", member);

        return "save-result";
    }
}
