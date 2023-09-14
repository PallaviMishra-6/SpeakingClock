package com.TimeConversion.SpeakingClock.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TimeConversion.SpeakingClock.Service.TimeToWordsService;
import com.TimeCoversion.SpeakingClock.Exception.TimeConversionException;

@RestController
@RequestMapping("/user-input")
public class UserInputController {
	 @Autowired
	 private TimeToWordsService timetowordservice;

	    @GetMapping("/{input}")
	    public String handleUserInput(@PathVariable String input) {
	        try {
	            return timetowordservice.handleUserInput(input);
	        } catch (TimeConversionException e) {
	            return "Error: " + e.getMessage();
	        }
	    }

}
