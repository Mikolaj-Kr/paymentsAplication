package com.krawczak.netflixPayments.controller.adminContollers;

import com.krawczak.netflixPayments.service.AmountOfPayService;
import com.krawczak.netflixPayments.service.GetModelAndView;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Controller
public class PaymentsSettingsController {

    private final GetModelAndView getModelAndView;

    private final AmountOfPayService amountOfPayService;

    @Autowired
    public PaymentsSettingsController(GetModelAndView getModelAndView, AmountOfPayService amountOfPayService) {
        this.getModelAndView = getModelAndView;
        this.amountOfPayService = amountOfPayService;
    }

    @GetMapping("/pay-payments-settings")
    public ModelAndView getPaymentSettings() {
        Map<String, Object> params = getModelAndView.getModelAndViewParams("paymentsSettings");
        params.put("amount", amountOfPayService.getAmountOfPay());
        return new ModelAndView("main-site", params);
    }

    @PostMapping("/pay-change-amount")
    public ResponseEntity<String> postChangeAmount(@RequestParam(value = "amount") String amount, HttpServletResponse response) throws IOException {
        if (NumberUtils.isDigits(amount)) {
            amountOfPayService.setAmountOfPay(Long.valueOf(amount));
        }
        response.sendRedirect("/pay-payments-settings");
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }
}
