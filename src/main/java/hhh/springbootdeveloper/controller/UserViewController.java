package hhh.springbootdeveloper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//사용자가 회원 가입, 로그인 경로에 접근하면 회원 가입, 로그인 화면으로 연결해주는 컨트롤러
@Controller
public class UserViewController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }
}
