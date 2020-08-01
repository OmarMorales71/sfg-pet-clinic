package com.omar.springframework.sfgpetclinic.repositories;

import com.omar.springframework.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet,Long> {

}
