package com.omar.springframework.sfgpetclinic.repositories;

import com.omar.springframework.sfgpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
