package com.krawczak.netflixPayments.controller.usersControllers;

import com.krawczak.netflixPayments.service.GetModelAndView;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    private final GetModelAndView getModelAndView;

    @Autowired
    public LoginController(GetModelAndView getModelAndView) {
        this.getModelAndView = getModelAndView;
    }

    @RequestMapping("/login")
    public ModelAndView getLoginPage(HttpServletRequest request) {
        String error = request.getParameter("error");
        Map<String, Object> params = new HashMap<>();
        if (error != null){
          params = getModelAndView.getModelAndViewParams("login-error");
        } else {
          params = getModelAndView.getModelAndViewParams("login");
        }
      return new ModelAndView("main-site", params);
    }
}
