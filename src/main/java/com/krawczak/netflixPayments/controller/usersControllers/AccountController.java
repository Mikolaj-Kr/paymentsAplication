package com.krawczak.netflixPayments.controller.usersControllers;

import com.krawczak.netflixPayments.configuration.PasswordEncoder;
import com.krawczak.netflixPayments.service.ChangePasswordService;
import com.krawczak.netflixPayments.service.GetModelAndView;
import com.krawczak.netflixPayments.service.UserService;
import org.dom4j.rule.Mode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Controller
public class AccountController {

    @Autowired
    GetModelAndView getModelAndView;

    @Autowired
    ChangePasswordService changePasswordService;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/pay-account")
    public ModelAndView getAccountController() {
        return new ModelAndView("main-site", getModelAndView.getModelAndViewParams("account"));
    }

    @GetMapping("/pay-account-change-password")
    public ModelAndView getChangePassword(HttpServletRequest request) {
        Map<String, Object> params = getModelAndView.getModelAndViewParams("changePassword");
        params.put("status", request.getParameter("status"));
        return new ModelAndView("main-site", params);
    }

    @PostMapping("/pay-account-change-password")
    public ResponseEntity<String> postChangePassword(@RequestParam(value = "oldPassword") String oldPassword, @RequestParam(value = "password") String password, @RequestParam(value = "password2") String password2, @RequestParam(value = "username") String username, HttpServletResponse response) throws IOException {
        switch (changePasswordService.changeUserPassword(username, oldPassword, password, password2)) {
            case 1:
                response.sendRedirect("pay-account-change-password?status=" + 1);
                logger.info("Password for " + username + "changed");
                break;
            case 2:
                response.sendRedirect("pay-account-change-password?status=" + 2);
                logger.info("Password for " + username + "can't change old password not equals");
                break;
            case 3:
                response.sendRedirect("pay-account-change-password?status=" + 3);
                logger.info("Password for " + username + "not changed new password not equals");
                break;
        }

        return new ResponseEntity<>(username, HttpStatus.OK);
    }
}
