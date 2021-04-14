package com.hansen.petstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hansen.petstore.models.Pet;
import com.hansen.petstore.repository.PetRepository;



// In the SERVICE File we are creating methods for our controller to use when needed.
//These methods are meant to communicate with the Repository and also to carry any logic we want
@Service
public class PetService {
	private final PetRepository pRepo;
	
	//this is a constructor
	public PetService(PetRepository petRepository) {
		this.pRepo = petRepository;
	}
	
	//this gets all pets
	public List<Pet> getAllPets(){
		return this.pRepo.findAll();
	}
	
	//create a pet
	public Pet createPet(Pet p) {
		return this.pRepo.save(p);
	}
	
	//get one pet
	public Pet getPet(Long id) {
		Optional<Pet> optionalPet = this.pRepo.findById(id);
		if (optionalPet.isPresent()) {
			return optionalPet.get();
		}
		return null;
	}
	
	//update
	public Pet updatePet(Long id, String name, String description, Integer age) {
		Pet toUpdate = this.pRepo.findById(id).orElse(null);
		if (toUpdate == null) {
			return null;
		}else {
			toUpdate.setAge(age);
			toUpdate.setDescription(description);
			toUpdate.setName(name);
			return this.pRepo.save(toUpdate);
		}
	}
	
	//overloading updatePet that just accepts pet
	public Pet updatePet(Pet pet) {
		return this.pRepo.save(pet);
	}
	
	public void deletePet(Long id) {
		this.pRepo.deleteById(id);
	}
	
	

}
