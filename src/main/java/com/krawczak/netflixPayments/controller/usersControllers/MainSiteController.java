package com.krawczak.netflixPayments.controller.usersControllers;

import com.krawczak.netflixPayments.service.GetModelAndView;
import com.krawczak.netflixPayments.service.UserService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainSiteController {

  @Autowired
  UserService userService;

  @Autowired
  GetModelAndView getModelAndView;

  @RequestMapping("/pay-main")
  public ModelAndView getMain() {
    return new ModelAndView("main-site", getModelAndView("main"));
  }

  private Map<String, Object> getModelAndView(String page) {
    return getModelAndView.getModelAndViewParams(page);
  }
}
