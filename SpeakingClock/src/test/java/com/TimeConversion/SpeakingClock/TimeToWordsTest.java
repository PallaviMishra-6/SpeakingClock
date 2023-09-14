package com.TimeConversion.SpeakingClock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

import com.TimeConversion.SpeakingClock.Controller.TimeToWordsController;
import com.TimeConversion.SpeakingClock.Service.TimeToWordsService;
import com.TimeConversion.SpeakingClock.Service.TimeToWordsServiceImpl;

@SpringBootTest
public class TimeToWordsTest {
	private TimeToWordsService converter;
	
    @BeforeEach
    public void setUp() {
        converter = new TimeToWordsServiceImpl();
    }
    
    @Test
    public void testValidTimeConversion() {
        String inputTime = "08:34";
        String expected = "It's eight thirty four";
        String actual = converter.convertTimeToWords(inputTime);
        assertEquals(expected, actual);
    }

	
	  @Test public void testInvalidTimeFormat() { 
	  String inputTime = "25:70";
	  String expected = "Invalid time format";
	  String actual =converter.handleUserInput(inputTime);
	  assertEquals(expected, actual); 
	  }
	  
	  @Test public void testInvalidTimeFormat2() { 
		  String inputTime = "26";
		  String expected = "Invalid time format";
		  String actual =converter.handleUserInput(inputTime);
		  assertEquals(expected, actual); 
		  }
	 

}
