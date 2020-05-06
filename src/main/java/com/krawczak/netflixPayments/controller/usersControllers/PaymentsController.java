package com.krawczak.netflixPayments.controller.usersControllers;

import org.apache.commons.lang3.math.NumberUtils;
import com.krawczak.netflixPayments.service.GetModelAndView;
import com.krawczak.netflixPayments.service.PaymentService;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import com.krawczak.netflixPayments.service.dotPayServices.DotPayService;
import com.mashape.unirest.http.exceptions.UnirestException;
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

@Controller
public class PaymentsController {

    private final GetModelAndView getModelAndView;

    private final PaymentService paymentService;

    private final DotPayService dotPayService;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public PaymentsController(GetModelAndView getModelAndView, PaymentService paymentService, DotPayService dotPayService) {
        this.getModelAndView = getModelAndView;
        this.paymentService = paymentService;
        this.dotPayService = dotPayService;
    }

    @GetMapping("/pay-payments")
    public ModelAndView getPaymentsController() {
        Map<String, Object> params = getModelAndView("payments");
        params.put("paymentsList", paymentService.getUserPayments(params.get("username").toString()));
        return new ModelAndView("main-site", params);
    }

    @GetMapping("/pay-pay")
    public ModelAndView getPayController(HttpServletRequest request){
        String paymentId = request.getParameter("paymentId");
        Map<String, Object> params = getModelAndView("payInfo");
        if(NumberUtils.isDigits(paymentId))
        params.put("paymentId", paymentId);
        return new ModelAndView("main-site", params);
    }

    @PostMapping("/pay-after-pay")
    public ResponseEntity<String> postAfterPay(@RequestParam(value = "status") String status, HttpServletResponse response) throws IOException {
        response.sendRedirect("/pay-payments");
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

    @PostMapping("/pay-dot")
    public ResponseEntity<String> postPayByDotPay(@RequestParam(value = "username") String username, @RequestParam(value = "paymentId") String paymentId, HttpServletResponse response) throws IOException, UnirestException, NoSuchAlgorithmException {
        response.sendRedirect(dotPayService.createPaymentLink(username, paymentId));
        logger.info( username + "start to pay by DotPay for payment: " + paymentId);
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }


    @PostMapping("/pay-urlc")
    public ResponseEntity<String> postUrlc(){

        return new ResponseEntity<>("OK", HttpStatus.OK);
    }


    @PostMapping("/pay-pay")
    public ResponseEntity<String> postPay(@RequestParam(value = "paymentId") String paymentId, @RequestParam(value = "username") String username, HttpServletResponse response) throws IOException {
        logger.info("start paying for payment id: " + paymentId);
        paymentService.newPayController(Long.valueOf(paymentId), username);
        response.sendRedirect("/pay-pay?paymentId=" + paymentId);
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
