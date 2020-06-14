package com.krawczak.netflixPayments.service.dotPayServices;

import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class CreateShaHash {

    public String creatChk(String pid) throws NoSuchAlgorithmException {
        String chkString = "wVtmvdCbqtpsFrpiOkKrjyUuHTXcsOSf" + pid;

        MessageDigest hash = MessageDigest.getInstance("SHA-256");
        byte[] digest = hash.digest(chkString.getBytes(StandardCharsets.UTF_8));

        return DatatypeConverter.printHexBinary(digest).toLowerCase();
    }
}
