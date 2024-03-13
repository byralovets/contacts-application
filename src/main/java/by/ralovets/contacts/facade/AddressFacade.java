package by.ralovets.contacts.facade;

import by.ralovets.contacts.data.request.CreateAddressDTO;
import by.ralovets.contacts.data.request.UpdateAddressDTO;
import by.ralovets.contacts.data.response.ContactAddressDTO;

public interface AddressFacade {

    ContactAddressDTO createAddress(Long contactId, CreateAddressDTO data);

    ContactAddressDTO updateAddressById(Long contactId, Long addressId, UpdateAddressDTO data);

    void deleteAddressById(Long addressId, Long contactId);
}
