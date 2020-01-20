package com.krawczak.netflixPayments.controller;

import com.krawczak.netflixPayments.service.GetModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PaymentsController {

  @Autowired
  GetModelAndView getModelAndView;

  @RequestMapping
  public ModelAndView getPaymentsController(){
    return getModelAndView("payments") ;
  }

  private ModelAndView getModelAndView(String page){
    return getModelAndView.getModelAndView(page);
  }

}
