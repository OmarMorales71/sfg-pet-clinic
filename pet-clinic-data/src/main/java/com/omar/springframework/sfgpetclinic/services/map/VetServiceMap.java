package com.omar.springframework.sfgpetclinic.services.map;

import com.omar.springframework.sfgpetclinic.model.Speciality;
import com.omar.springframework.sfgpetclinic.model.Vet;
import com.omar.springframework.sfgpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
    private final SpecialityMap specialityMap;

    public VetServiceMap(SpecialityMap specialityMap) {
        this.specialityMap = specialityMap;
    }


    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {

        if (object != null) {

            if(object.getSpecialities().size()>0){
                object.getSpecialities().forEach(speciality -> {
                   if(speciality.getId()==null){
                       Speciality savedSpeciality = specialityMap.save(speciality);
                       speciality.setId(savedSpeciality.getId());
                   }
                });
            }
            return super.save(object);

        } else {
            return null;
        }
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
