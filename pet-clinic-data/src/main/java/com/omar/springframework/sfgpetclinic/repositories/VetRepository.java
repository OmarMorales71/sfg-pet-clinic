package com.omar.springframework.sfgpetclinic.repositories;

import com.omar.springframework.sfgpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
