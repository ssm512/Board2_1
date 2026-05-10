package com.green.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.green.users.dto.UserDTO;
import com.green.users.mapper.UserMapper;

@Controller
@RequestMapping("/Users")
public class UserController {
	
	@Autowired
	private	UserMapper userMapper;
	
	// /Users/List"
	@RequestMapping("/List")
	public ModelAndView list () {
		
		List<UserDTO> userList = userMapper.getUserList();
		ModelAndView mv	= new ModelAndView();
		mv.setViewName("/users/list");
		mv.addObject("userList", userList);
		return mv;
	}
	
	// /Users/WriteForm
	@RequestMapping("/WriteForm")
	public ModelAndView wirteForm () {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("users/write");
		return mv;
	}
	
	// /Users/Write
	@RequestMapping("/Write")
	public ModelAndView write (UserDTO userDTO) {
		userMapper.insertUser(userDTO);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/Users/List");
		return mv;
	}
}
