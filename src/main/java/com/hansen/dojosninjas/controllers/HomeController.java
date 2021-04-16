package com.hansen.dojosninjas.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.hansen.dojosninjas.models.Dojo;
import com.hansen.dojosninjas.models.Ninja;
import com.hansen.dojosninjas.services.DojoNinjaService;

@Controller
public class HomeController {
	
	private DojoNinjaService dnService;

	public HomeController(DojoNinjaService dnService) {
		super();
		this.dnService = dnService;
	}
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("allDojos", dnService.getAllDojos());
		return "index.jsp";
	}
	
	@GetMapping("/dojo/new")
	public String newDojo(@ModelAttribute("dojo")Dojo dojo) {
		return "newDojoForm.jsp";
	}
	
	@PostMapping("/dojo/create")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, 
			BindingResult result, 
			Model model) {
		if (result.hasErrors()) {
			System.out.println(result.getAllErrors());
		} else {
			this.dnService.createDojo(dojo);
		}
		return "redirect:/";
	}
	
	@GetMapping("/ninja/new")
	public String createNinja(@ModelAttribute("ninja")Ninja ninja, Model model) {
		model.addAttribute("allDojos", dnService.getAllDojos());
		return "newNinjaForm.jsp";
	}
	
	@PostMapping("/ninja/create")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, 
			BindingResult result, 
			Model model) {
		if (result.hasErrors()) {
			System.out.println(result.getAllErrors());
		} else {
			this.dnService.createNinja(ninja);
		}
		return "redirect:/";
	}
	
	@GetMapping("/dojo/{id}")
	public String showDojo(@PathVariable("id")Long id, Model model) {
		Dojo dojo = this.dnService.getDojo(id);
		model.addAttribute("dojo", dojo);
		return "showDojo.jsp";
	}
	
	
	

}
