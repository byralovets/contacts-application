package by.ralovets.contacts.repository;

import by.ralovets.contacts.entity.ContactAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.Optional;

public interface ContactAddressRepository extends JpaRepository<ContactAddress, Long> {

    @NonNull
    Optional<ContactAddress> findByIdAndContactId(Long addressId, Long contactId);

    @NonNull
    void deleteByIdAndContactId(Long addressId, Long contactId);
}
