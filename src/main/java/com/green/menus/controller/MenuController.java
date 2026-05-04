package com.green.menus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.menus.dto.MenuDTO;
import com.green.menus.mapper.MenuMapper;

@Controller
@RequestMapping("/Menus")
public class MenuController {
	
	@Autowired
	private	MenuMapper	menuMapper;
	
	// /Menus/List
	@RequestMapping("/List")
	public String list( Model model ) {
		// 조회한 결과를 ArrayList로 돌려준다
		List<MenuDTO> menuList	=	menuMapper.getMenuList();
		model.addAttribute("menuList", menuList);
		return "menus/list";
	}
}
