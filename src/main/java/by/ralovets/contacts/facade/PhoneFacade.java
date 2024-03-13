package by.ralovets.contacts.facade;

import by.ralovets.contacts.data.request.CreatePhoneDTO;
import by.ralovets.contacts.data.request.UpdatePhoneDTO;
import by.ralovets.contacts.data.response.ContactPhoneDTO;

public interface PhoneFacade {

    ContactPhoneDTO createPhone(Long contactId, CreatePhoneDTO data);

    ContactPhoneDTO updatePhoneById(Long contactId, Long phoneId, UpdatePhoneDTO data);

    void deletePhoneById(Long contactId, Long phoneId);
}
