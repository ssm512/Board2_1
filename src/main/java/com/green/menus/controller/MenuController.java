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
	
	// 메뉴 신규 등록 1
	// /Menus/WriteForm
	@RequestMapping("/WriteForm")
	public String writeForm () {
		return "menus/write";
	}
	
	// /Menus/Write
	@RequestMapping("/Write")
	public String write (MenuDTO menuDTO, Model model) {
		System.out.println(menuDTO);
		
		//db에 저장
		menuMapper.insertMenu(menuDTO);
		
		return "redirect:/Menus/List";
	}
	
	// 메뉴 신규 등록 2
	// /Menus/WriteForm2
	@RequestMapping("/WriteForm2")
	public String writeForm2 () {
		return "menus/write2";
	}
	
	// /Menus/Write2
	@RequestMapping("/Write2")
	public String write2 (MenuDTO menuDTO) {
		
		menuMapper.insertMenu2(menuDTO);
		
		return "redirect:/Menus/List";
	}
	
	// /Menus/Delete
	@RequestMapping("/Delete")
	public String delete (MenuDTO menuDTO) {
		
		menuMapper.deleteMenu(menuDTO);
		
		return "redirect:/Menus/List";
	}
	
	// /Menus/UpdateForm
	@RequestMapping("/UpdateForm")
	public String updateForm (MenuDTO menuDTO, Model model) {
		// 수정할 자료를  db에서 검색 : 수정할 정보가 담긴 조회된 menu
		MenuDTO menu = menuMapper.getMenu(menuDTO);
		model.addAttribute("menu", menu);
		return "menus/update";
	}
	
	// /Menus/Update
	@RequestMapping("/Update")
	public String update (MenuDTO menuDTO) {
		menuMapper.updateMenu(menuDTO);
		return "redirect:/Menus/List";
	}
}
