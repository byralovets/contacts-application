package by.ralovets.contacts.repository;

import by.ralovets.contacts.entity.ContactEmail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.Optional;

public interface ContactEmailRepository extends JpaRepository<ContactEmail, Long> {

    @NonNull
    Optional<ContactEmail> findByIdAndContactId(Long emailId, Long contactId);

    @NonNull
    void deleteByIdAndContactId(Long emailId, Long contactId);
}
