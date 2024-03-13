package by.ralovets.contacts.repository;

import by.ralovets.contacts.entity.ContactPhone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.Optional;

public interface ContactPhoneRepository extends JpaRepository<ContactPhone, Long> {

    @NonNull
    Optional<ContactPhone> findByIdAndContactId(Long phoneId, Long contactId);

    @NonNull
    void deleteByIdAndContactId(Long phoneId, Long contactId);
}
