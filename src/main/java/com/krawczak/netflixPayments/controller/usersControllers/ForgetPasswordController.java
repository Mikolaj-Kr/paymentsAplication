package com.krawczak.netflixPayments.controller.usersControllers;

import com.krawczak.netflixPayments.configuration.PasswordEncoder;
import com.krawczak.netflixPayments.service.ForgetPasswordService;
import com.krawczak.netflixPayments.service.GetModelAndView;
import com.krawczak.netflixPayments.service.UserService;
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
public class ForgetPasswordController {

    private final GetModelAndView getModelAndView;

    private final ForgetPasswordService forgetPasswordService;


    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public ForgetPasswordController(UserService userService, GetModelAndView getModelAndView, ForgetPasswordService forgetPasswordService, PasswordEncoder passwordEncoder) {
        this.getModelAndView = getModelAndView;
        this.forgetPasswordService = forgetPasswordService;
    }

    @GetMapping("/pay-forget-password")
    public ModelAndView getForgotPassword() {
        Map<String, Object> params = getModelViewParams("forgetPassword");
        return new ModelAndView("main-site", params);
    }

    @GetMapping("/pay-forget-password-mail-sent")
    public ModelAndView getForgotPasswordMailSent() {
        return new ModelAndView("main-site", getModelViewParams("forgetPasswordMailSent"));
    }

    @GetMapping("/pay-forget-change-password")
    public ModelAndView getChangeForgottenPassword(HttpServletRequest request) {
        Map<String, Object> params = getModelAndView.getModelAndViewParams("forgetChangePassword");
        params.put("code", request.getParameter("code"));
        params.put("username", request.getParameter("username"));
        params.put("status", request.getParameter("status"));
        return new ModelAndView("main-site", params);
    }

    @GetMapping("/pay-password-changed")
    public ModelAndView getPasswordChanged(){
        return new ModelAndView("main-site", getModelAndView.getModelAndViewParams("forgetPasswordChanged"));
    }

    @GetMapping("/pay-password-changed-error")
    public ModelAndView getPasswordChangedError(){
        return new  ModelAndView("main-site", getModelAndView.getModelAndViewParams("forgetChangePasswordError"));
    }

    @PostMapping("/pay-change-password")
    public ResponseEntity<String> postChangeForgottenPassword(@RequestParam(value = "password") String password, @RequestParam(value = "password2") String password2, @RequestParam(value = "code") String code, @RequestParam(value = "username") String username, HttpServletResponse response) throws IOException {
        String changePasswordStatus = forgetPasswordService.changePassword(password, password2, username, code);
        if(changePasswordStatus.equals("ok")){
            response.sendRedirect("pay-password-changed");
            logger.info(username + " password changed");
        } else if(changePasswordStatus.equals("password not equals")){
            response.sendRedirect("pay-forget-change-password?status=fail&username=" + username +"&code=" + code);
            logger.info(username + " try to change password but passwords not equals");
        } else{
            response.sendRedirect("pay-change-password-error");
            logger.warn(username + " change password error");
        }

    return new ResponseEntity<>(username, HttpStatus.OK);
    }

    @PostMapping("/pay-forget-password-send-mail")
    public ResponseEntity<String> postSendMailResetPassword(@RequestParam(value = "email") String username, HttpServletResponse response) throws IOException {
        forgetPasswordService.forgetPassword(username);
        response.sendRedirect("/pay-forget-password-mail-sent");
        return new ResponseEntity<>(username, HttpStatus.OK);
    }


    public Map<String, Object> getModelViewParams(String page) {
        return getModelAndView.getModelAndViewParams(page);
    }
}
