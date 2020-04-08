package com.krawczak.netflixPayments.controller.usersControllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.krawczak.netflixPayments.domain.dto.PaymentDto;
import com.krawczak.netflixPayments.email.MailService;
import com.krawczak.netflixPayments.mapper.apiMapper.MyAccountMapper;
import com.krawczak.netflixPayments.service.GetModelAndView;
import com.krawczak.netflixPayments.service.PaymentService;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.mashape.unirest.http.exceptions.UnirestException;
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
import javax.validation.constraints.Digits;

@Controller
public class PaymentsController {

    @Autowired
    GetModelAndView getModelAndView;

    @Autowired
    PaymentService paymentService;

    @Autowired
    MyAccountMapper myAccountMapper;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/pay-payments")
    public ModelAndView getPaymentsController() {
        Map<String, Object> params = getModelAndView("payments");
        params.put("paymentsList", paymentService.getUserPayments(params.get("username").toString()));
        return new ModelAndView("main-site", params);
    }

    @GetMapping("/pay-pay")
    public ModelAndView getPayController(){
        Map<String, Object> params = getModelAndView("payInfo");
        return new ModelAndView("main-site", params);
    }

    @PostMapping("/pay-dot")
    public ResponseEntity<String> postPayByDotPay(@RequestParam(value = "username") String username) throws JsonProcessingException, UnirestException {
        myAccountMapper.parseMyAccount();
        return new ResponseEntity<>(username, HttpStatus.OK);
    }

    @PostMapping("/pay-pay")
    public ResponseEntity<String> postPay(@RequestParam(value = "paymentId") String paymentId, @RequestParam(value = "username") String username, HttpServletResponse response) throws IOException {
        logger.info("start paying for payment id: " + paymentId);
        paymentService.newPayController(Long.valueOf(paymentId), username);
        response.sendRedirect("/pay-pay");
        return new ResponseEntity<>(paymentId, HttpStatus.OK);
    }

    @PostMapping("/pay-unpaid")
    public ResponseEntity<String> postPay(@RequestParam(value = "paymentId") String paymentId, HttpServletResponse response) throws IOException {
        paymentService.changePayToUnpaid(Long.valueOf(paymentId));
        response.sendRedirect("/pay-payments");
        return new ResponseEntity<>(paymentId, HttpStatus.OK);
    }

    private Map<String, Object> getModelAndView(String page) {
        return getModelAndView.getModelAndViewParams(page);
    }

}
