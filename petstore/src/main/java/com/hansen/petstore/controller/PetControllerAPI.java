package com.hansen.petstore.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hansen.petstore.models.Pet;
import com.hansen.petstore.services.PetService;

@RestController
@RequestMapping("/api")
public class PetControllerAPI {

	private final PetService pService;
	
	public PetControllerAPI(PetService petService) {
		this.pService = petService;
	}
	
	@RequestMapping("/home")
	public String home() {
		return "hello world";
	}
	
	@RequestMapping("/pets/all")
	public List<Pet>getallPets(){
		return this.pService.getAllPets();
	}
	
	@RequestMapping(value = "/pets/create", method=RequestMethod.POST)
	public Pet createPet(@RequestParam("name") String name,
			@RequestParam("description") String desc,
			@RequestParam("age") Integer age) {
		
		Pet pet = new Pet(name, desc, age);
		return this.pService.createPet(pet);
	}
	
	//localhost:8080/api/1/info
	@RequestMapping("/pets/{id}")
	public Pet show(@PathVariable("id") Long id) {
		return this.pService.getPet(id);
	}
	
	//localhost:8000/api/pets/5/update
	@RequestMapping(value = "/pets/{id}/update", method = RequestMethod.PUT)
	public Pet update(@PathVariable("id") Long id,
			@RequestParam("name") String name,
			@RequestParam("description") String description,
			@RequestParam("age") Integer age) {
		return this.pService.updatePet(id, name, description, age);		
	}
	
	//localhost:8000/api/pets/5/delete
	@RequestMapping(value = "/pets/{id}/delete", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		this.pService.deletePet(id);
	}
	
	
	
}
