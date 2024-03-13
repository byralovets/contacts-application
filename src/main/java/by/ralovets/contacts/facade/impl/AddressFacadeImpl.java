package by.ralovets.contacts.facade.impl;

import by.ralovets.contacts.data.mapper.ContactAddressMapper;
import by.ralovets.contacts.data.request.CreateAddressDTO;
import by.ralovets.contacts.data.request.UpdateAddressDTO;
import by.ralovets.contacts.data.response.ContactAddressDTO;
import by.ralovets.contacts.entity.Contact;
import by.ralovets.contacts.entity.ContactAddress;
import by.ralovets.contacts.facade.AddressFacade;
import by.ralovets.contacts.service.ContactAddressService;
import by.ralovets.contacts.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class AddressFacadeImpl implements AddressFacade {

    private final ContactAddressService addressService;
    private final ContactService contactService;
    private final ContactAddressMapper addressMapper;

    @Override
    @Transactional
    public ContactAddressDTO createAddress(Long contactId, CreateAddressDTO data) {
        final Contact contact = contactService.findById(contactId);
        final ContactAddress address = addressMapper.toEntity(data);

        contact.addAddress(address);

        contactService.save(contact);

        return addressMapper.toDTO(address);
    }

    @Override
    @Transactional
    public ContactAddressDTO updateAddressById(Long addressId, Long contactId, UpdateAddressDTO data) {
        ContactAddress address = addressService.findByIdAndContactId(addressId, contactId);

        address = addressMapper.toExistingEntity(data, address);
        address = addressService.save(address);

        return addressMapper.toDTO(address);
    }

    @Override
    @Transactional
    public void deleteAddressById(Long addressId, Long contactId) {
        addressService.deleteByIdAndContactId(addressId, contactId);
    }
}
