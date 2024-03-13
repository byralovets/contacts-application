package by.ralovets.contacts.service;

import by.ralovets.contacts.entity.ContactAddress;

public interface ContactAddressService {

    ContactAddress save(ContactAddress address);

    ContactAddress findByIdAndContactId(Long addressId, Long contactId);

    void deleteByIdAndContactId(Long contactId, Long addressId);
}
