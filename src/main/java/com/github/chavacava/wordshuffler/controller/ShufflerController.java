package com.github.chavacava.wordshuffler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.chavacava.wordshuffler.service.Shuffler;

@RestController
public class ShufflerController {

	@Autowired
	private Shuffler shuffler;
	
	@GetMapping(path = "/shuffled")
	public String shuffle(@RequestBody String text) {
		return shuffler.shuffle(text);
	}
}
