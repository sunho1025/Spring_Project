package com.example.kopo_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //애너테이션 - 일종의 메타데이터
public class HelloController {
    //변수는 직관적으로 이해가능한 언어를 활용
    //리팩토링 - 새로운 라이브러리 또는 기능적으로 분리 및 병합이 필요할때 수행하는 코드변경
    @GetMapping("/hello") //url 요청받는 주소
    public String helloooo(Model model){
        //머스테치를 호출하는 방법
        //리턴시 파일명을 넘겨준다.
        model.addAttribute("username", "소똥이");
        return "hello";
    }

    @GetMapping("/seeyou") //url 요청받는 주소
    public String seeyou(Model model){
        //머스테치를 호출하는 방법
        //리턴시 파일명을 넘겨준다.
        model.addAttribute("username", "소똥이");
        return "seeyou";
    }

}
