package by.ralovets.contacts.service;

import by.ralovets.contacts.entity.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContactService {

    Contact save(Contact contact);

    Page<Contact> findPage(Pageable pageable);

    Contact findById(Long id);

    void deleteById(Long id);
}
