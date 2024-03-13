package by.ralovets.contacts.service;

import by.ralovets.contacts.entity.ContactPhone;

public interface ContactPhoneService {

    ContactPhone save(ContactPhone phone);

    ContactPhone findByIdAndContactId(Long phoneId, Long contactId);

    void deleteByIdAndContactId(Long contactId, Long phoneId);
}
