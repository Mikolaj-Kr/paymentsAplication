package com.krawczak.netflixPayments.service.dotPayServices;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.krawczak.netflixPayments.domain.dotPayApi.paymentInformation.Payer;
import org.springframework.stereotype.Service;


@Service
public class CreateJson {

    public ObjectNode jsonForCreatingPaymentLink(String amount, String description, String control, Payer payer){

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode json = mapper.createObjectNode();
        ObjectNode payerJson = mapper.createObjectNode();

        payerJson.put("first_name", payer.getFirstName());
        payerJson.put("last_name", payer.getLastName());
        payerJson.put("email", payer.getEmail());

        json.put("amount", amount);
        json.put("currency", "PLN");
        json.put("description", description);
        json.put("control", control);
        json.put("language", "pl");
        json.put("ignore_last_payment_channel", 1);
        json.put("redirection_type", 0);
        json.put("url", "url");
        json.put("urlc", "url");
        json.put("payer", payerJson);
        return json;
    }

}
