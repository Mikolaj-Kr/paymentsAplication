package com.krawczak.netflixPayments.controller;

import com.krawczak.netflixPayments.domain.dto.PaymentDto;
import com.krawczak.netflixPayments.domain.entity.Payment;
import com.krawczak.netflixPayments.service.GetModelAndView;
import com.krawczak.netflixPayments.service.PaymentService;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import org.apache.catalina.LifecycleState;
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
    Map<String, Object> params  = getModelAndView("payments");
    params.put("paymentsList", paymentService.getUserPayments(params.get("username").toString()));

    return new ModelAndView("main-site", params);
  }

  private Map<String, Object> getModelAndView(String page){
    return getModelAndView.getModelAndViewParams(page);
  }

}
