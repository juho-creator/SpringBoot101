package org.example.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.example.dto.UserRequest;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@Controller
public class UserApiController {

    private final UserService userService;

    // [POST] Signup
    @PostMapping("/user")
    public String signup(@ModelAttribute UserRequest dto){
        // 이메일, 비밀번호 출력 (디버깅 용도)
        System.out.println("회원가입 요청 - 이메일: " + dto.getEmail());
        System.out.println("회원가입 요청 - 비밀번호: " + dto.getPassword());
        userService.save(dto); // save user info
        return "redirect:/login";
    }


    // [GET] Logout
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response){
        new SecurityContextLogoutHandler().logout(request, response,
                SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/login";
    }
}
