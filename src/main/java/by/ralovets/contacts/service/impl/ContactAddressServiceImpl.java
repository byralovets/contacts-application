package by.ralovets.contacts.service.impl;

import by.ralovets.contacts.entity.ContactAddress;
import by.ralovets.contacts.repository.ContactAddressRepository;
import by.ralovets.contacts.service.ContactAddressService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ContactAddressServiceImpl implements ContactAddressService {

    public static final String ADDRESS_NOT_FOUND_MESSAGE = "Address with id '%d' for contact with id '%d' doesn't exist";

    private final ContactAddressRepository addressRepository;

    @Override
    @Transactional
    public ContactAddress save(ContactAddress address) {
        return addressRepository.save(address);
    }

    @Override
    @Transactional
    public ContactAddress findByIdAndContactId(Long addressId, Long contactId) {
        return addressRepository.findByIdAndContactId(addressId, contactId)
                .orElseThrow(() -> {
                    final String message = ADDRESS_NOT_FOUND_MESSAGE.formatted(addressId, contactId);
                    return new EntityNotFoundException(message);
                });
    }

    @Override
    @Transactional
    public void deleteByIdAndContactId(Long addressId, Long contactId) {
        addressRepository.deleteByIdAndContactId(addressId, contactId);
    }
}
