package com.github.chavacava.wordshuffler.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class ShufflerTest {

	@Test
	public void TestShuffle() {
		var testCases = Arrays.asList(
				"a",
				"as",
				"two",
				"longuer",
				"a couple",
				"multiple long",
				"a longuer phrase mixing short and long words",
				"some special characters like: , ; ? may produce weird results?"
		);
		var shuffler = new Shuffler();
		
		testCases.stream().forEach(tc -> {
			var got = shuffler.shuffle(tc);
			System.out.println(tc+" / "+ got);
			
			// Check number of words in the string
			var words = tc.split(" ");
			var gotWords = got.split(" ");
			var wordCount = words.length;
			var gotWordCount = gotWords.length;
			assertEquals(wordCount, gotWordCount,"expected the same word count");
			
			// Check each word
			for (var i=0; i<wordCount; i++) {
				var word = words[i];
				
				var gotWord = gotWords[i];
				
				
				// Same length
				assertEquals(word.length(), gotWord.length(),"words expected to have the same length");
				
				if (word.length() <= 3) {
					assertEquals(word,gotWord,"words expected to be equal");
					continue;
				}
				
				// Same extremes
				assertEquals(word.charAt(0), gotWord.charAt(0),"words expected to have the same first charecter");
				var lastPos = word.length()-1;
				assertEquals(word.charAt(lastPos), gotWord.charAt(lastPos),"words expected to have the same last charecter");
				
				// Check middle characters
				// TODO
			}			
		}); 
		
	}
}
