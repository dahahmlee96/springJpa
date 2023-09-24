package com.example.springbootjpapractice.controller;

import com.example.springbootjpapractice.domain.User;
import com.example.springbootjpapractice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest request, Model model) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        return mav;
    }

    @RequestMapping(value = "/email", method = RequestMethod.GET)
    public ModelAndView email(HttpServletRequest request, Model model) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("email");
        User user = userService.getByEmail("diana.lee@devcra.com");
        mav.addObject("user", user);

        return mav;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(HttpServletRequest request, Model model, HttpSession session) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String result = "";
        User user = userService.getByEmail(email);
        ModelAndView mav = new ModelAndView();

        if (user==null) {
            result = "해당 이메일 회원은 존재하지 않습니다.";
        } else {
            if (!password.equals(user.getPassword())) {
                result="비밀번호 불일치";
            } else {
                result=user.getName()+"님, 로그인 성공";
            }
        }

        return result;
    }

}
