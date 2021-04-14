package com.hansen.petstore.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hansen.petstore.models.Pet;

@Repository
public interface PetRepository extends CrudRepository<Pet, Long> {
	//other custom methods or modifications of the crud respository methods
	List<Pet> findAll();
}
