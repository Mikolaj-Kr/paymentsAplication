package com.krawczak.netflixPayments.email;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import com.krawczak.netflixPayments.service.GetPolishNames;
import com.krawczak.netflixPayments.service.PaymentService;
import com.krawczak.netflixPayments.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    private JavaMailSender javaMailSender;

    @Autowired
    PaymentService paymentService;

    @Autowired
    GetPolishNames getPolishNames;

    @Autowired
    UserService userService;

    public MailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(String to, String content, String subject) {
        MimeMessage mail = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo(to);
            helper.setFrom(" Płatności MK <platnoscinetflix@gmail.com>");
            helper.setSubject(subject);
            helper.setText(content, true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        javaMailSender.send(mail);
    }

    public void remandingMail(String username){
        String content = userService.findUserByUsername(username).getName() + " netflixa masz opłaconego do: " + paymentService.getLastPaidUserPayment(username).getMonthOfPayment() + "(włącznie). Po szczegóły zapraszam na https://paymentmk.herokuapp.com/pay-payments";
        String subject = "Netflix info";
        sendEmail(username, content, subject);
    }

}