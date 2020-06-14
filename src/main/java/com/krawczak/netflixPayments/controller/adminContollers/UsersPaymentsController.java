package com.krawczak.netflixPayments.controller.adminContollers;

import com.krawczak.netflixPayments.email.MailService;
import com.krawczak.netflixPayments.service.GetModelAndView;
import com.krawczak.netflixPayments.service.PaymentService;
import com.krawczak.netflixPayments.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Controller
public class UsersPaymentsController {

    private final GetModelAndView getModelAndView;

    private final PaymentService paymentService;

    private final UserService userService;

    private final MailService mailService;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public UsersPaymentsController(GetModelAndView getModelAndView, PaymentService paymentService, UserService userService, MailService mailService) {
        this.getModelAndView = getModelAndView;
        this.paymentService = paymentService;
        this.userService = userService;
        this.mailService = mailService;
    }

    @RequestMapping("/pay-users-payments")
    public ModelAndView getUsersPayments(HttpServletRequest request) {
        Map<String, Object> params = getModelAndView.getModelAndViewParams("userPayments");
        String username = request.getParameter("username");
        params.put("paymentList", paymentService.getUserPayments(username));
        params.put("currentUser", userService.findUserByUsername(username));
        return new ModelAndView("main-site", params);
    }

    @PostMapping("/pay-user-add-payment")
    public ResponseEntity<String> postChangePaymentToPaid(@RequestParam(value = "paymentId") String paymentId, @RequestParam(value = "username") String username, HttpServletResponse response) throws IOException {
        paymentService.changePayToPaid(Long.valueOf(paymentId));
        logger.info("Payment with id: " + paymentId + "change to paid");
        response.sendRedirect("/pay-users-payments?username=" + username);
        return new ResponseEntity<>(paymentId, HttpStatus.OK);
    }

    @PostMapping("/pay-user-delete-payment")
    public ResponseEntity<String> postChangePaymentToUnpaid(@RequestParam(value = "paymentId") String paymentId, @RequestParam(value = "username") String username, HttpServletResponse response) throws IOException {
        paymentService.changePayToUnpaid(Long.valueOf(paymentId));
        logger.info("Payment with id: " + paymentId + "changed to unpaid");
        response.sendRedirect("/pay-users-payments?username=" + username);
        return new ResponseEntity<>(paymentId, HttpStatus.OK);
    }

    @PostMapping("/pay-user-add-new-payment")
    public ResponseEntity<String> postAddPaymentForUser(@RequestParam(value = "username") String username, HttpServletResponse response) throws IOException {
        paymentService.addNewPay(username);
        logger.info("Added new payment for user: " + username);
        response.sendRedirect("pay-users-payments?username=" + username);
        return new ResponseEntity<>(username, HttpStatus.OK);
    }

    @PostMapping("/pay-user-finish-payment")
    public ResponseEntity<String> postDeletePayment(@RequestParam(value = "paymentId") String paymentId, @RequestParam(value = "username") String username, HttpServletResponse response) throws IOException {
        paymentService.finishPayment(Long.valueOf(paymentId));
        logger.info("Payment: " + paymentId + "deleted");
        response.sendRedirect("pay-users-payments?username=" + username);
        return new ResponseEntity<>(username, HttpStatus.OK);
    }

    @PostMapping("/pay-user-remind-payment")
    public ResponseEntity<String> postRemindPayment(@RequestParam(value = "username") String username, HttpServletResponse response) throws IOException {
        mailService.remandingMail(username);
        logger.info("Remanding mail send to " + username);
        response.sendRedirect("/pay-users-payments?username=" + username);
        return new ResponseEntity<>(username, HttpStatus.OK);
    }
}
