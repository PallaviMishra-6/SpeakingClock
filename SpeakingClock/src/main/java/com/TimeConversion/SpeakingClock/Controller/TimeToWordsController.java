package com.TimeConversion.SpeakingClock.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.TimeConversion.SpeakingClock.Service.TimeToWordsService;
import com.TimeCoversion.SpeakingClock.Exception.TimeConversionException;

@RestController
@RequestMapping("/time-conversion")
public class TimeToWordsController {
	    @Autowired
	    TimeToWordsService timetowordservice;

	    @GetMapping("/convert/{time}")
	    @ResponseBody
	    public String convertTimeToWords(@PathVariable String time) {
	        try {
	            return timetowordservice.convertTimeToWords(time);
	            
	        }
	        catch (TimeConversionException e) {
	            return "Error: " + e.getMessage();
	        }
	    }
}
