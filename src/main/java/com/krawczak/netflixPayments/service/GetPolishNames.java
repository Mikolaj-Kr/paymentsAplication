package com.krawczak.netflixPayments.service;

import org.springframework.stereotype.Service;

@Service
public class
GetPolishNames {

    public String getMonth(int numberOfMonth) {

        switch (numberOfMonth) {
            case 1:
                return "Styczeń";
            case 2:
                return "Luty";
            case 3:
                return "Marzec";
            case 4:
                return "Kwieceń";
            case 5:
                return "Maj";
            case 6:
                return "Czerwiec";
            case 7:
                return "Lipiec";
            case 8:
                return "Sierpień";
            case 9:
                return "Wrzesień";
            case 10:
                return "Październik";
            case 11:
                return "Listopad";
            case 12:
                return "Grudzień";
        }
        return "nierozpoznano";
    }
}
