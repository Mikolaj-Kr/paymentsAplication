package com.krawczak.netflixPayments.controller.usersControllers;

import com.krawczak.netflixPayments.service.GetModelAndView;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccountController {

    @Autowired
    GetModelAndView getModelAndView;

    @GetMapping("/pay-account")
    public ModelAndView getAccountController(){
        return new ModelAndView("main-site", getModelAndView.getModelAndViewParams("account"));
    }

    @GetMapping("/pay-account-change-password")
    public ModelAndView getChangePassword(){
        return new ModelAndView("main-site", getModelAndView.getModelAndViewParams("changePassword"));
    }

}
