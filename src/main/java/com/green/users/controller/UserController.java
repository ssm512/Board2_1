package com.green.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.green.users.dto.UserDTO;
import com.green.users.mapper.UserMapper;

import jakarta.servlet.http.HttpSession;

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
	
	// /Users/DupCheckWindow?first=true
	@GetMapping("/DupCheckWindow")
	public ModelAndView dupCheckWindow( boolean first, HttpSession session) {
		
		ModelAndView mv = new ModelAndView();
		session.setAttribute("first", true);
		mv.setViewName("users/idcheck");
		return mv;
	}
	
	// 중복확인
	// /Users/DupCheck?userid=aaa
	@RequestMapping("/DupCheck")
	public ModelAndView dupCheck (UserDTO userDTO, HttpSession session) {
		session.setAttribute("first", "");
		// 한번 맺어진 session의 session값은 계속 유지가 됨,
		// 그래서 close해주거나, 값을 수정해줘야 됨
		UserDTO	user	=	userMapper.getUser(userDTO);
		ModelAndView mv = new ModelAndView();
		return mv;
	}
	
	
	
	// 아이디 중복 확인 - jsp를 return하는게 아닌결과 문자열을 리턴
	// <b class="green">사용 가능한 아이디 입니다.</b>
	// <b class="red">사용 불가능한 아이디 입니다.</b>
	// /Users/IdDupCheck2?userid=sky
	@GetMapping("/IdDupCheck2")
	@ResponseBody
	public UserDTO idDupCheck2 (UserDTO userDTO) {
		UserDTO user	=	userMapper.getIdDupCheck(userDTO);
		// 넘어온 userid를 들고가서 조회하는 거임
		if (user == null)
			user = new UserDTO();
		return user;
	}
}
