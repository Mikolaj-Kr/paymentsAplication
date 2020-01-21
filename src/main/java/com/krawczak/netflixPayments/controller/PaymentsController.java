package com.krawczak.netflixPayments.controller;

import com.krawczak.netflixPayments.domain.dto.PaymentDto;
import com.krawczak.netflixPayments.service.GetModelAndView;
import com.krawczak.netflixPayments.service.PaymentService;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Year;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    return (ModelAndView) getModelAndView("payments").getModel().put("lastPayment", "ostatnia platnosc");
  }

  private ModelAndView getModelAndView(String page){
    return getModelAndView.getModelAndView(page);
  }

}
