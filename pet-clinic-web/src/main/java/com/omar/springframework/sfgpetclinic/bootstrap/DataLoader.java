package com.omar.springframework.sfgpetclinic.bootstrap;

import com.omar.springframework.sfgpetclinic.model.Owner;
import com.omar.springframework.sfgpetclinic.model.Vet;
import com.omar.springframework.sfgpetclinic.services.OwnerService;
import com.omar.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//Clase para inicializar data
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();

        owner1.setFirstName("Omar");
        owner1.setLastName("Morales");
        owner1.setId(1L);

        ownerService.save(owner1);

        Owner owner2 = new Owner();

        owner2.setFirstName("Valeria Chidisima");
        owner2.setLastName("Vargas");
        owner2.setId(2L);

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();

        vet1.setFirstName("Giorgia");
        vet1.setLastName("Cordiglia");
        vet1.setId(1L);

        vetService.save(vet1);

        Vet vet2 = new Vet();

        vet2.setFirstName("Deborah");
        vet2.setLastName("Nonnis");
        vet2.setId(2L);

        vetService.save(vet2);

        System.out.println("Loaded Vets... 2");
    }
}
