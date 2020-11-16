package com.github.chavacava.wordshuffler.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;


@Service
public class Shuffler {
	public String shuffle(String str) {
		var result = "";
		var words = str.split(" ");
		for (var i=0; i<words.length;i++) {
			if (i>0) {
				result += " ";
			}
			result += shuffleWord(words[i]);
		}
		
		return result;
	}
	
	private String shuffleWord(String word) {
		if (word.length() <= 3)
			return word;
		
		var middleChars = word.substring(1, word.length()-1);
		List<Character> asList = middleChars.chars().mapToObj(c -> {
			return new Character((char) c);
		})
        .collect(Collectors.toList());
		Collections.shuffle(asList);
		
		
		String result = word.charAt(0)+"";
		for (var i=0; i<asList.size();i++) {
			result += asList.get(i).toString();
		}
		result += word.charAt(word.length()-1);
		
		return result;
	}
}
