package by.ralovets.contacts.service;

import by.ralovets.contacts.entity.ContactEmail;

public interface ContactEmailService {

    ContactEmail save(ContactEmail email);

    ContactEmail findByIdAndContactId(Long emailId, Long contactId);

    void deleteByIdAndContactId(Long contactId, Long emailId);
}
