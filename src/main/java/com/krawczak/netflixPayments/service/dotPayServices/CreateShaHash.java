package com.krawczak.netflixPayments.service.dotPayServices;

import com.google.common.hash.Hashing;
import com.krawczak.netflixPayments.domain.dotPayApi.paymentInformation.Payer;
import com.krawczak.netflixPayments.domain.entity.Payment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

@Service
public class CreateShaHash {

    public String  creatChk(String pid) throws NoSuchAlgorithmException {
        String chkString = "wVtmvdCbqtpsFrpiOkKrjyUuHTXcsOSf" + pid;

        MessageDigest hash = MessageDigest.getInstance("SHA-256");
        byte[] digest = hash.digest(chkString.getBytes(StandardCharsets.UTF_8));

        return DatatypeConverter.printHexBinary(digest).toLowerCase();
    }
}
