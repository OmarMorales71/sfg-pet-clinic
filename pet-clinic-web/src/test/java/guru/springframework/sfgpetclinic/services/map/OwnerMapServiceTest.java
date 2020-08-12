package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;
    final Long ownerId = 1L;
    final String ownerLastName = "Morales";

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        ownerMapService.save(Owner.builder().id(ownerId).lastName(ownerLastName).build());
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerMapService.findAll();
        assertEquals(1, owners.size());
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(ownerId);

        assertEquals(ownerId, owner.getId());
    }

    @Test
    void saveExistingId() {
        Long id = 7L;
        Owner noSavedOwner = Owner.builder().id(id).build();
        Owner savedOwner = ownerMapService.save(noSavedOwner);

        assertEquals(savedOwner, noSavedOwner);

    }

    @Test
    void saveNoId() {
        Owner noSavedOwner = Owner.builder().build();
        Owner savedOwner = ownerMapService.save(noSavedOwner);

        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());

    }

    @Test
    void delete() {
        int totalOwners = ownerMapService.findAll().size();
        ownerMapService.delete(ownerMapService.findById(ownerId));

        assertEquals(totalOwners-1, ownerMapService.findAll().size());
    }

    @Test
    void deleteById() {
        int totalOwners = ownerMapService.findAll().size();
        ownerMapService.deleteById(ownerId);

        assertEquals(totalOwners-1, ownerMapService.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner morales = ownerMapService.findByLastName(ownerLastName);
        assertNotNull(morales);

        assertEquals(ownerId, morales.getId());
    }

    @Test
    void findByLastNameNotFound() {
        Owner morales = ownerMapService.findByLastName("foo");
        assertNull(morales);

    }
}