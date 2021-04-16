package com.hansen.dojosninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hansen.dojosninjas.models.Dojo;
import com.hansen.dojosninjas.models.Ninja;
import com.hansen.dojosninjas.repositories.DojoRepo;
import com.hansen.dojosninjas.repositories.NinjaRepo;

@Service
public class DojoNinjaService {

	private DojoRepo dojoRepo;
	private NinjaRepo ninjaRepo;
	
	public DojoNinjaService(DojoRepo dojoRepo, NinjaRepo ninjaRepo) {
		super();
		this.dojoRepo = dojoRepo;
		this.ninjaRepo = ninjaRepo;
	}
	
	public Dojo createDojo(Dojo newDojo) {
		return dojoRepo.save(newDojo);
	}
	
	public Ninja createNinja(Ninja newNinja) {
		return ninjaRepo.save(newNinja);
	}
	
	public List<Dojo> getAllDojos(){
		return dojoRepo.findAll();
	}
	
	public List<Ninja> getAllNinjas(){
		return ninjaRepo.findAll();
	}
	
	public Dojo getDojo(Long id) {
		Optional<Dojo> optionalDojo = this.dojoRepo.findById(id);
		if (optionalDojo.isPresent()) {
			return optionalDojo.get();
		}
		return null;
	}
	
}
