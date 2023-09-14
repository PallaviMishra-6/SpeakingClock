package com.TimeConversion.SpeakingClock.Service;

import org.springframework.stereotype.Service;

import com.TimeCoversion.SpeakingClock.Exception.TimeConversionException;

@Service
public class TimeToWordsServiceImpl implements TimeToWordsService {
	private static final String[] NUMS_LESS_THAN_TWENTY = {
	        "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve",
	        "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
	    };

	    private static final String[] TENS = {
	        "", "", "twenty", "thirty", "forty", "fifty"
	    };
	    
	public String convertTimeToWords(String t){
        try {
        	if (t.equalsIgnoreCase("12:00")) {
                return "It's Midday";
            } else if (t.equalsIgnoreCase("00:00")) {
                return "It's Midnight";
            } else {
            String[] parts = t.split(":");
            int hours = Integer.parseInt(parts[0]);
            int minutes = Integer.parseInt(parts[1]);
            if (hours < 0 || hours > 23 || minutes < 0 || minutes > 59) {
                throw new IllegalArgumentException("Invalid time format");
            }
            String timeInWords = convertToWords(hours) + " " + convertToWords(minutes);

            return "It's " + timeInWords;
        }
        }catch (Exception e) {
            throw new TimeConversionException("Error converting time to words", e);
        }
    }

    private String convertToWords(int num) {
    	if (num < 20) {
            return NUMS_LESS_THAN_TWENTY[num];
        } else {
            int tensDigit = num / 10;
            int onesDigit = num % 10;
            return TENS[tensDigit] + (onesDigit > 0 ? (" " + NUMS_LESS_THAN_TWENTY[onesDigit]) : "");
        }
    }

	@Override
	public String handleUserInput(String userInput) throws TimeConversionException {
		if(userInput.contains(":")){
		String[] parts = userInput.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        if (hours < 0 || hours > 23 || minutes < 0 || minutes > 59) {
            throw new IllegalArgumentException("Invalid time format");
        }
        return convertTimeToWords(userInput);
		}
		else {
			throw new IllegalArgumentException("Invalid time format");
		}
	}
}
