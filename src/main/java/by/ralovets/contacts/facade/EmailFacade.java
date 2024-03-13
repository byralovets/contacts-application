package by.ralovets.contacts.facade;

import by.ralovets.contacts.data.request.CreateEmailDTO;
import by.ralovets.contacts.data.request.UpdateEmailDTO;
import by.ralovets.contacts.data.response.ContactEmailDTO;

public interface EmailFacade {

    ContactEmailDTO createEmail(Long contactId, CreateEmailDTO data);

    ContactEmailDTO updateEmailById(Long contactId, Long emailId, UpdateEmailDTO data);

    void deleteEmailById(Long contactId, Long emailId);
}
