package com.krawczak.netflixPayments.controller.adminContollers;

import com.krawczak.netflixPayments.service.GetModelAndView;
import com.krawczak.netflixPayments.service.PaymentService;
import com.krawczak.netflixPayments.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class UsersPaymentsController {

    @Autowired
    GetModelAndView getModelAndView;

    @Autowired
    PaymentService paymentService;

    @Autowired
    UserService userService;

    @RequestMapping("/pay-users-payments")
    public ModelAndView getUsersPayments(HttpServletRequest request){
        Map<String, Object> params = getModelAndView.getModelAndViewParams("userPayments");
        params.put("paymentList",paymentService.getUserPayments(request.getParameter("username")));
        return new ModelAndView("main-site", params);
    }
}
