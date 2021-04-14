package com.hansen.petstore.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hansen.petstore.models.Pet;
import com.hansen.petstore.services.PetService;


@Controller
@RequestMapping("/pets")
public class PetController {
	
	private final PetService pService;
	
	public PetController(PetService service) {
		this.pService = service;
	}
	
	@RequestMapping("")
	public String index(Model viewModel) {
		
		viewModel.addAttribute("allPets", this.pService.getAllPets());
		return "index.jsp";
	}
	
	@RequestMapping("/add")
	public String addPet(@ModelAttribute("pet") Pet pet) {
		return "create.jsp";
	}
	
	@RequestMapping(value="/create", method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("pet")Pet pet, BindingResult result) {
		
		if (result.hasErrors()) {
			return "create.jsp";
		} else {
			this.pService.createPet(pet);
			return "redirect:/pets";
		}
	}
	
	
	@RequestMapping(value = "/{id}")
	public String singlePet(@PathVariable("id") Long id, Model viewModel) {
		Pet sPet = this.pService.getPet(id);
		viewModel.addAttribute("sPet",sPet);
		
		return "single.jsp";
	}
	
	@RequestMapping(value = "/{id}/delete")
	public String delete(@PathVariable("id") Long id) {
		this.pService.deletePet(id);
		return "redirect:/pets";
	}
	
	@RequestMapping(value = "/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		Pet pet = this.pService.getPet(id);
		model.addAttribute("pet", pet);
		return "update.jsp";
	}
	
	@RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute("pet")Pet pet, BindingResult result) {
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%result" + result);
		if (result.hasErrors()) {
			return "update.jsp";
		}
			this.pService.updatePet(pet);
			return "redirect:/pets";
	}
	
	
	
	

}