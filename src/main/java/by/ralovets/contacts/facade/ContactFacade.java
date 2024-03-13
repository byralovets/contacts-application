package by.ralovets.contacts.facade;

import by.ralovets.contacts.data.request.CreateContactDTO;
import by.ralovets.contacts.data.request.UpdateContactDTO;
import by.ralovets.contacts.data.response.ContactDTO;
import org.springframework.data.domain.Page;

public interface ContactFacade {

    ContactDTO createContact(CreateContactDTO data);

    Page<ContactDTO> findContacts(Integer page, Integer size);

    ContactDTO findContactById(Long id);

    ContactDTO updateContactById(Long id, UpdateContactDTO data);

    void deleteContactById(Long id);
}
