package com.krawczak.netflixPayments.controller;

import com.krawczak.netflixPayments.service.GetModelAndView;
import com.krawczak.netflixPayments.service.PaymentService;
import java.time.LocalDate;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PaymentsController {

  @Autowired
  GetModelAndView getModelAndView;

  @Autowired
  PaymentService paymentService;

  @GetMapping("/pay-payments")
  public ModelAndView getPaymentsController(){
    LocalDate dateNow = LocalDate.now();
//    PaymentDto lastPayment = paymentService.getLastPayment(dateNow);
    return new ModelAndView("main-site", getModelAndView("payments"));
  }

  private Map<String, Object> getModelAndView(String page){
    return getModelAndView.getModelAndViewParams(page);
  }

}
