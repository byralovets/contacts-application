package by.ralovets.contacts.repository;

import by.ralovets.contacts.entity.Contact;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.Optional;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    @EntityGraph(attributePaths = {"emails", "phones", "addresses"})
    @NonNull Optional<Contact> findById(@NonNull Long id);
}
