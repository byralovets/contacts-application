package by.ralovets.contacts.service.impl;

import by.ralovets.contacts.entity.ContactPhone;
import by.ralovets.contacts.repository.ContactPhoneRepository;
import by.ralovets.contacts.service.ContactPhoneService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ContactPhoneServiceImpl implements ContactPhoneService {

    public static final String PHONE_NOT_FOUND_MESSAGE = "Phone with id '%d' for contact with id '%d' doesn't exist";

    private final ContactPhoneRepository phoneRepository;

    @Override
    @Transactional
    public ContactPhone save(ContactPhone phone) {
        return phoneRepository.save(phone);
    }

    @Override
    @Transactional
    public ContactPhone findByIdAndContactId(Long phoneId, Long contactId) {
        return phoneRepository.findByIdAndContactId(phoneId, contactId)
                .orElseThrow(() -> {
                    final String message = PHONE_NOT_FOUND_MESSAGE.formatted(phoneId, contactId);
                    return new EntityNotFoundException(message);
                });
    }

    @Override
    @Transactional
    public void deleteByIdAndContactId(Long phoneId, Long contactId) {
        phoneRepository.deleteByIdAndContactId(phoneId, contactId);
    }
}
