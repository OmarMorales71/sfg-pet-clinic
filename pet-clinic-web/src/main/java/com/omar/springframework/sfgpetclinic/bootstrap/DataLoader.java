package com.omar.springframework.sfgpetclinic.bootstrap;

import com.omar.springframework.sfgpetclinic.model.*;
import com.omar.springframework.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

//Clase para inicializar data
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if(count==0)
            loadData();
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);


        Owner owner1 = new Owner();

        owner1.setFirstName("Omar");
        owner1.setLastName("Morales");
        owner1.setAddress("Calle del Picadero ll 15");
        owner1.setCity("Jaen");
        owner1.setTelephone("3412546987");

        Pet dobbyPet = new Pet();
        dobbyPet.setPetType(savedDogPetType);
        dobbyPet.setOwner(owner1);
        dobbyPet.setBirthDate(LocalDate.now());
        dobbyPet.setName("Omar");
        owner1.getPets().add(dobbyPet);
        ownerService.save(owner1);


        Owner owner2 = new Owner();

        owner2.setFirstName("Valeria Chidisima");
        owner2.setLastName("Vargas");
        owner2.setAddress("Calle chida 43");
        owner2.setCity("Guzman");
        owner2.setTelephone("3414582001");

        Pet stellaCat = new Pet();
        stellaCat.setName("Stella");
        stellaCat.setBirthDate(LocalDate.now());
        stellaCat.setPetType(savedCatPetType);
        stellaCat.setOwner(owner2);
        owner2.getPets().add(stellaCat);
        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setPet(stellaCat);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy Kitty");

        visitService.save(catVisit);
        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();

        vet1.setFirstName("Giorgia");
        vet1.setLastName("Cordiglia");
        vet1.setId(5L);
        vet1.getSpecialities().add(savedRadiology);
        vetService.save(vet1);
        Vet vet2 = new Vet();

        vet2.setFirstName("Deborah");
        vet2.setLastName("Nonnis");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded Vets... 2");
    }
}
