package com.omar.springframework.sfgpetclinic.bootstrap;

import com.omar.springframework.sfgpetclinic.model.Owner;
import com.omar.springframework.sfgpetclinic.model.Pet;
import com.omar.springframework.sfgpetclinic.model.PetType;
import com.omar.springframework.sfgpetclinic.model.Vet;
import com.omar.springframework.sfgpetclinic.services.OwnerService;
import com.omar.springframework.sfgpetclinic.services.PetTypeService;
import com.omar.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

//Clase para inicializar data
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService=petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);


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

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();

        vet1.setFirstName("Giorgia");
        vet1.setLastName("Cordiglia");
        vet1.setId(5L);

        vetService.save(vet1);

        Vet vet2 = new Vet();

        vet2.setFirstName("Deborah");
        vet2.setLastName("Nonnis");


        vetService.save(vet2);

        System.out.println("Loaded Vets... 2");
    }
}
