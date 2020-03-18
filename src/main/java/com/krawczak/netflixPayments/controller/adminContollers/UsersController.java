package com.krawczak.netflixPayments.controller.adminContollers;

import com.krawczak.netflixPayments.service.GetModelAndView;
import com.krawczak.netflixPayments.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class UsersController {

    @Autowired
    GetModelAndView getModelAndView;

    @Autowired
    UserService userService;

    @RequestMapping("/pay-users")
    public ModelAndView getUsers(){
        Map<String, Object> params = getModelAndView.getModelAndViewParams("users");
        params.put("usersList", userService.findAllUsers());
        return new ModelAndView("main-site", params);
    }
}
