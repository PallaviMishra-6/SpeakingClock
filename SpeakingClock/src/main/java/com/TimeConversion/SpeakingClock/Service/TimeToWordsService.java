package com.TimeConversion.SpeakingClock.Service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.TimeCoversion.SpeakingClock.Exception.TimeConversionException;

public interface TimeToWordsService {
	String convertTimeToWords(String time) throws TimeConversionException;
    String handleUserInput(String userInput) throws TimeConversionException;
}
