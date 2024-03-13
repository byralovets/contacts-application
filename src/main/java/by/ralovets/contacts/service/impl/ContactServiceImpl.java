package by.ralovets.contacts.service.impl;

import by.ralovets.contacts.entity.Contact;
import by.ralovets.contacts.repository.ContactRepository;
import by.ralovets.contacts.service.ContactService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

    public static final String CONTACT_NOT_FOUND_MESSAGE = "Contact with id '%d' doesn't exist";

    private final ContactRepository contactRepository;

    @Override
    @Transactional(readOnly = true)
    public Contact findById(Long id) {
        return contactRepository.findById(id).orElseThrow(() -> {
            final String message = CONTACT_NOT_FOUND_MESSAGE.formatted(id);
            return new EntityNotFoundException(message);
        });
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Contact> findPage(Pageable pageable) {
        return contactRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        contactRepository.deleteById(id);
    }
}
