package com.krawczak.netflixPayments.service.dotPayServices;

import com.google.common.hash.Hashing;
import com.krawczak.netflixPayments.domain.dotPayApi.paymentInformation.Payer;
import com.krawczak.netflixPayments.domain.entity.Payment;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

@Service
public class CreateShaHash {

    public String  creatChk(String amount, String description, String control, Payer payer) throws NoSuchAlgorithmException {
        String chkString = "wVtmvdCbqtpsFrpiOkKrjyUuHTXcsOSf" + "pl" + "776768" + amount + "PLN" + description + control + "url" + "url" + payer.getFirstName() + payer.getLastName() + payer.getEmail() + "" + 1;

        String hashString = Hashing.sha256().hashString(chkString, StandardCharsets.UTF_8).toString();

        return hashString;
    }
}
