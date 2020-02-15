package com.krawczak.netflixPayments.service;

import org.springframework.stereotype.Service;

@Service
public class GetMonth {

  public String getMonth(int numberOfMonth){
    String month = "nieznany";

    switch (numberOfMonth){
      case 1: month = "Styczeń";
        break;
      case 2: month = "Luty";
      break;
      case 3: month = "Marzec";
      break;
      case 4: month = "Kwieceń";
      break;
      case 5: month = "Maj";
      break;
      case 6: month = "Czerwiec";
      break;
      case 7: month = "Lipiec";
      break;
      case 8: month = "Sierpień";
      break;
      case 9: month = "Wrzesień";
      break;
      case 10: month = "Październik";
      break;
      case 11: month = "Listopad";
      break;
      case 12: month = "Grudzień";
      break;
    }
    return month;
  }

}
