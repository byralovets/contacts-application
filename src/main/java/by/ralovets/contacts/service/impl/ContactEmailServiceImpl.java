package by.ralovets.contacts.service.impl;

import by.ralovets.contacts.entity.ContactEmail;
import by.ralovets.contacts.repository.ContactEmailRepository;
import by.ralovets.contacts.service.ContactEmailService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ContactEmailServiceImpl implements ContactEmailService {

    public static final String EMAIL_NOT_FOUND_MESSAGE = "Email with id '%d' for contact with id '%d' doesn't exist";

    private final ContactEmailRepository emailRepository;

    @Override
    @Transactional
    public ContactEmail save(ContactEmail email) {
        return emailRepository.save(email);
    }

    @Override
    @Transactional
    public ContactEmail findByIdAndContactId(Long emailId, Long contactId) {
        return emailRepository.findByIdAndContactId(emailId, contactId)
                .orElseThrow(() -> {
                    final String message = EMAIL_NOT_FOUND_MESSAGE.formatted(emailId, contactId);
                    return new EntityNotFoundException(message);
                });
    }

    @Override
    @Transactional
    public void deleteByIdAndContactId(Long emailId, Long contactId) {
        emailRepository.deleteByIdAndContactId(emailId, contactId);
    }
}
