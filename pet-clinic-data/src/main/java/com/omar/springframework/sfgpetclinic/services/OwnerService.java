package com.omar.springframework.sfgpetclinic.services;

import com.omar.springframework.sfgpetclinic.model.Owner;


public interface OwnerService extends CrudService<Owner, Long>{
    Owner findByLastName(String lastName);

}
