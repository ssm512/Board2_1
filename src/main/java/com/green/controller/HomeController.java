package com.green.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String home () {
		return "home";
	} // home() end
	
	@RequestMapping("/test")
	public String test() {
		return "<h2>Test입니다</h2>";
	}// test() end
}
